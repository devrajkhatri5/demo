package System.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.employeeInfo.DatabaseConnection.oracleConnection;



public class LoginDAO extends oracleConnection {
	private static Connection con = null;
	private static PreparedStatement stmt = null;

	public LoginDAO() {
		super();
	}

	public  static boolean validateUser(String userID, String Password) {

		try {

			con = oracleConnection.getConnection();
			stmt = con.prepareStatement("Select UserID,Password from UserInfo where UserID =?and Password = ?");
			stmt.setString(1, userID);
			stmt.setString(2, Password);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				// result found, means valid inputs
				return true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Login error -->" + ex.getMessage());
			return false;
		} finally {
			oracleConnection.close(con);
		}
		return false;

	}

	

}

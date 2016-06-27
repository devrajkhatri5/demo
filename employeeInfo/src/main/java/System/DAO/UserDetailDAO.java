package System.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.employeeInfo.DatabaseConnection.oracleConnection;

import employeeInfo.Model.District;
import employeeInfo.Model.State;
import employeeInfo.Model.UserDetail;
import employeeInfo.Model.UserDetailDTO;


public class UserDetailDAO extends oracleConnection {
	private static Connection con = null;
	private static PreparedStatement stmt = null;

	// getting userDetails
	public List<UserDetailDTO> getUserDetail()

	{
		List<UserDetailDTO> users = new ArrayList<UserDetailDTO>();

		try {

			con = oracleConnection.getConnection();
			StringBuffer sql =new StringBuffer();
			sql.append("SELECT userInfo.UserID,userInfo.Firstname,userInfo.Lastname,userInfo.Email,userinfo.Sex,userinfo.age,state.StateName,district.Districtname ");
			sql.append("FROM userinfo,state,district WHERE userinfo.Stateid=district.Stateid AND userinfo.Districtid=district.DistrictId AND state.Stateid=district.Stateid");
			stmt = con.prepareStatement(sql.toString());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				UserDetailDTO user = new UserDetailDTO();
				user.setUserID(rs.getString("UserID"));
				user.setFirstname(rs.getString("Firstname"));
				user.setLastName(rs.getString("LastName"));
				user.setEmail(rs.getString("Email"));
				user.setAge(rs.getInt("Age"));
				user.setSex(rs.getString("sex"));
				user.setDistrictName(rs.getString("DistrictName"));
				user.setStateName(rs.getString("StateName"));

				users.add(user);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Login error -->" + ex.getMessage());
		} finally {
			oracleConnection.close(con);
		}

		return users;
	}

	// add employee
	public boolean addUser(UserDetail user) {

		con = oracleConnection.getConnection();

		// getUser to check for duplicate entry
		try {
			stmt = con
					.prepareStatement("Select UserID from UserInfo where UserID=?");
			stmt.setString(1, user.getUserID());
			ResultSet rs = stmt.executeQuery();
			if (!rs.next()) {
				stmt = con.prepareStatement("Insert Into UserInfo values"
						+ "(?,?,?,?,?,?,?,?,?)");
				stmt.setString(1, user.getUserID());
				stmt.setString(2, user.getFirstname());
				stmt.setString(3, user.getLastName());
				stmt.setString(4, user.getPassword());
				stmt.setString(5, user.getEmail());
				stmt.setInt(6, user.getAge());
				stmt.setString(7, user.getSex());
				stmt.setString(8, user.getStateID());
				stmt.setString(9, user.getDistrictID());
				stmt.executeQuery();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Login error -->" + ex.getMessage());
			return false;

		} finally {
			oracleConnection.close(con);
			return true;
		}

	}

public boolean deleteUser(String userID)
{
	con = oracleConnection.getConnection();
	try {
		stmt = con.prepareStatement("Delete from UserInfo where UserID=?");
		stmt.setString(1, userID);
		stmt.executeQuery();
		return true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return false;
	
	
}
public Map<String, String> getStateList() 
{
	Map<String, String> myMap = new HashMap<String, String>();
	State state=new State();
	
	con = oracleConnection.getConnection();
	try {
		stmt = con.prepareStatement("Select StateID,StateName from state");
		ResultSet rs=stmt.executeQuery();
		while(rs.next())
		{
		state.setStateID(rs.getString("StateID"));
		state.setStateName(rs.getString("StateName"));
		 myMap.put(state.getStateID(),state.getStateName());
		
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("Login error -->" + e.getMessage());
		
	}finally {
		oracleConnection.close(con);
	
	}
	return myMap;
}
public Map<String, String> getDistrictList(String stateID) 
{
	Map<String, String> myMap = new HashMap<String, String>();
	District district=new District();
	con = oracleConnection.getConnection();
	try {
		stmt = con.prepareStatement("Select DistrictID,DistrictName from District where StateID=?");
		stmt.setString(1,stateID);
		ResultSet rs=stmt.executeQuery();
		while(rs.next())
		{
		district.setDistrictID(rs.getString("DistrictID"));
		district.setDistrictName(rs.getString("DistrictName"));
		 myMap.put( district.getDistrictID(),district.getDistrictName());
		
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("Login error -->" + e.getMessage());
		
	}finally {
		oracleConnection.close(con);
	
	}
	return myMap;
}


}




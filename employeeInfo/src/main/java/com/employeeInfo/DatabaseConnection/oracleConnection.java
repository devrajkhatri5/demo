package com.employeeInfo.DatabaseConnection;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class oracleConnection {

	public static Connection getConnection() {
		try {
		//Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@(DESCRIPTION=(LOAD_BALANCE=yes)(FAILOVER=ON)(ADDRESS=(PROTOCOL=TCP)(HOST=NVMNSDBD1.D2HAWKEYE.NET)(PORT=1521))(CONNECT_DATA=(SERVER=DEDICATED)(SERVICE_NAME=d2he)))"
,"i82717","oracle");
			return con;
		} catch (Exception ex) {
			System.out.println("Database.getConnection() Error -->"
					+ ex.getMessage());
			return null;
		}
	}

	public static void close(Connection con) {
		try {
			con.close();
		} catch (Exception ex) {
		}
	}
}
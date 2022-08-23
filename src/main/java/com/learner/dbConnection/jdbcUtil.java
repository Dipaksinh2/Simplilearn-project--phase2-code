package com.learner.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbcUtil {
	public static String dbUrl = "jdbc:mysql://localhost:3306/learner?useSSL=false";
	public static String dbUname = "root";
	public static String dbPassword = "root12345";
	public static String dbDriver = "com.mysql.cj.jdbc.Driver";

	public static Connection getConnection() {
		System.out.println("Calling getConnection");
		Connection conn = null;
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {

			conn = DriverManager.getConnection(dbUrl, dbUname, dbPassword);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		System.out.println(conn);
		return conn;
	}
}

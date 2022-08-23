package com.learners.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.learner.dbConnection.jdbcUtil;
import com.learners.model.Classes;

public class ClassesDao {
	Connection conn = null;

	private static final String INSERT_CLASSES = "INSERT INTO classes (class_name) values(?);";
	private static final String SELECT_ALL_CLASSES = "SELECT * FROM classes;";
	
	//Insert Classes
	public void insertClass(Classes classes) throws Exception {
		conn = jdbcUtil.getConnection();
		System.out.println("Insert query passed from insertClasses");
		PreparedStatement ps = conn.prepareStatement(INSERT_CLASSES);
		ps.setString(1, classes.getClass_name());		
		ps.executeUpdate();
		System.out.println("Data inserted");
		conn.close();
	}
	
	// select all Classes 
		public List<Classes> selectAllClasses() throws SQLException, Exception {
			List<Classes> classes = new ArrayList<Classes>();
			conn = jdbcUtil.getConnection();
			PreparedStatement stmnt = conn.prepareStatement(SELECT_ALL_CLASSES);

			ResultSet rs = stmnt.executeQuery();
			while (rs.next()) {
				int class_id = rs.getInt("class_id");
				String class_name = rs.getString("class_name");
				System.out.println(class_id + class_name +" - "	+ "This data from selectAllClasses");
				classes.add(new Classes(class_id, class_name));
				System.out.println(classes);
			}
			conn.close();
			return classes;
		}

}

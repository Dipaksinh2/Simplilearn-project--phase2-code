package com.learners.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.learner.dbConnection.jdbcUtil;
import com.learners.model.Teacher;

//Provide operation for teacher
public class TeacherDao {	
	Connection conn=null;

	private static final String INSERT_TEACHERS = "INSERT INTO teachers "
			+ "(teacher_name,teacher_email,teacher_class) values" + "(?,?,?);";

	private static final String SELECT_TEACHER_BY_ID = "SELECT teacher_id,teacher_name,teacher_email,teacher_class "
			+ "from teachers where teacher_id=?;";
	private static final String SELECT_ALL_TEACHERS = "SELECT * FROM teachers;";
	private static final String DELETE_TEACHERS = "DELETE FROM teachers where teacher_id=?;";
	private static final String UPDATE_TEACHERS = "UPDATE teachers SET teacher_name=?,teacher_email=?,teacher_class=? WHERE teacher_id=?;";

	// Insert teachers
	public void insertTeacher(Teacher teacher) throws Exception {
		
		conn=jdbcUtil.getConnection();		
		PreparedStatement ps = conn.prepareStatement(INSERT_TEACHERS);
		ps.setString(1, teacher.getTeacher_name());
		ps.setString(2, teacher.getTeacher_email());
		ps.setInt(3, teacher.getTeacher_class());
		ps.executeUpdate();
		System.out.println("Data inserted");
		conn.close();
	}

	// Update teachers
	public boolean updateTeacher(Teacher teacher) throws Exception {
		boolean rowUpdated;
		conn=jdbcUtil.getConnection();
		PreparedStatement pstmnt = conn.prepareStatement(UPDATE_TEACHERS);
		pstmnt.setString(1, teacher.getTeacher_name());
		pstmnt.setString(2, teacher.getTeacher_email());
		pstmnt.setInt(3, teacher.getTeacher_class());
		pstmnt.setInt(4, teacher.getTeacher_id());
		rowUpdated = pstmnt.executeUpdate() > 0;
		System.out.println("Data updated");
		conn.close();
		return rowUpdated;
		
	}

	// Select teachers by id
	public Teacher selectTeacher(int teacher_id) throws SQLException {
		Teacher teacher = null;
		conn=jdbcUtil.getConnection();
		PreparedStatement stmnt = conn.prepareStatement(SELECT_TEACHER_BY_ID);
		stmnt.setInt(1, teacher_id);
		System.out.println(stmnt);

		ResultSet rs = stmnt.executeQuery();
		while (rs.next()) {
			String teacher_name = rs.getString("teacher_name");
			String teacher_email = rs.getString("teacher_email");
			int teacher_class = rs.getInt("teacher_class");
			
			System.out.println(teacher_name + teacher_email + teacher_class);
			

			teacher = new Teacher(teacher_id, teacher_name, teacher_email, teacher_class);
		}
		conn.close();
		return teacher;

	}

	// select all teachers
	public List<Teacher> selectAllTeachers() throws SQLException,Exception {
		List<Teacher> teacher = new ArrayList<Teacher>();
		conn=jdbcUtil.getConnection();
		PreparedStatement stmnt = conn.prepareStatement(SELECT_ALL_TEACHERS);	

		ResultSet rs = stmnt.executeQuery();
		while (rs.next()) {
			int teacher_id = rs.getInt("teacher_id");
			String teacher_name = rs.getString("teacher_name");
			String teacher_email = rs.getString("teacher_email");
			int teacher_class =rs.getInt("teacher_class");

			System.out.println(teacher_id + teacher_name + teacher_email + teacher_class +" - "+"This data from selectAllTeacher");
			teacher.add(new Teacher(teacher_id,teacher_name,teacher_email,teacher_class));
			System.out.println(teacher);
		}
		conn.close();
		return teacher;
	}

	// delete teachers
	public boolean deleteTeacher(int teacher_id) throws SQLException {
		boolean rowDeleted;
		conn=jdbcUtil.getConnection();
		PreparedStatement stmnt = conn.prepareStatement(DELETE_TEACHERS);
		stmnt.setInt(1, teacher_id);
		rowDeleted = stmnt.executeUpdate() > 0;
		conn.close();
		return rowDeleted;

	}

}

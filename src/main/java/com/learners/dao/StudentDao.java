package com.learners.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.learner.dbConnection.jdbcUtil;
import com.learners.model.Student;

public class StudentDao {
	Connection conn = null;

	private static final String INSERT_STUDENT = "INSERT INTO students "
			+ "(student_name,class_id,student_address,student_mobile) values" + "(?,?,?,?);";

	private static final String SELECT_STUDENT_BY_ID = "SELECT student_id,student_name,class_id,student_address,student_mobile "
			+ "from students where student_id=?;";
	private static final String SELECT_ALL_STUDENTS = "SELECT * FROM students;";
	private static final String DELETE_STUDENT = "DELETE FROM students where student_id=?;";
	private static final String UPDATE_STUDENT = "UPDATE students SET student_name=?,class_id=?,student_address=?,student_mobile=? WHERE student_id=?;";

	// Insert Student
	public void insertStudent(Student student) throws Exception {

		conn = jdbcUtil.getConnection();
		System.out.println("Insert query passed from insertStudent");
		PreparedStatement ps = conn.prepareStatement(INSERT_STUDENT);
		ps.setString(1, student.getStudent_name());
		ps.setInt(2, student.getClass_id());
		ps.setString(3, student.getStudent_address());
		ps.setString(4, student.getStudent_mobile());
		ps.executeUpdate();
		System.out.println("Data inserted");
		conn.close();
	}

	// Update Student
	public boolean updateStudent(Student student) throws Exception {
		boolean rowUpdated;
		conn = jdbcUtil.getConnection();
		PreparedStatement ps = conn.prepareStatement(UPDATE_STUDENT);
		ps.setString(1, student.getStudent_name());
		ps.setInt(2, student.getClass_id());
		ps.setString(3, student.getStudent_address());
		ps.setString(4, student.getStudent_mobile());
		ps.setInt(5, student.getStudent_id());
		rowUpdated = ps.executeUpdate() > 0;
		System.out.println("Data updated");
		conn.close();
		return rowUpdated;
	}

	// Select Student by id
	public Student selectStudent(int student_id) throws SQLException {
		Student student = null;
		conn = jdbcUtil.getConnection();
		PreparedStatement stmnt = conn.prepareStatement(SELECT_STUDENT_BY_ID);
		stmnt.setInt(1, student_id);
		System.out.println(stmnt);

		ResultSet rs = stmnt.executeQuery();
		while (rs.next()) {
			String student_name = rs.getString("student_name");
			int class_id = rs.getInt("class_id");
			String student_address = rs.getString("student_address");
			String student_mobile = rs.getString("student_mobile");

			System.out.println(student_name + class_id + student_address + student_mobile);

			student = new Student(student_id, student_name, class_id, student_address, student_mobile);
		}
		conn.close();
		return student;

	}

	// select all Students
	public List<Student> selectAllStudents() throws SQLException, Exception {
		List<Student> student = new ArrayList<Student>();
		conn = jdbcUtil.getConnection();
		PreparedStatement stmnt = conn.prepareStatement(SELECT_ALL_STUDENTS);

		ResultSet rs = stmnt.executeQuery();
		while (rs.next()) {
			int student_id = rs.getInt("student_id");
			String student_name = rs.getString("student_name");
			int class_id = rs.getInt("class_id");
			String student_address = rs.getString("student_address");
			String student_mobile = rs.getString("student_mobile");

			System.out.println(student_id + student_name + class_id + student_address + student_mobile + " - "
					+ "This data from selectAllStudents");
			student.add(new Student(student_id, student_name, class_id, student_address, student_mobile));
			System.out.println(student);
		}
		conn.close();
		return student;
	}

	// delete Students
	public boolean deleteStudent(int student_id) throws SQLException {
		boolean rowDeleted;
		conn = jdbcUtil.getConnection();
		PreparedStatement stmnt = conn.prepareStatement(DELETE_STUDENT);
		stmnt.setInt(1, student_id);
		rowDeleted = stmnt.executeUpdate() > 0;
		conn.close();
		return rowDeleted;
	}

}

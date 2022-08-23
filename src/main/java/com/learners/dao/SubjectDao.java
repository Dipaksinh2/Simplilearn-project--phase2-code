package com.learners.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.learner.dbConnection.jdbcUtil;
import com.learners.model.Subject;

public class SubjectDao {

	Connection conn = null;

	private static final String INSERT_SUBJECT = "INSERT INTO subjects " + "(teacher_id,subject_name) values"
			+ "(?,?);";

	private static final String SELECT_SUBJECT_BY_ID = "SELECT subject_id,teacher_id,subject_name "
			+ "from subjects where subject_id=?;";
	private static final String SELECT_ALL_SUBJECTS = "SELECT * FROM subjects;";
	private static final String DELETE_SUBJECT = "DELETE FROM subjects where subject_id=?;";
	private static final String UPDATE_SUBJECT = "UPDATE subjects SET teacher_id=?,subject_name=? WHERE subject_id=?;";

	// Insert Subject
	public void insertSubject(Subject subject) throws Exception {

		conn = jdbcUtil.getConnection();
		System.out.println("Insert query passed from insertSubject");
		PreparedStatement ps = conn.prepareStatement(INSERT_SUBJECT);
		ps.setInt(1, subject.getTeacher_id());
		ps.setString(2, subject.getSubject_name());
		ps.executeUpdate();
		System.out.println("Data inserted");
		conn.close();
	}

	// Update Subject
	public boolean updateSubject(Subject subject) throws Exception {
		boolean rowUpdated;
		conn = jdbcUtil.getConnection();
		PreparedStatement ps = conn.prepareStatement(UPDATE_SUBJECT);
		ps.setInt(1, subject.getTeacher_id());
		ps.setString(2, subject.getSubject_name());
		ps.setInt(3, subject.getSubject_id());
		rowUpdated = ps.executeUpdate() > 0;
		System.out.println("Data updated");
		conn.close();
		return rowUpdated;
	}

	// Select Subject by id
	public Subject selectSubject(int subject_id) throws SQLException {
		Subject subject = null;
		conn = jdbcUtil.getConnection();
		PreparedStatement stmnt = conn.prepareStatement(SELECT_SUBJECT_BY_ID);
		stmnt.setInt(1, subject_id);
		System.out.println(stmnt);

		ResultSet rs = stmnt.executeQuery();
		while (rs.next()) {
			int teacher_id = rs.getInt("teacher_id");
			String subject_name = rs.getString("subject_name");
			System.out.println(teacher_id + subject_name);
			subject = new Subject(subject_id, teacher_id, subject_name);
		}
		conn.close();
		return subject;
	}

	// select all Students
	public List<Subject> selectAllSubjects() throws SQLException, Exception {
		List<Subject> subject = new ArrayList<Subject>();
		conn = jdbcUtil.getConnection();
		PreparedStatement stmnt = conn.prepareStatement(SELECT_ALL_SUBJECTS);

		ResultSet rs = stmnt.executeQuery();
		while (rs.next()) {
			int subject_id = rs.getInt("subject_id");
			int teacher_id = rs.getInt("teacher_id");
			String subject_name = rs.getString("subject_name");

			System.out.println(subject_id + teacher_id + subject_name + " - " + "This data from selectAllStudents");
			subject.add(new Subject(subject_id, teacher_id, subject_name));
			System.out.println(subject);
		}
		conn.close();
		return subject;
	}

	// delete Subject
	public boolean deleteSubject(int subject_id) throws SQLException {
		boolean rowDeleted;
		conn = jdbcUtil.getConnection();
		PreparedStatement stmnt = conn.prepareStatement(DELETE_SUBJECT);
		stmnt.setInt(1, subject_id);
		rowDeleted = stmnt.executeUpdate() > 0;
		conn.close();
		return rowDeleted;
	}

}

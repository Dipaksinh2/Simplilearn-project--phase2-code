package com.learners.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.learner.dbConnection.jdbcUtil;
import com.learners.model.User;

public class LoginDao {

	Connection conn = null;

	public boolean validate(User user) {

		boolean status = false;
		conn = jdbcUtil.getConnection();
		String sqlquery = "select * from user_data where user_name=? and user_pwd=?";
		PreparedStatement ps;
		ResultSet rs;
		try {
			ps = conn.prepareStatement(sqlquery);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			rs = ps.executeQuery();
			status = rs.next();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

}

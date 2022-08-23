package com.learners.servlet;

import java.io.IOException;

import com.learners.dao.LoginDao;
import com.learners.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		System.out.println("Username :- " + username);
		System.out.println("Password :- " + password);

		User user = new User();
		user.setUsername(username);
		user.setPassword(password);

		LoginDao logindao = new LoginDao();
		if (logindao.validate(user)==true) {
			response.sendRedirect("loginSuccess.jsp");
		} else {
			response.sendRedirect("loginAgain.jsp");
		}
	}

}

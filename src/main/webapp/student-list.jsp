<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Student Management</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: teal;">
			<div>
				<a href="<%=request.getContextPath()%>/listStudent" class="navbar-brand">
					Student's Details </a>
			</div>

			<div class="navbar-nav">
				<a href="loginSuccess.jsp" class="navbar-brand">Home</a>
			</div>
		</nav>
	</header>
	<br>

	<div class="row">
		<div class="container">
			<h3 class="text-center">List of Students</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/newStudent" class="btn btn-success">Add
					New Student</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Student ID</th>
						<th>Full Name</th>
						<th>Class Number</th>
						<th>Address</th>
						<th>Mobile No.</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listStudent}" var="s">
						<tr>
							<td><c:out value="${s.student_id}"></c:out></td>
							<td><c:out value="${s.student_name}"></c:out></td>
							<td><c:out value="${s.class_id}"></c:out></td>
							<td><c:out value="${s.student_address}"></c:out></td>
							<td><c:out value="${s.student_mobile}"></c:out></td>
							<td><a
								href="editStudent?student_id=<c:out value='${s.student_id}' />">Edit

							</a> &nbsp;&nbsp;&nbsp;&nbsp; <a
								href="deleteStudent?student_id=<c:out value='${s.student_id}' />">Delete
							</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
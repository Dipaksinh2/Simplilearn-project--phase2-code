<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Teacher Management</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #2F4F4F;">
			<div>
				<a href="<%=request.getContextPath()%>/listTeacher"
					class="navbar-brand"> Teacher's Details </a>
			</div>

			<div class="navbar-nav">
				<a href="loginSuccess.jsp" class="navbar-brand">Home</a>
			</div>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Teachers</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/newTeacher"
					class="btn btn-success">Add New Teacher</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Teacher ID</th>
						<th>Teacher Name</th>
						<th>Teacher Email</th>
						<th>Class Number</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listTeacher}" var="t">
						<tr>
							<td><c:out value="${t.teacher_id}"></c:out></td>
							<td><c:out value="${t.teacher_name}"></c:out></td>
							<td><c:out value="${t.teacher_email}"></c:out></td>
							<td><c:out value="${t.teacher_class}"></c:out></td>
							<td><a
								href="editTeacher?teacher_id=<c:out value='${t.teacher_id}' />">Edit

							</a> &nbsp;&nbsp;&nbsp;&nbsp; <a
								href="deleteTeacher?teacher_id=<c:out value='${t.teacher_id}' />">Delete
							</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Subject Management</title>
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
				<a href="<%=request.getContextPath()%>/listSubject" class="navbar-brand">
					Subject's Details </a>
			</div>

			<div class="navbar-nav">
				<a href="loginSuccess.jsp" class="navbar-brand">Home</a>
			</div>
		</nav>
	</header>
	<br>

	<div class="row">
		<div class="container">
			<h3 class="text-center">List of Subjects</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/newSubject" class="btn btn-success">Add
					New Subject</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Subject ID</th>
						<th>Teacher Number</th>
						<th>Subject Name</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listSubject}" var="sub">
						<tr>
							<td><c:out value="${sub.subject_id}"></c:out></td>
							<td><c:out value="${sub.teacher_id }"></c:out></td>
							<td><c:out value="${sub.subject_name}"></c:out></td>
						<td><a
								href="editSubject?subject_id=<c:out value='${sub.subject_id}' />">Edit

							</a> &nbsp;&nbsp;&nbsp;&nbsp; <a
								href="deleteSubject?subject_id=<c:out value='${sub.subject_id}' />">Delete
							</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
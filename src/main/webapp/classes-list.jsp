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
			style="background-color: teal;">
			<div>
				<a href="<%=request.getContextPath()%>/listClasses"
					class="navbar-brand"> Class's Details </a>
			</div>

			<div class="navbar-nav">
				<a href="loginSuccess.jsp" class="navbar-brand">Home</a>
			</div>
		</nav>
	</header>
	<br>

	<div class="row">
		<div class="container">
			<h3 class="text-center">List of Classes</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/newClasses"
					class="btn btn-success">Add New Class</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Class No.</th>
						<th>Class Name</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listClasses}" var="c">
						<tr>
							<td><c:out value="${c.class_id}"></c:out></td>
							<td><c:out value="${c.class_name}"></c:out></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
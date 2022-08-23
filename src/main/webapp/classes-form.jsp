<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Class Management</title>
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
				<a href="<%=request.getContextPath()%>/listClasses" class="navbar-brand">
					Class's Details </a>
			</div>
			<div class="navbar-nav">
				<a href="loginSuccess.jsp" class="navbar-brand">Home</a>
			</div>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${classes == null}">
					<form action="insertClasses" method="post">
				</c:if>
				<div>
					<c:if test="${classes == null}">
            			<h3>Add New Class</h3>
            		</c:if>
				</div>

				<c:if test="${classes == null}">
					<input type="hidden" name="class_id"
						value="<c:out value='${classes.class_id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Class Name</label> <input type="text" placeholder="Enter Class Name"
						value="<c:out value='${classes.class_name}' />" class="form-control"
						name="class_name" required="required">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
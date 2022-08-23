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
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${teacher != null}">
					<form action="updateTeacher" method="post">
				</c:if>
				<c:if test="${teacher == null}">
					<form action="insertTeacher" method="post">
				</c:if>

				<div>
					<c:if test="${teacher != null}">
						<h3>Edit Teacher</h3>
					</c:if>
					<c:if test="${teacher == null}">
						<h3>Add New Teacher</h3>
					</c:if>
				</div>

				<c:if test="${teacher != null}">
					<input type="hidden" name="teacher_id"
						value="<c:out value='${teacher.teacher_id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Full Name</label> <input type="text"
						placeholder="Enter Full Name"
						value="<c:out value='${teacher.teacher_name}' />"
						class="form-control" name="teacher_name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Email-Id</label> <input type="text"
						placeholder="Enter Email-Id"
						value="<c:out value='${teacher.teacher_email}' />"
						class="form-control" name="teacher_email">
				</fieldset>

				<fieldset class="form-group">
					<label>Class Number</label> <input type="text"
						placeholder="Enter Class Number"
						value="<c:out value='${teacher.teacher_class}' />"
						class="form-control" name="teacher_class">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				<br> <b>Write number in class number. Ex:- for 1st Sem
					write 101</b>
				<fieldset>
					<b><u>Class Details</u></b><br> 101-1st Sem<br> 102-2nd
					Sem<br> 103-3rd Sem <br> 104-4th Sem <br> 105-5th
					Sem<br> 106-6th Sem
				</fieldset>
				</form>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
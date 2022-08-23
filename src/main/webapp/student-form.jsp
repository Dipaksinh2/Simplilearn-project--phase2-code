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
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${student != null}">
					<form action="updateStudent" method="post">
				</c:if>
				<c:if test="${student == null}">
					<form action="insertStudent" method="post">
				</c:if>

				<div>
					<c:if test="${student != null}">
            			<h3>Edit Student's Detail</h3>
            		</c:if>
					<c:if test="${student == null}">
            			<h3>Add New Student</h3>
            		</c:if>
				</div>

				<c:if test="${student != null}">
					<input type="hidden" name="student_id"
						value="<c:out value='${student.student_id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Full Name</label> <input type="text" placeholder="Enter Full Name"
						value="<c:out value='${student.student_name}' />" class="form-control"
						name="student_name" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Class Name</label> <input type="text" placeholder="Enter Class Number"
						value="<c:out value='${student.class_id}' />" class="form-control"
						name="class_id" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Address</label> <input type="text" placeholder="Enter Full Address"
						value="<c:out value='${student.student_address}' />" class="form-control"
						name="student_address">
				</fieldset>

				<fieldset class="form-group">
					<label>Mobile No.</label> <input type="text" placeholder="Enter Mobile number"
						value="<c:out value='${student.student_mobile}' />" class="form-control"
						name="student_mobile">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				<b>Write number in class number. Ex:- for 1st Sem write 101</b>
				<fieldset> <b><u>Class Details</u></b><br>
					101-1st Sem<br> 102-2nd Sem<br> 103-3rd Sem <br>
					104-4th Sem <br> 105-5th Sem<br> 106-6th Sem
				</fieldset>
				</form>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
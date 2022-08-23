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
				<a href="<%=request.getContextPath()%>/listSubject"
					class="navbar-brand"> Subject's Details </a>
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
				<c:if test="${subject != null}">
					<form action="updateSubject" method="post">
				</c:if>
				<c:if test="${subject == null}">
					<form action="insertSubject" method="post">
				</c:if>

				<div>
					<c:if test="${subject != null}">
						<h3>Edit Subject's Detail</h3>
					</c:if>
					<c:if test="${subject == null}">
						<h3>Add New Subject</h3>
					</c:if>
				</div>

				<c:if test="${subject != null}">
					<input type="hidden" name="subject_id"
						value="<c:out value='${subject.subject_id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Teacher Id</label> <input type="text"
						placeholder="Enter CTeacher Number"
						value="<c:out value='${subject.teacher_id}' />"
						class="form-control" name="teacher_id" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Subject Name</label> <input type="text"
						placeholder="Enter Full Address"
						value="<c:out value='${subject.subject_name}' />"
						class="form-control" name="subject_name">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				<b>Write number in Teacher id. Ex:- for Ran Vijay sir write 1</b>
				<fieldset>
					<b><u>Teacher's Detail</u></b><br> 1-Rahul Sir<br>2-Ran
					Vijay Sir<br>3-Shyam Sundar Sir<br>4-Ramanujan Das Sir<br>5-Sashi
					Dharan Sir
				</fieldset>
				</form>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
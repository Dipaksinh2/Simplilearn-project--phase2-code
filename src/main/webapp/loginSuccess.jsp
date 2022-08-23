<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<style type="text/css">
body {
	background: #87CEFA;
	user-select: none;
	overflow-y: hidden;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 90vh;
}

.container {
	padding: 100px;
	background: #FFF8DC;
	border-radius: 30px;
}

ul {
	float: left;
	display: flex;
	justify-content: center;
	align-items: center;
	color: #DC143C;
}

ul li {
	list-style: none;
	margin-left: 60px;
	margin-top: 30px;
	font-size: 20px;
}

ul li a{
	font-variant: small-caps;
	text-decoration: none;
	color: #2F4F4F;
	font-family: Arial;
	font-weight: bold;
	transition:0.5s ease-in-out;
}

ul li a:hover{
color: #FF4500;
}

h1 {
	font-family: sans-serif;
	font-weight: bolder;
	color: #A0522D;
}
</style>
</head>
<body>
	<div align="center" class="container">
		<h1>WELCOME TO LEARNER'S ACADEMY</h1>
		<ul>
			<li><a href="<%=request.getContextPath()%>/listTeacher"
				class="nav-link">Teacher Corner</a></li>
			<li><a href="<%=request.getContextPath()%>/listStudent"
				class="nav-link">Student Corner</a></li>
			<li><a href="<%=request.getContextPath()%>/listClasses"
				class="nav-link">Class Corner</a></li>
			<li><a href="<%=request.getContextPath()%>/listSubject"
				class="nav-link">Subject Corner</a></li>
			<li><a href="logout.jsp">Logout</a></li>

		</ul>
	</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"html://www.w3.org/TR/html4.loose.dtd">
<html>
<head>
<title>Error</title>
<style type="text/css">

body {
	user-select: none;
	overflow-y: hidden;
	display: flex;
	justify-content: center;
	align-items: center;
	background: #FFFFF0;
	height: 90vh;
}
h1 {
	font-family: monospace;
	font-size: 50px;
	color: #A0522D;
}

h2 {
	font-family: sans-serif;
	font-size: medium;
	color: #DC143C;
}
a{
font-family: sans-serif;
	font-size: medium;
	color: #DC143C;
}
</style>
</head>
<body>
<div class="navbar-nav">
			</div>
	<center>
		<h1>Error</h1>
		<h2><%=exception.getMessage()%></h2>
		<a href="loginSuccess.jsp" class="navbar-brand">Home</a>
	</center>
</body>
</html>
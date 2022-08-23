<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
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

button {
	background-color: #2F4F4F;
	color: white;
	padding: 14px 10px;
	font-size: 15px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 50%;
	border-radius: 20px;
	font-weight: bold;
}

input[type=text], input[type=password] {
	width: 100%;
	background: #F0F8FF;
	padding: 10px 30px;
	margin: 8px 0;
	border: 2px solid #483D8B;
	box-sizing: border-box;
	border-radius: 20px;
}

input[type=text]:hover, input[type=password]:hover {
	background: #F0FFF0;
}

table {
	padding: 200px;
	background: #FFF8DC;
	border-color:black;
	border-radius: 30px;
}

button:hover {
	background: green;
	color: white;
	font-weight: bold;
}

h1 {
	font-family: sans-serif;
	font-size: 80px;
	color: #A0522D;
}

h2 {
	font-family: sans-serif;
	font-size: medium;
	color: #DC143C;
}
</style>
</head>
<body>
	<h1>Learner's <br>Academy<br></h1>
	<div align="left" class="container">

		<form action="LoginServlet" method="post">
			<table>
				<tr>
					<td><h2>User Name</h2></td>
					<td><input type="text" name="username" placeholder="User Name"
						required="required"></td>
				</tr>
				<tr>
					<td><h2>Password</h2></td>
					<td><input type="password" name="password"
						placeholder="Password" required="required"></td>
				</tr>
				<tr>
					<td></td>
					<td><button value="Login">Login</button></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
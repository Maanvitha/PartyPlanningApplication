<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body {
	background: url("img/homeee.jpg");
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size:cover;
}

.nav {
	background: black;
	opacity:0.8;
	margin-top: 160px;
	height: 100px;
	width: 50%;
	opacity: 0.9;
}

ul {
	position: absolute;
	padding: 0;
	margin: 0;
	list-style: none;
}

li {
	float: left;
	margin-top: 30px;
}

a {
	width: 150px;
	color: white;
	display: block;
	text-decoration: none;
	font-size: 20px;
	text-align: center;
	padding: 10px;
	border-radius: 10px;
	font-family: Century Gothic;
	font-weight: bold;
	margin-bottom: 50px;
}

a:hover {
	background: white;
	transition: 0.6s;
}

h1 {
	color: white;
	font-weight: bold;
	font-size: 40px;
	margin-top: 30px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<h1 align="center">Party Planning Management</h1>
<body>
	<form:form>
		<div class="nav">
			<ul>
				<li><a href="/UserSigninPage" style="margin-left: 100px;">Login
						as User</a></li>
				<li style="margin-left: 180px;"><a href="/AdminSigninPage">Login
						as Admin</a></li>
			</ul>
		</div>
	</form:form>
</body>
</html>
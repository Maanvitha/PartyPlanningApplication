<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reset Password</title>


<style>

body {
     background: url("img/log.jpg");
     background-repeat: no-repeat;
     background-attachment: fixed;
     background-size: cover;
}

p {
     font-size: 30px;
     color:#B5EFF2 ;
     font-weight:bold;
}
td{
font-size: 20px;
     color:#B5EFF2;
}
.login-box{
width:500px;
height:440px;
background:black;
opacity:0.8;
color:#fff;
top:50%;
left:50%;
position:absolute;
transform:translate(-50%,-50%);
box-sizing:border-box;
padding:70px 30px;
line-height:30px;
}
</style>


</head>
<center>
<div class="login-box">
	<body>
	<h1>Reset Password</h1>
		<br>
		<br>
		<form:form action="/ResetSuccessful" method="post">
			<table>
				<tr>
					<td>Enter UserId:</td>
					<td><input name="userID" path="userID"
						type="text" /></td>
				</tr>
				<tr>
					<td>New Password:</td>
					<td><input name="newPassword" path="newPassword"
						type="password" /></td>
				</tr>
				<tr>
					<td>Confirm Password:</td>
					<td><input name="confirmPassword" path="confirmPassword"
						type="password" /></td>
				</tr>
			</table>
			<br>
			<input type="submit" value="submit" />
		</form:form>
	</body></div>
</center>
</html>
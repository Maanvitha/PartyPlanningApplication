<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Login</title>
<link rel="stylesheet" type="text/css" href="user.css">
</head>
<body>
	<div class="login-box">
		<img src="img/avatar.jpeg" class="avatar"></img>
		<h1>Login here</h1>
		<form:form modelAttribute="login"  method="post" action = "/adminresult">
			<p>UserId</p>
			<input type="text" name="userid" placeholder="enter user name">
			<br>
			<br>
			<p>Password</p>
			<input type="password" name="password" placeholder="enter password">
			<br>
			<br>
			<input type="submit" name="submit">
			<br>
			<br>
			<a href="/RegistrationPage">Do not have an account</a>
			<br>
			<a href="/ForgetUserid">Forgot userId</a>
			<br>
			<a href="/ForgetPasswordPage">Forgot password</a>
			<br/>
			<p style="fontcolor:red" align="center"> <h1>${message}</h1> </p>
		</form:form>
	</div>
</body>
</html>
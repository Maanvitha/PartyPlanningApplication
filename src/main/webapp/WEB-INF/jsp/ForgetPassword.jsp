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

<title>Security Questions</title>
<style>

body {
     background: url("img/for.jpeg");
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
<div class="login-box">
<center>
	<body>
		<p>security questions:</p>
		<br>
		<form:form modelAttribute="validation" action="/ForgetPasswordresult" method="post">
			<table>
				<tr>
					<td>Enter the user id:</td>
					<td><input path="userid" type="text" name="userid"/></td>
				</tr>
				<tr>
					<td>What's your school Name?</td>
					<td><input path="sq1" type="text"
						placeholder=" What is your school name?" name="sq1"/></td>
				</tr>
				<tr>
					<td>What's your favorite color?</td>
					<td><input path="sq2" type="text"
						placeholder=" What is your favourite color?" name="sq2"/></td>
				</tr>
				<tr>
					<td>What's your teacher's name?</td>
					<td><input path="sq3" type="text"
						placeholder=" What is your teacher's name?" name="sq3"/></td>
				</tr>
			</table>
			<input type="submit" value="submit" />
		</form:form>
	</body>
</center></div>
</html>

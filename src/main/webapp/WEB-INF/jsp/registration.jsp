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
<title>User Registration</title>
<style>
<style>
.error{
color:red;
}
body{
margin:0;
padding:0;
background-image:url("img/l10.jpg");
font-family:san-serif;
background-attachment: fixed; 
  background-size: cover;
background-repeat:no-repeat;
}

td
{
color:white;
font-size:20px;
}
h1
{
font-size:50px;
color:white;
}

div 
{
  width:900px;
height:700px;
background:black;
opacity:0.8;
color:white;
top:50%;
left:50%;
position:absolute;
font-weight:bold;
transform:translate(-50%,-50%);
box-sizing:border-box;
padding:70px 30px;
}

</style>

</style>
</head>
<body>

	<div>
<h1>
              <center>Register Here</center>
</h1>
<form:form modelAttribute="registration" action="/ResultPage" method="post">
<table align="center">
<tr>
<td ><spring:message code="label.firstName"/></td>
<td><form:input path="firstName" type="textbox" placeholder="First name" /></td>
<td><form:errors path="firstName" cssClass="error" /></td>
</tr>
<tr>
<td><spring:message code="label.lastName" /></td>
<td><form:input path="lastName" type="textbox" placeholder="Last name" /></td>
    <td><form:errors path="lastName" cssClass="error" /></td>
</tr>
<tr>
<td><spring:message code="label.dob" /></td>
<td><form:input path="dob" type="date" placeholder="Enter your Date of Birth" /></td>
<td><form:errors path="dob" cssClass="error" /></td>
</tr>
<tr>
<td><spring:message code="label.gender" /></td>
<td><form:select items="${gender}" path="gender" /></td>
<td><form:errors path="gender" cssClass="error" /></td>
</tr>
<tr>
<td><spring:message code="label.contactNum" /></td>
<td><form:input path="contactNum" type="number" placeholder="Enter your Contact number" /></td>
    <td><form:errors path="contactNum" cssClass="error" /></td>
</tr>

<tr>
<td><spring:message code="label.userID" /></td>
<td><form:input path="userID" type="textbox"  placeholder="Enter your Username" /></td>
    <td><form:errors path="userID" cssClass="error" /></td>
</tr>				
 <tr>
<td><spring:message code="label.password" /></td>
<td><form:input path="password" type="password" placeholder=" Enter your Password" /></td>
     <td><form:errors path="password" cssClass="error" /></td>
</tr>
<tr>
<td><form:radiobutton path="roles" id="customer" value="customer"/><spring:message code="label.customer"/></td>
     <form:errors path="roles" cssClass="error" />	 
<td><form:radiobutton path="roles" id="admin" value="admin"/><spring:message code="label.admin"/></td>
	 <td><form:errors path="roles" cssClass="error" /></td>	 	     
</tr>	
<tr>
<td><p>SecretQuestion 1<p/></td>
<td><form:input path="sq1" type="textbox" placeholder=" What is your school name?" /></td>
     
</tr>		
<tr>
<td><p>SecretQuestion 2<p/></td>
<td><form:input path="sq2" type="textbox" placeholder=" What is your favourite color?" /></td>
    
</tr>		
<tr>
<td><p>SecretQuestion 3<p/></td>
<td><form:input path="sq3" type="textbox" placeholder=" What is your teacher's name?" /></td>
    
</tr>				
</table>
<p align="center"><input type="Submit" value="Register" style="font-size:15pt"/>
        <input type="Reset" value="Clear" style="font-size:15pt"/>
        </p>
        <p align="center"> <h1>${message}</h1> </p>

</form:form>
</div>
</body>
</html>
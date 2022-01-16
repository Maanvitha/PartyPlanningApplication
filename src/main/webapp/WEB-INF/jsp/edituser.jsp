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
<title>Edit user profile</title>
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
font-size:40px;
color:black;
}
div 
{
  width:900px;
height:900px;

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
form{
     font-size: 20px;
     color:white;
      width:900px;
height:700px;

     line-height:30px;
     background: black;
	opacity:0.8;
	
}

</style>

</head>
<body>
<div>
<h1 ><center>Update Profile</center></h1>
<form:form modelAttribute="registration" action="/UserAfterLogin" method="POST">
                    

<table align="center">
              
<tr>
<td ><spring:message code="label.firstName"/></td>
<td><form:input path="firstName" type="textbox" value="${firstName}" /></td>
<td><form:errors path="firstName" cssClass="error" /></td>
</tr>
<tr>
<td><spring:message code="label.lastName" /></td>
<td><form:input path="lastName" type="textbox" value="${lastName}" /></td>
    <td><form:errors path="lastName" cssClass="error" /></td>
</tr>
<tr>
<td><spring:message code="label.dob" /></td>
<td><form:input path="dob" type="date" placeholder="Enter your Date of Birth" /></td>
<td><form:errors path="dob" cssClass="error" /></td>
</tr>
<tr>
<td><spring:message code="label.gender" /></td>
<td><form:select items="${gender}" path="gender" value="${gender1}" /></td>
<td><form:errors path="gender" cssClass="error" /></td>
</tr>
<tr>
<td><spring:message code="label.contactNum" /></td>
<td><form:input path="contactNum" type="number" value="${contactNum}" /></td>
    <td><form:errors path="contactNum" cssClass="error" /></td>
</tr>

<tr>
<td><spring:message code="label.userID" /></td>
<td><form:input path="userID" type="textbox" value="${userID}" readonly="true" /></td>
    <td><form:errors path="userID" cssClass="error" /></td>
</tr>                
<tr>
<td><spring:message code="label.password" /></td>
<td><form:input path="password" type="password" value=" ${password}" /></td>
     <td><form:errors path="password" cssClass="error" /></td>
</tr>

<tr>
<td><p>SecretQuestion 1:What is your school name?<p/></td>
<td><form:input path="sq1" type="textbox" value="${sq1}" /></td>
     
</tr>      
<tr>
<td><p>SecretQuestion 2:What's your favourite color?<p/></td>
<td><form:input path="sq2" type="textbox" value="${sq2}" /></td>
    
</tr>      
<tr>
<td><p>SecretQuestion 3:What is your teacher's name?<p/></td>
<td><form:input path="sq3" type="textbox" value="${sq3}" /></td>
    
</tr> 
<tr>
<td>Role</td>
<td><form:input path="roles"  value="${role}"  readonly="true"/></td>
     
    
</tr>               
</table>
<p align="center"><input type="Submit" value="Update" style="font-size:15pt"/></p>
<p align="center">${mess}</p> 
</form:form></div>
</body>
</html>

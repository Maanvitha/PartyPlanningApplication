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
<title>Update profile</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<style>

body {
     background: url("img/l10.jpg");
     background-repeat: no-repeat;
     background-attachment: fixed;
     background-size: cover;
}
.icon-white {
  color: white;
  background:black;
  size:10px;
}
form{
     font-size: 20px;
     color:white;
     width: 40%;
     line-height:30px;
     background: black;
	opacity:0.8;
	height:520px;
     
}


</style>
</head>
<body>
<div style="color:white;background:black;opacity:0.8;font-size:30px;">Party Planning&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a style="padding:-20px;background:black;"   href="/UserAfterLogin"><i class="glyphicon glyphicon-home icon-white"></i> </a> </div>

<center>
<br>
<div class="login-box"><h1 style="font-size:50px">Update Profile</h1>
<div>
<form action="/edituser" >
                    

<table >
              
<tr>
<td >firstName :</td>
<td>${firstName}</td>
</tr>
<tr>
<td>lastName :</td>
<td>${lastName}</td>
</tr>

<tr>
<td>gender :</td>
<td>${gender}</td>
</tr>
<tr>
<td>contactNumuber :</td>
<td>${contactNum}</td>
</tr>

<tr>
<td>userID :</td>
<td>${userID}</td>
</tr>                
<tr>
<td>password :</td>
<td>${password}</td>
</tr>

<tr>
<td><p>What is your School name? :<p/></td>
<td>${sq1}</td>
</tr>      
<tr>
<td><p>What is your Favourite color? :<p/></td>
<td>${sq2}</td>
</tr>      
<tr>
<td><p>What is your teachers's name? :<p/></td>
<td>${sq3}</td>
</tr> 
<tr>
<td>role</td> 
<td>${role}</td>	 	     
</tr>               
</table>
<p ><input type="Submit" value="EDIT" style="font-size:15pt;color:black;"/></p>
 
</form>
</div></div></center>
</body>
</html>

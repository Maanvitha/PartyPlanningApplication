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
<title>Insert title here</title>
</head>
<body>
<form action="/addContacts" method="post">
<table>
<tr><td>Insert Email Id:</td><td><input type="email" name="email" ></td></tr>
<tr><td><input type="submit"></td></tr>
<tr><td><a href="/UpdateContacts"> Update Contacts:</a></td></tr>
<tr><td><a href="/sendInvitations"> Send Invitations:</a></td></tr>
</table>
</form>
</body>
</html>

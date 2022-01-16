<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Choosing Venue</title>
</head>
<body>
	<form action="/editContacts" method="POST">
		Choose Contact to Update: <select name="contact">
			<c:forEach var="contact" items="${contacts}">
				<option value="${contact}">${contact}</option>
			</c:forEach>
		</select> <br>
		
		
		<br> <input type="Submit" value="Edit" />
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/ackApproval" method="POST">

		choose users to be approved: <select name="approval">
			<c:forEach var="ackw" items="${ack}">
				<option value="${ackw}">${ackw}</option>
			</c:forEach>
		</select> <br> <br> <input type="Submit" value="Approve" />
		<br>
		<a href="/adminAfterLogin">Go to home page</a>
		
		
</form>
</body>
</html>
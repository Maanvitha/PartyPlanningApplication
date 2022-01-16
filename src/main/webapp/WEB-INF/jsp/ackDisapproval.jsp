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
<form action="/ackDisapproval" method="POST">

		choose users to be disapproved: <select name="disapproval">
			<c:forEach var="ackwd" items="${ackd}">
				<option value="${ackwd}">${ackwd}</option>
			</c:forEach>
		</select> <br> <br> <input type="Submit" value="Disapprove" />
		<br>
		<a href="/adminAfterLogin">Go to home page</a>
		
</form>
</body>
</html>
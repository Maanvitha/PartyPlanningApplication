<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form  action="/UpdateVenuedetails_1" method = "POST">
VenueId<input type=text name="venue_id"/>
Venue Name<input type=text name="venue_name"/>
Venue Location<input type=text name="venue_location"/>
Price <input type=text name="venue_price"/>

<input type="Submit" value="BOOK"/>
</form>
</body>
</html>
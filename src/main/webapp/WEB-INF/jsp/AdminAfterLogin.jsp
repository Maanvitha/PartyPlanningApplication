<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Insert title here</title>

</head>
<body>
<script>
function myFunction() {
  document.getElementById("demo").innerHTML = "Feedback report generated";
}
</script>

<table>
<tr>
<td>
<a href="/UpdateVenuedetails">Update Venue</a>
</td>
</tr>
<tr>
<td>
<a href="/UploadTemplates">Upload Templates</a>
</td>
</tr>
<tr>
<td>
<a href="/CheckAcknowledgement">Check Booking Acknowledgment</a>
</td>
</tr>
<tr>
<td>
<a href="/generate_report">Generate Report</a>
</td>
</tr>
<tr>
<td>
<button onclick="myFunction()">Generate Review</button>
</td>
</tr>
</table>
<div id="demo"></div>
</body>
</html>

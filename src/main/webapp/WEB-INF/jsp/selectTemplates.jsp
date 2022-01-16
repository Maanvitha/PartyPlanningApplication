<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
* {
  box-sizing: border-box;
  background:black;
}
button{
color:black;
background:white;
}
div
{
display:none;}

* {
  box-sizing: border-box;
}

td {
  float: left;
  width: 33.33%;
  padding: 5px;
}

/* Clearfix (clear floats) */
tr::after {
  content: "";
  clear: both;
  display: table;
}

</style>
<script>
function baby() {
  var x = document.getElementById("baby");
  if (x.style.display === "none") {
    x.style.display = "block";
  } else {
    x.style.display = "none";
  }
}

function birth() {
	  var x = document.getElementById("birth");
	  if (x.style.display === "none") {
	    x.style.display = "block";
	  } else {
	    x.style.display = "none";
	  }
	}

function wed() {
	  var x = document.getElementById("wedding");
	  if (x.style.display === "none") {
	    x.style.display = "block";
	  } else {
	    x.style.display = "none";
	  }
	}

function cock() {
	  var x = document.getElementById("cocktail");
	  if (x.style.display === "none") {
	    x.style.display = "block";
	  } else {
	    x.style.display = "none";
	  }
	}

function fare() {
	  var x = document.getElementById("farewell");
	  if (x.style.display === "none") {
	    x.style.display = "block";
	  } else {
	    x.style.display = "none";
	  }
	}

function meet() {
	  var x = document.getElementById("meeting");
	  if (x.style.display === "none") {
	    x.style.display = "block";
	  } else {
	    x.style.display = "none";
	  }
	}
	
</script>
</head>
<body>

<button onclick="baby()">Baby shower</button>
<button onclick="birth()">Birthday</button>
<button onclick="wed()">Wedding</button>
<button onclick="cock()">cocktail party</button>
<button onclick="fare()">farewell</button>
<button onclick="meet()">meeting</button>
<div id="birth">
  <table width="100%" border="0">
  <tr>
  <td>
    <img src="img/bd1.jpeg" alt="Snow" style="float: left; width: 100%;">
 </td>
 <td>
    <img src="img/bd2.jpeg" alt="Forest" style="float: left; width: 100%;">
 </td>
 <td>
    <img src="img/bd3.jpeg" alt="Mountains" style="float: left; width: 100%;">
 </td>
 </tr>
 <tr>
 <td>
    <img src="img/bd4.jpeg" alt="Snow" style="float: left; width: 100%;">
 </td>
 <td>
    <img src="img/bd5.jpeg" alt="Forest" style="float: left; width: 100%;">
 </td>
 <td>
    <img src="img/bd6.jpeg" alt="Mountains" style="float: left; width: 100%;">
 </td>
 </tr>
 </table width="100%" border="0">
</div>

<div id="baby">
  <table>
  <tr>
  <td>
    <img src="img/bs1.jpeg" alt="Snow" style="float: left; width: 100%;">
 </td>
 <td>
    <img src="img/bs2.jpg" alt="Forest" style="float: left; width: 100%;">
 </td>
 <td>
    <img src="img/bs3.jpg" alt="Mountains" style="float: left; width: 100%;">
 </td>
 </tr>
 <tr>
 <td>
    <img src="img/bs4.jpg" alt="Snow" style="float: left; width: 100%;">
 </td>
 <td>
    <img src="img/bs5.jpg" alt="Forest" style="float: left; width: 100%;">
 </td>
 <td>
    <img src="img/bs6.jpg" alt="Mountains" style="float: left; width: 100%;">
 </td>
 </tr>
 </table>
</div>

<div id="wedding">
  <table width="100%" border="0">
  <tr>
  <td>
    <img src="img/wd1.jpeg" alt="Snow" style="float: left; width: 100%;">
 </td>
 <td>
    <img src="img/wd2.jpg" alt="Forest" style="float: left; width: 100%;">
 </td>
 <td>
    <img src="img/wd3.jpeg" alt="Mountains" style="float: left; width: 100%;">
 </td>
 </tr>
 <tr>
 <td>
    <img src="img/wd4.jpg" alt="Snow" style="float: left; width: 100%;">
 </td>
 <td>
    <img src="img/wd5.png" alt="Forest" style="float: left; width: 100%;">
 </td>
 <td>
    <img src="img/wd6.jpeg" alt="Mountains" style="float: left; width: 100%;">
 </td>
 </tr>
 </table>
</div>

<div id="cocktail">
  <table width="100%" border="0">
  <tr>
  <td>
    <img src="img/cp1.jpg" alt="Snow" style="float: left; width: 100%;">
 </td>
 <td>
    <img src="img/cp2.jpeg" alt="Forest" style="float: left; width: 100%;">
 </td>
 <td>
    <img src="img/cp3.jpg" alt="Mountains" style="float: left; width: 100%;">
 </td>
 </tr>
 <tr>
 <td>
    <img src="img/cp5.jpg" alt="Snow" style="float: left; width: 100%;">
 </td>
 <td>
    <img src="img/cp6.jpeg" alt="Forest" style="float: left; width: 100%;">
 </td>
 <td>
    <img src="img/cp6.jpg" alt="Mountains" style="float: left; width: 100%;">
 </td>
 </tr>
 </table>
</div>

<div id="farewell">
  <table width="100%" border="0">
  <tr>
  <td>
    <img src="img/fw1.jpeg" alt="Snow" style="float: left; width: 100%;">
 </td>
 <td>
    <img src="img/fw2.jpeg" alt="Forest" style="float: left; width: 100%;">
 </td>
 <td>
    <img src="img/fw3.jpeg" alt="Mountains" style="float: left; width: 100%;">
 </td>
 </tr>
 <tr>
 <td>
    <img src="img/fw4.jpeg" alt="Snow" style="float: left; width: 100%;">
 </td>
 <td>
    <img src="img/fw5.jpeg" alt="Forest" style="float: left; width: 100%;">
 </td>
 <td>
    <img src="img/fw6.png" alt="Mountains" style="float: left; width: 100%;">
 </td>
 </tr>
 </table>
</div>

<div id="meeting">
  <table width="100%" border="0">
  <tr>
  <td>
    <img src="img/mt1.jpeg" alt="Snow" style="float: left; width: 100%;">
 </td>
 <td>
    <img src="img/mt2.jpeg" alt="Forest" style="float: left; width: 100%;">
 </td>
 <td>
    <img src="img/mt3.jpeg" alt="Mountains" style="float: left; width: 100%;">
 </td>
 </tr>
 
 </table>
</div>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" 
	import="java.util.*"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
fieldset {
	margin-top:100px;
	margin-left:600px;
	width:350px;
	height: 200px;
	text-align: center;
	font-size: 50px;
	border: solid black;
	border-radius: 10px;
	 color: white;
	 padding:10px;
	
}

body{
background-image: url("Food.jpg");
	background-size: cover;
    background-color: rgba(255, 255, 255, 0.2);
}
tr td a {
   color:white;
    text-decoration: none;
}
h2{
color: blue;
font-family: Arial, Helvetica, sans-serif;
font-style: italic;
font-size: 40px;
}
</style>
</head>
<body>
	<h2>
	Hello!...
		<%
		out.println((String) request.getAttribute("fname"));
		%>
	</h2>
	<fieldset>
		<legend>Category</legend>
		<table>
			<tr>
				<td>1:</td>
				<td><a href="Food.html">Foods</a></td>
			</tr>
			<tr>
				<td>2:</td>
				<td><a href="HotelRoom.html">Hotel Rooms</a></td>
			</tr>

		</table>
	</fieldset>

</body>
</html>
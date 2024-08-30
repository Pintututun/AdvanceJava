<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
table, thead, td, tr {
	border: 2px;
	border-color: black;
	border-style: double;
	padding: 8px;
	text-align: center;
	height: 40%;
	width: 20%;
	margin-left: 40%;
}
</style>
</head>
<body>
	<h2>Your Order</h2>
	<table>
		<thead>
			<tr>
				<td><b>Parameter Name</b></td>
				<td><b>Parameter Value</b></td>
			</tr>
		</thead>
		<tr>
			<td>Submit</td>
			<td>
				<%
				out.println((String) request.getAttribute("submit"));
				%>
			</td>
		</tr>
		<tr>
			<td>Address</td>
			<td>
				<%
				out.println((String) request.getAttribute("address"));
				%>
			</td>
		</tr>
	
		<tr>
			<td>Name</td>
			<td>
				<%
				String p = (String) request.getAttribute("uname");
				out.println(p);
				%>
			</td>
		</tr>
		<tr>
			<td>Appetizer</td>
			<td>
				<%
				out.println((String) request.getAttribute("free"));
				%>
			</td>
		</tr>
		<tr>
			<td>CardType</td>
			<td>
				<%
				out.println((String) request.getAttribute("cardType"));
				%>
			</td>
		</tr>
		<tr>
			<td>Crust</td>
			<td>
				<%
				out.println((String) request.getAttribute("crust"));
				%>
			</td>
		</tr>
		<tr>
			<td>CardNum</td>
			<td>
				<%
				out.println((String) request.getAttribute("cardNum"));
				%>
			</td>
		</tr>
		<tr>
			<td>Topings</td>
			<td>
				<%
				String s = (String)request.getAttribute("topings");
				out.println(s);
				%>
			</td>
		</tr>

	</table>
</body>
</html>
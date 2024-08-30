<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
h1{
color: red;
font-style: italic;
}

</style>
</head>
<body>
<%String fail=(String)request.getAttribute("msg"); %>
<h1><%=fail %></h1>
<jsp:include page="Login.html"></jsp:include>


</body>
</html>
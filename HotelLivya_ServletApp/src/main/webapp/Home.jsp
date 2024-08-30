<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
h3{
margin-top:40px;
font-size: 30px;
font-style: italic;
text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);
color: white;

}

</style>
</head>
<body>
<%String ms=(String)request.getAttribute("msg"); %>
<h3><%=ms %></h3>
<jsp:include page="Home.html"/>

</body>
</html>
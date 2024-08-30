<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.*"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style >
h3{
color: green;
font-style: italic;
font-size: 50px;
margin-left: 50px;
margin-top:30px;
}

</style>
</head>
<body>

     <% String register=(String)request.getAttribute("msg1"); %>
     <h3><%=register %></h3>
     <jsp:include page="Login.html"></jsp:include>

</body>
</html>
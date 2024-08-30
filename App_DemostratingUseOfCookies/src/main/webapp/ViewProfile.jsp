<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="userApp.UserBean"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String fName = (String)request.getAttribute("fName");
out.println("Page belongs to "+fName+"<br>");
UserBean ub =(UserBean)application.getAttribute("ubean");
out.println(ub.getfName()+"&nbsp&nbsp"+ub.getlName()+"&nbsp&nbsp"+
ub.getAddr()+"&nbsp&nbsp"+ub.getmId()+"&nbsp&nbsp"+ub.getPhNo()+"<br>");;

%>
<a href="edit">EditProfile</a>
<a href="logout">Logout</a>
</body>
</html>
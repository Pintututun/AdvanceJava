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
UserBean ub =
(UserBean)application.getAttribute("ubean");
out.println("Page belongs to "+fName+"<br>");
%>
<form action="update" method="post">
Address:<input type="text" name="addr" value=<%=ub.getAddr() %>><br>
MailId:<input type="text" name="mid" value=<%=ub.getmId() %>><br>
PhNo:<input type="text" name="phno" value=<%=ub.getPhNo() %>><br>
<input type="submit" value="UpdateProfile">
</form>
</body>
</html>
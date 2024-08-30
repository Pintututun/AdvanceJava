<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="bankApplication.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%=request.getAttribute("msg") %>
<%UserBean ub=(UserBean)application.getAttribute("ubean"); %>
<%=ub.getTransactionId() %>
<%=ub.getTransactionTime() %>
</body>
</html>
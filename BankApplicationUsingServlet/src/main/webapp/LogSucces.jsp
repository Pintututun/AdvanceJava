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
<%=request.getAttribute("msg")%>
<table>
<tr>
<td><a href="deposit.html">Deposit</a></td>
<td></td>
</tr>
<tr>
<td><a href="transfer.html">TranferMoney</a></td>
<td></td>
</tr>

</table>
</body>
</html>
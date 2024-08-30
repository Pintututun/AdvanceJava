<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="hotel_Application.FoodBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
 #main {
        display: flex;
        justify-content: space-between;
        max-width: 600px;
        margin: 100px auto;
        padding: 20px;
    }

table {
	border-collapse: collapse;
	width: 100%;
}

table, th, td {
	border: 3px solid black;
}

th, td {
	padding: 10px;
	text-align: center;
	font-size: 30px;
	color: white;
}

body {
	background-image: url("Stater.jpg");
	background-size: cover;
	background-color: rgba(255, 255, 255, 0.4);
	margin: 0;
	padding: 0;
}
 #sub {
        display: flex;
        justify-content: center;
        align-items: center;
        max-width: 300px; /* Set a specific maximum width for the second table */
        margin-top: 100px;
        padding: 5px;
        margin-right: 200px;
        
    }
</style>
</head>
<body>
	<%
	FoodBean fb = (FoodBean) session.getAttribute("fbean");
	%>
	<div id="main">
		<table>
			<thead>
				<tr>
					<td>Items</td>
					<td>Quantity</td>
					<td>Price</td>
					<td>TotalPrice</td>
		        </tr>
		     </thead>
		   
					<%
					Double bill=0.0;
					  try{
					if (fb.getLollypop() != null) {
					%>
					
				
				<tr>
					<td><strong><%=fb.getLollypop()%></strong></td>
					<td><%=fb.getLollypopQty()%></td>
					<td><%=fb.getLollypopPrice()%></td>
					<td><%=fb.getLollypopQty()*fb.getLollypopPrice() %></td>
					<% bill=bill+fb.getLollypopQty()*fb.getLollypopPrice(); %>
				</tr>
				<%
				}
		     }catch(Exception e)
		     {
		    	 e.printStackTrace();
		     }
				%>
				<%
				try{
				if (fb.getCrispyChicken() != null) {
				%>
				<tr>
					<td><strong><%=fb.getCrispyChicken()%></strong></td>
					<td><%=fb.getCrispyChickenQty()%></td>
					<td><%=fb.getCrispyChickenPrice()%></td>
					<td><%=fb.getCrispyChickenQty()*fb.getCrispyChickenPrice() %></td>
					<% bill=bill+fb.getCrispyChickenQty()*fb.getCrispyChickenPrice(); %>
				</tr>
				<%
				}
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				%>
				<%
				try{
				if (fb.getButterMasala() != null) {
				%>
				<tr>
					<td><strong><%=fb.getButterMasala()%></strong></td>
					<td><%=fb.getButterMasalaQty()%></td>
					<td><%=fb.getButterMasalaPrice()%></td>
					<td><%=fb.getButterMasalaQty()*fb.getButterMasalaPrice() %></td>
					<% bill=bill+fb.getButterMasalaQty()*fb.getButterMasalaPrice() ; %>
				</tr>
				<%
				}
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				%>
				<%
				try{
				if (fb.getHyderabadi() != null) {
				%>
				<tr>
					<td><strong><%=fb.getHyderabadi()%></strong></td>
					<td><%=fb.getHyderabadiQty()%></td>
					<td><%=fb.getHyderabadiPrice()%></td>
					<td><%=fb.getHyderabadiQty()*fb.getHyderabadiPrice() %></td>
					<% bill=bill+fb.getHyderabadiQty()*fb.getHyderabadiPrice(); %>
				</tr>
				<%
				}
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				%>
				<%
				try{
				if (fb.getIceCream() != null) {
				%>
				<tr>
					<td><strong><%=fb.getIceCream()%></strong></td>
					<td><%=fb.getIceCreamQty()%></td>
					<td><%=fb.getIceCreamPrice()%></td>
					<td><%=fb.getIceCreamQty()*fb.getIceCreamPrice() %></td>
					<% bill=bill+ fb.getIceCreamQty()*fb.getIceCreamPrice();%>
				</tr>
				<%
				}
				}catch(Exception e)
				{
					e.printStackTrace();
					out.println(fb);
				}
				%>
				<%
				try{
				if (fb.getGulabJamun() != null) {
				%>
				<tr>
					<td><strong><%=fb.getGulabJamun()%></strong></td>
					<td><%=fb.getGulabJamunQty()%></td>
					<td><%=fb.getGulabJamunPrice()%></td>
					<td><%=fb.getGulabJamunQty()*fb.getGulabJamunPrice() %></td>
					<% bill=bill+fb.getGulabJamunQty()*fb.getGulabJamunPrice(); %>
				</tr>
				<%
				}
				}catch(Exception e)
				{
					e.printStackTrace();
					out.println(fb);
				}
				%>
			<% session.setAttribute("Bill", bill); %>
		</table>
	</div>
	
		<div id="sub">
			<table>
				<tr>
					<td>Edit</td>
					<td><input type="button" value="Click"
						style="font-size: 20px; padding: 10px 20px;"
						onclick="window.location.href='Food.html';"></td>
				</tr>
				<tr>
				
					<td>Print Bill</td>
					<td><input type="button" value="Click"
						style="font-size: 20px; padding: 10px 20px;"onclick="window.location.href='FoodBill.jsp';"></td>
				</tr>
				<tr>
					<td>Hotel Rooms</td>
					<td><input type="button" value="Click" style="font-size: 20px; padding: 10px 20px;" onclick="window.location.href='HotelRoom.html';"></td>
				</tr>

			</table>
		</div>
	
</body>
</html>
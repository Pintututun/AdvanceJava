<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="hotel_Application.FoodBean,java.lang.*"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Bill Summary</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-image: url("Payment.jpg");
            background-size: cover;
            background-color: rgba(255, 255, 255, 0.7);
            margin: 0;
            padding: 0;
            text-align: center;
            min-height: 80vh;
        }

        fieldset {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        table {
            width: 100%;
            margin-top: 20px;
        }

        table td {
            padding: 10px;
            font-size: 18px;
        }
        table tr {
            border-bottom: 1px solid #ccc;
        }
        table tr:last-child {
            border-bottom: none;
        }
        .separator {
            height: 1px;
            background-color: #ccc;
        }
         button {
            font-size: 24px;
            padding: 5px 10px;
            border: none;
            background-color: #007BFF;
            color: #fff;
            border-radius: 5px;
            font-weight: bold;
            cursor: pointer;
        }
         input[type="text"] {
            font-size: 24px;
            padding: 10px;
            width: 250px;
        }
       
        .button-container {
            margin-top: 20px;
            text-align: center;
        }
        
        .button-container button {
            margin: 5px;
        }
    </style>
</head>
<body>
    <%
        FoodBean fb = (FoodBean) session.getAttribute("fbean");
        try {
            Double hotBill = (Double) session.getAttribute("room");
            Double bill = (Double) session.getAttribute("Bill");
            Double totBill = 0.0;
            if (bill != null) {
    %>
    <div>
        <fieldset>
            <legend style="font-size: 40px;">Bill List</legend>
            <table>
                <tr>
                    <td style="font-size: 24px;">Food Bill:</td>
                    <td><%= bill %></td>
                </tr>
                <%
                    }
                    if (hotBill != null) {
                %>
                <tr>
                    <td style="font-size: 24px;">Hotel Bill:</td>
                    <td><%= hotBill %></td>
                </tr>
                <tr class="separator">
                    <td colspan="2"></td>
                </tr>
                <%
                    }
                    if (bill == null) {
                        totBill = hotBill;
                    }
                    if (hotBill == null) {
                        totBill = bill;
                    }
                    if (bill != null && hotBill != null) {
                        totBill = bill + hotBill;
                    }
                %>
                <tr>
                    <td style="font-size: 24px;">Total Bill:</td>
                    <td><%= totBill %></td>
                </tr>
                <%}catch(Exception e)
        {}%>
            </table>
        </fieldset>
    </div>
    <div class="button-container">
        <button>
            <a href="Food.html" style="text-decoration: none; color: #fff; padding: 10px;">Food Want</a>
        </button>
        <button>
            <a href="Print.jsp" style="text-decoration: none; color: #fff; padding: 10px;">Pay</a>
        </button> 
    </div>      
</body>
</html>
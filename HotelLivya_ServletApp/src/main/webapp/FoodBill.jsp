<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="hotel_Application.*,java.lang.*"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-image: url("Payment.jpg");
        background-size: cover;
        background-color: rgba(255, 255, 255, 0.7);
        margin: 0;
        padding: 0;
        text-align: center;
    }

    .container {
        max-width: 600px;
        margin: 0 auto;
        padding: 20px;
        background-color: #ffffff;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    h2 {
        color: #333;
    }

    table {
        width: 100%;
        margin-top: 20px;
    }

    table td {
        padding: 10px;
    }

    input[type="text"] {
        width: 100%;
        padding: 10px;
        margin-bottom: 10px;
    }

    input[type="submit"] {
        display: block;
        margin: 0 auto;
        padding: 10px 20px;
        background-color: #007bff;
        color: #fff;
        border: none;
        cursor: pointer;
    }

    input[type="submit"]:hover {
        background-color: #0056b3;
    }

    #captchaContainer {
        display: <%= (request.getAttribute("checkCaptcha") == null || !(boolean) request.getAttribute("checkCaptcha")) ? "block" : "none" %>;
        background-color: #EFEFEF; /* Varying background color */
        padding: 20px;
        border-radius: 10px;
    }

    #captchaText {
        font-size: 36px; /* Larger font size */
        color: #FF5733; /* Varying text color */
    }
</style>
</head>
<body>
<% FoodBean fb=(FoodBean)session.getAttribute("fbean");
Double foodBill=(Double)session.getAttribute("Bill");%>
<h2>Total Price:<%=foodBill %></h2>
<%String captchaString="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
 String captcha="";
 for(int i=0;i<5;i++)
 {
     int index=(int)(Math.random()*captchaString.length());
     captcha=captcha+captchaString.charAt(index);
     session.setAttribute("captcha",captcha);
 }
 %>
 <div class="container">
    
    <div id="captchaContainer">
        <form action="captcha" method="post">
            <table>
                <tr>
                    <td><strong><span id="captchaText"><%= session.getAttribute("captcha") %></span></strong></td>
                </tr>
                <tr>
                    <td><input type="text" name="capCheck" placeHolder="Enter the Captcha code"></td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Submit">
                    </td>
                </tr>
            </table>
        </form>
    </div>
    
    <form action="Payment" method="post">
        <input type="submit" value="Proceed to Payment" style="display: <%= (request.getAttribute("checkCaptcha") != null && (boolean) request.getAttribute("checkCaptcha")) ? "block" : "none" %>;" id="paymentButton">
    </form>
    
    <p>
    <% if (request.getAttribute("response") != null) { %>
        <%= request.getAttribute("response") %>
    <% } %>
    </p>
</div>
</body>
</html>
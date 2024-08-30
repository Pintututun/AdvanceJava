<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 80vh;
        }
        #captchaInput {
            font-size: 24px;
            padding: 10px;
            width: 250px;
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
        
    </style>
</head>
<body>
<%String captchaString="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
 String captcha="";
 for(int i=0;i<5;i++)
 {
     int index=(int)(Math.random()*captchaString.length());
     captcha=captcha+captchaString.charAt(index);
 }
 %>
            <div id="captchaContainer">
                <h2><%=captcha %></h2>
                <input type="text" id="captchaInput" placeholder="Enter CAPTCHA">
                <button onclick="checkCaptcha()">Submit</button>
            </div>
            <div id="paymentContainer" style="display: none;">
                <p>CAPTCHA verified. Proceed to payment:</p>
                <input type="text" placeholder="Card Number"><br>
                <input type="text" placeholder="Expiration Date"><br>
                <button onclick="window.location.href='Thank.html';">Proceed to Payment</button>
            </div>
   
    
    <script>
        function checkCaptcha() {
            var captchaInput = document.getElementById("captchaInput").value;
            if (captchaInput === "<%=captcha%>") {
                document.getElementById("captchaContainer").style.display = "none";
                document.getElementById("paymentContainer").style.display = "block";
            } else {
                alert("CAPTCHA is incorrect. Please try again.");
            }
        }
    </script>
    
</body>

</html>
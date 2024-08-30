package hotel_Application;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oracle.net.ns.SessionAtts;
@SuppressWarnings("serial")
@WebServlet("/captcha")
public class FoodBiilServlet extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
	 HttpSession session=req.getSession(false);
	 FoodBean fb=(FoodBean)session.getAttribute("fbean");
	 
	 String generatedCaptcha=(String)session.getAttribute("captcha");
	 String checkCaptcha=req.getParameter("capCheck");
	 if(generatedCaptcha.equals(checkCaptcha))
	 {
		 req.setAttribute("response", "Thank u...Captcha is correct");
		 req.setAttribute("checkCaptcha", true);
		 RequestDispatcher rd=req.getRequestDispatcher("FoodBill.jsp");
		 rd.forward(req, res);
	 }
	 else
	 {
		 req.setAttribute("response", "Captcha is wrong");
		 RequestDispatcher rd=req.getRequestDispatcher("FoodBill.jsp");
		 rd.include(req, res);
	 }
	 
	}
	

}

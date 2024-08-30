package test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewProfileServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		Cookie c[]=req.getCookies();
		if(c==null)
		{
			req.setAttribute("msg", "Session Expired...<br>");
			RequestDispatcher rd=req.getRequestDispatcher("Home.jsp");
			rd.forward(req, res);
		}
		else
		{
			String value=c[0].getValue();
			req.setAttribute("fName", value);
			RequestDispatcher rd=req.getRequestDispatcher("ViewProfile.jsp");
			rd.forward(req, res);
		}
	}

}

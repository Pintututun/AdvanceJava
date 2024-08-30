package sessionTrackingWithCookies1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second")
public class Details extends HttpServlet{
	
	
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		Cookie[] ck = req.getCookies();
		String degree=req.getParameter("degree");
		String year=req.getParameter("year");
		String university=req.getParameter("university");
		pw.println(degree+"<br>");
		pw.println(year+"<br>");
		pw.println(university+"<br>");
		pw.println(ck[0].getValue()+"<br>");
		pw.println(ck[1].getValue()+"<br>");
		pw.println(ck[2].getValue()+"<br>");
		
	}

}

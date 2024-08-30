package sessionTrackingWithHttpSessionInterface;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/fill")
public class Session2 extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		HttpSession hs = req.getSession(false);
		String name =(String) hs.getAttribute("name");
		String age=(String)hs.getAttribute("age");
		String mobile=(String)hs.getAttribute("mobile");
		String degree=req.getParameter("degree");
		String year=req.getParameter("year");
		String university=req.getParameter("university");
		pw.println("Your Details are...<br>");
		pw.println("Name:"+name+"<br>Age:"+age+"<br>Mobile:"+mobile+"<br>Higher Degree:"+degree+"<br>Year Of Pass:"+year+"<br>University:"+university);
		
		
	}

}

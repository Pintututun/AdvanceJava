package use_of_ServletContext;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
@WebServlet("/display")
public class DisplayServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String uName=req.getParameter("uname");
		pw.println("Welcome User:"+uName+"<br>");
		pw.println("======ServletContext=======<br>");
		ServletContext sct=req.getServletContext();
		//Accessing the reference of ServletContext Object
		String servInfo=sct.getServerInfo();
		int a=Integer.parseInt(sct.getInitParameter("a"));
		pw.println("ServerInfo:"+servInfo+"<br>");
		pw.println("ContextVal:"+a);
	}

}

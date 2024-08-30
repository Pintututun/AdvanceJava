package use_of_ServletConfig;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
@WebServlet("/disp")
public class DisplayServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String uName=req.getParameter("uname");
		pw.println("Welcome User:"+uName+"<br>");
		pw.println("============ServletConfig==============<br>");
		ServletConfig scf=super.getServletConfig();
		String serName=scf.getServletName();
		int b=Integer.parseInt(scf.getInitParameter("b"));
		pw.println("ServletName:"+serName+"<br>");
		pw.println("ConfigValue:"+b);
	}

}

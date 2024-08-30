package detailsOfAPerson;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@SuppressWarnings("serial")
@WebServlet("/dis")
public class Details_Form extends GenericServlet{

	@Override
	public void init() throws ServletException{
		
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String fname=req.getParameter("firstname");
		String lname=req.getParameter("lastname");
		String mail=req.getParameter("email");
		String pnum=req.getParameter("phone");
		String add=req.getParameter("addr");
		pw.println("==============User Details================<br>");
		pw.println("FirstName:"+fname+"<br>");
		pw.println("LastName:"+lname+"<br>");
		pw.println("Email:"+mail+"<br>");
		pw.println("Mobile:"+pnum+"<br>");
		pw.println("Address:"+add+"<br>");
		
	}
	@Override
	public void destroy()
	{
		
	}

}

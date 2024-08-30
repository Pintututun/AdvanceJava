package customerDetails;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@SuppressWarnings("serial")
@WebServlet("/dis")

public class DisplayServlet extends GenericServlet{
	@Override
	public void init()throws ServletException{
	//NoCode
	}
	@Override

	public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException{
	PrintWriter pw = res.getWriter();
	res.setContentType("text/html");
	String custId = req.getParameter("cid");
	String custName = req.getParameter("cname");
	pw.println("====CustomerDetails====");
	pw.println("<br>CustomerId:"+custId);
	pw.println("<br>CustomerName:"+custName);
	}
	@Override
	public void destroy() {
	//NoCode
	}
}

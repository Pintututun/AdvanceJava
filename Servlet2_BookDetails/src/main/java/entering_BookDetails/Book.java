package entering_BookDetails;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@SuppressWarnings("serial")
@WebServlet("/dis")
public class Book extends GenericServlet{

	@Override
	public void init() throws ServletException
	{
		
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String code=req.getParameter("bcode");
		String name=req.getParameter("bname");
		String author=req.getParameter("bauthor");
		String price=req.getParameter("bprice");
		String qty=req.getParameter("bqty");
		pw.println("=================Book Details=================<br>");
		pw.println("Book Code:"+code+"<br>");
		pw.println("Book Name:"+name+"<br>");
		pw.println("Book Author:"+author+"<br>");
		pw.println("Book Price:"+price+"<br>");
		pw.println("Book Quantity:"+qty+"<br>");
		
	}
	@Override
	public void destroy() {
		
	}

}

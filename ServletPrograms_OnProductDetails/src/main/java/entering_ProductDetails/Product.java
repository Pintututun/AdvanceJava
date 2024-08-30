package entering_ProductDetails;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Product extends GenericServlet{

	@Override
	public void init() throws ServletException{
		
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String code=req.getParameter("pcode");
		String name=req.getParameter("pname");
		String price=req.getParameter("pprice");
		String qty=req.getParameter("pqty");
		pw.println("===============Product Details================<br>");
		pw.println("Product Code:"+code+"<br>");
		pw.println("Product Name:"+name+"<br>");
		pw.println("Product Price:"+price+"<br>");
		pw.println("Product Qty:"+qty+"<br>");
		
	}
	@Override
	public void destroy() {
		
	}

}

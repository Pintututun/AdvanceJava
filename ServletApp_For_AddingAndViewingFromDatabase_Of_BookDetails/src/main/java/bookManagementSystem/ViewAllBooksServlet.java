package bookManagementSystem;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewAllBooksServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter pw1 = res.getWriter();
		res.setContentType("text/html");
		ArrayList<BookBean> al = new ViewAllBooksDAO().retrieve();
		if (al.size() == 0) {
			pw1.println("Books not available...<br>");
		} else {
			pw1.println("=================BookDetails================<br>");
			Iterator<BookBean> itr = al.iterator();
			while (itr.hasNext()) {
				BookBean bb = (BookBean) itr.next();
				pw1.println(bb.getCode() + "&nbsp&nbsp" + bb.getName() + "&nbsp&nbsp" + bb.getAuthor() + "&nbsp&nbsp"
						+ bb.getPrice() + "&nbsp&nbsp" + bb.getQty()+"<br>");
			}
		}
       pw1.println("<a href='home.html'>home</a>");
	}

}

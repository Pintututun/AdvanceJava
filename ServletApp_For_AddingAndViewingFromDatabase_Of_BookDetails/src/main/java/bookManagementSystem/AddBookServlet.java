package bookManagementSystem;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@SuppressWarnings("serial")
@WebServlet("/add")
public class AddBookServlet extends GenericServlet {
	@Override
	public void init() throws SecurityException {

	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		String code = req.getParameter("code");
		String name = req.getParameter("bname");
		String author = req.getParameter("bauthor");
		Float price = Float.parseFloat(req.getParameter("bprice"));
		Integer qty = Integer.parseInt(req.getParameter("bqty"));
		BookBean bo = new BookBean();
		bo.setCode(code);
		bo.setName(name);
		bo.setAuthor(author);
		bo.setPrice(price);
		bo.setQty(qty);
		int k = new AddBookDAO().insert(bo);
		if (k > 0) {
			pw.println("Book added successfully....<br>");
			RequestDispatcher rd = req.getRequestDispatcher("home.html");
			rd.include(req, res);

		}

	}

	@Override
	public void destroy() {

	}
}

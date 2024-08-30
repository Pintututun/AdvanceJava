package test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/dis")
public class Test extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		String cust = req.getParameter("cName");
		String crust = req.getParameter("crust");
		String[] topings = req.getParameterValues("tops");
		String topp="";
		for(String s : topings)
		{
			topp+=s+"&nbsp";
		}
		String freeItem = req.getParameter("free");
		String address = req.getParameter("Address");
		String card = req.getParameter("card");
		String cardNum = req.getParameter("CardNum");
		RequestDispatcher rd = req.getRequestDispatcher("Output.jsp");
		req.setAttribute("submit", "order Pizza");
		req.setAttribute("address", address);
		req.setAttribute("uname", cust);
		req.setAttribute("free", freeItem);
		req.setAttribute("cardType", card);
		req.setAttribute("crust", crust);
		req.setAttribute("cardNum", cardNum);
		req.setAttribute("topings", topp);
		rd.forward(req, res);

	}
}

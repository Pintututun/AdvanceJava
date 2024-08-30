package userApp;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		UserBean ub = new LoginDAO().login(req);
		if (ub == null) {
			req.setAttribute("msg", "Invalid Login Process...<br>");
			RequestDispatcher rd = req.getRequestDispatcher("Home.jsp");
			rd.forward(req, res);
		} else {
			ServletContext sct = req.getServletContext();
//Accessing ServletContext object reference
			sct.setAttribute("ubean", ub);
			Cookie ck = new Cookie("fname", ub.getfName());// Cookie Object
			res.addCookie(ck);// Adding Cookie Object to response
			RequestDispatcher rd =

					req.getRequestDispatcher("LogSuccess.jsp");

			rd.forward(req, res);
		}
	}
}

package userApp;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/reg")

public class RegisterServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		UserBean ub = new UserBean();
		ub.setuName(req.getParameter("uname"));
		ub.setpWord(req.getParameter("pword"));
		ub.setfName(req.getParameter("fname"));
		ub.setlName(req.getParameter("lname"));
		ub.setAddr(req.getParameter("addr"));
		ub.setmId(req.getParameter("mid"));
		ub.setPhNo(Long.parseLong(req.getParameter("phno")));
		int k = new RegisterDAO().register(ub);
		if (k > 0) {
			req.setAttribute("msg", "Registration process Successfull..<br>");
			RequestDispatcher rd = req.getRequestDispatcher("RegSuccess.jsp");
			rd.forward(req, res);
		}
	}
}

package sessionTrackingWithHttpSessionInterface;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/display")
public class SessionTracking extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		String name=req.getParameter("name");
		String age=req.getParameter("age");
		String mobile=req.getParameter("mobile");
		HttpSession hs = req.getSession();
		hs.setAttribute("name", name);
		hs.setAttribute("age", age);
		hs.setAttribute("mobile", mobile);
		RequestDispatcher rd=req.getRequestDispatcher("Others.html");
		rd.forward(req, res);
	}

}

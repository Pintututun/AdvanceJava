package hotel_Application;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		HttpSession hs=req.getSession(false);
		if(hs==null)
		{
			req.setAttribute("msg","Session Expired...<br>");
		}
		else
		{
			hs.removeAttribute("fbean");
			hs.removeAttribute("Bill");
			hs.removeAttribute("room");
			hs.invalidate();
			req.setAttribute("msg", "Logged out Successfully...<br>");
		}
		RequestDispatcher rd=req.getRequestDispatcher("Home.jsp");
		rd.forward(req, res);
	}

}

package sessionTrackingWithCookies1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/dis")
public class Session extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws IOException, ServletException
	{
		String name=req.getParameter("name");
		String age=req.getParameter("age");
		String mobile=req.getParameter("mobile");
		Cookie c1  = new Cookie("name", name);
		c1.setMaxAge(60);
		Cookie c2  = new Cookie("age", age);
		c2.setMaxAge(60);
		Cookie c3  = new Cookie("mobile", mobile);
		c3.setMaxAge(60);
		res.addCookie(c1);
		res.addCookie(c2);
		res.addCookie(c3);
		RequestDispatcher rd=req.getRequestDispatcher("Edu.html");
		rd.forward(req, res);
	}

}

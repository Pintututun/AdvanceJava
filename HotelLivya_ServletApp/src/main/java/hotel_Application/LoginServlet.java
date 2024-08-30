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
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		String user=req.getParameter("user");
		String pword=req.getParameter("pword");
		String fname =new LoginDAO().check(user,pword);
		if(fname==null)
		{
			
			RequestDispatcher rd=req.getRequestDispatcher("fail.jsp");
			req.setAttribute("msg","Please enter the correct username and password");
			rd.forward(req, res);
		}
		else
		{
			HttpSession hs = req.getSession();
			hs.setAttribute("fbean", new FoodBean());
			RequestDispatcher rd=req.getRequestDispatcher("Output1.jsp");
			req.setAttribute("fname", fname);
			rd.forward(req, res);
		}
		
	}

}

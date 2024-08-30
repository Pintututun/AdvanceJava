package validatingUser;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@SuppressWarnings("serial")
@WebServlet("/display")
public class Login1 extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String user1=req.getParameter("user");
		String pword1=req.getParameter("pword");
		if((user1.equals("Priyabrata"))&&(pword1.equals("Priyabrata")))
				{
			pw.println("<br><br>&nbsp;&nbsp;User is successfully registered");
				}
		else {
			
			RequestDispatcher rd1=req.getRequestDispatcher("Login");
			pw.println("Please enter the correct user name and password");
			rd1.include(req, res);
		}
		
	}

}

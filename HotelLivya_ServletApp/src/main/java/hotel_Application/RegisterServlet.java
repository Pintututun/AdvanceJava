package hotel_Application;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		String user=req.getParameter("user");
		String pword=req.getParameter("pword");
		String fname=req.getParameter("fname");
		String lname=req.getParameter("lname");
		String mail=req.getParameter("mail");
		String mobile=req.getParameter("mobile");
		RegisterBean rb=new RegisterBean();
		rb.setUser(user);
		rb.setPword(pword);
		rb.setFname(fname);
		rb.setLname(lname);
		rb.setMail(mail);
		rb.setPhno(mobile);
		int k=RegisterDAO.insert(rb);
		if(k>0)
		{
			RequestDispatcher rd=req.getRequestDispatcher("Register.jsp");
			req.setAttribute("msg1", "Successfully registered");
			rd.forward(req, res);
		}
	}
	

}

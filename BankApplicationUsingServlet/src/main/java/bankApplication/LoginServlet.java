package bankApplication;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
@WebServlet("/log")
public class LoginServlet extends HttpServlet
{
  @Override
  public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
	  System.out.println("htggt");
	  String accno=req.getParameter("acno");
	  String name=req.getParameter("nam");
	  UserBean ub=new UserBean();
	  ub.setAccno(accno);
	  ub.setAccHolderName(name);
	  int chk=new LoginDAO().check(ub);
	  if(chk>0)
	  {
		  System.out.println("hiiii");
		  ServletContext sct=req.getServletContext();
		  sct.setAttribute("ubean", ub);
		  req.setAttribute("msg", "Login Successful...<br>");
		  RequestDispatcher rd=req.getRequestDispatcher("LogSucces.jsp");
		  rd.forward(req, res);
	  }
  }
}

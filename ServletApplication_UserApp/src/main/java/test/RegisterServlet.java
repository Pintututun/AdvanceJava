package test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/reg")
public class RegisterServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		UserBean ub=new UserBean();
		ub.setuName(req.getParameter("uname"));
		ub.setpWord(req.getParameter("pword"));
		ub.setfName(req.getParameter("fname"));
		ub.setlName(req.getParameter("lname"));
		ub.setAddr(req.getParameter("addr"));
		ub.setmId(req.getParameter("mid"));
		ub.setPhNo(Long.parseLong(req.getParameter("phno")));
		int k=new RegisterDAO().register(ub);
		if(k>0)
		{
			req.setAttribute("msg", "Registration process Successfull...<br>");
			RequestDispatcher rd=req.getRequestDispatcher("RegSuccess.jsp");
			rd.forward(req, res);
		}
	}

}

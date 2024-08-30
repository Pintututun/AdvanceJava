package test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/update")
public class UpdateProfileServlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
	Cookie c[]=req.getCookies();
	if(c==null) {
		req.setAttribute("msg", "Session Expired...<br>");
		RequestDispatcher rd=req.getRequestDispatcher("Home.jsp");
		rd.forward(req, res);
	}
	else
	{
		String value = c[0].getValue();
		req.setAttribute("fName", value);
		ServletContext sct = req.getServletContext();
		UserBean ub = (UserBean)sct.getAttribute("ubean");
		ub.setAddr(req.getParameter("addr"));
		ub.setmId(req.getParameter("mid"));
		ub.setPhNo(Long.parseLong(req.getParameter("phno")));
		int k = new UpdateProfileDAO().update(ub);
		if(k>0) {
		req.setAttribute("msg","Profile Updated Successfully..<br>");
		RequestDispatcher rd =

		req.getRequestDispatcher("UpdateProfile.jsp");

		rd.forward(req, res);
	}
}
}
}

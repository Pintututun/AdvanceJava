package userLogin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet("/dis")
public class User extends GenericServlet {

	@Override
	public void init() throws ServletException
	{
		
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String name=req.getParameter("uname");
		pw.println("Login Successful<br>");
		pw.println("Hello "+name+" Welcome To Tall Grass");
	}
	@Override
	public void destroy()
	{
		
	}

}

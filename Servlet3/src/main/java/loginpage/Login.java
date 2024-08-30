package loginpage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet("/dis")
public class Login extends GenericServlet {

	@Override
	public void init() throws ServletException{
		
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String name=req.getParameter("lname");
		String age=req.getParameter("age");
		pw.println("===============Login Page===============<br>");
		pw.println(name+",Welcome to Fashion Show");
	}
	@Override
	public void destroy()
	{}

}

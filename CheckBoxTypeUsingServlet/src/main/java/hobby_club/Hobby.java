package hobby_club;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/fill")
public class Hobby extends HttpServlet{
 
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String name=req.getParameter("name");
		String []arr=req.getParameterValues("option");
		pw.println("Hello Ram Your Hobbies are:");
		for(String x:arr)
		{
			if(x!=null)
			{
				pw.println(x+"<br>");
			}
		}
		pw.println("Thanking you,");
		
	}
}
 
package test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Calc extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException {
		resp.setContentType("text/html");
		int Marks=0;
		String name=req.getParameter("name");
		String roll=req.getParameter("roll");
		String S1=req.getParameter("q1");
		String S2=req.getParameter("q2");
		String S3=req.getParameter("q3");
		String S4=req.getParameter("q4");
		String S5=req.getParameter("q5");
		Map<Integer,String> sol=new HashMap<>();
		sol.put(1, "A");
		sol.put(2, "C");
		sol.put(3, "C");
		sol.put(4, "D");
		sol.put(5, "A");
		if(S1.equals(sol.get(1))) {
			Marks++;
		}
		if(S2.equals(sol.get(2))) {
			Marks++;
		}
		if(S3.equals(sol.get(3))) {
			Marks++;
		}
		if(S4.equals(sol.get(4))) {
			Marks++;
		}
		if(S5.equals(sol.get(5))) {
			Marks++;
		}
		
		QuizBean q=new QuizBean();
		q.setName(name);
		q.setRollNumber(roll);
		q.setMarks(Marks);
		int insert = new QuizDAO().insert(q);
		if(insert>0)
		{
			req.setAttribute("qbean", q);
			req.setAttribute("msg", "Submitted Successfully");
			RequestDispatcher rd=req.getRequestDispatcher("Submitted.jsp");
			rd.forward(req, resp);
		}
	}
}

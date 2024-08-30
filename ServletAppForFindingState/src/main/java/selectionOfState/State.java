package selectionOfState;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/states")
public class State extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String state=req.getParameter("states");
		Map<String,String> hmp=new HashMap<>();
		hmp.put("Andhra Pradesh", "Vizag");
		hmp.put("Bihar", "Patna");
		hmp.put("Chhattisgarh", "Raipur");
		hmp.put("Karnataka", "Bengaluru");
		hmp.put("Madhya Pradesh", "Bhopal");
		hmp.put("Maharahtra", "Mumbai");
		hmp.put("Odisha", "Bhubaneswar");
		hmp.put("Tamil Nadu", "Chennai");
		hmp.put("Telangana", "Hyderabad");
		if(hmp.containsKey(state))
		{
			pw.println("Your selected state is:"+state+"\ncapital="+hmp.get(state));
		}
	}

}

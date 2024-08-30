package bankApplication;

import java.io.IOException;
import java.sql.Time;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/dep")
public class DepositServlet extends HttpServlet{
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		double depositBalance=Double.parseDouble(req.getParameter("deposit"));
		ServletContext sct=req.getServletContext();
	    UserBean ub=(UserBean)sct.getAttribute("ubean");
	    ub.setAmount(depositBalance);
		int k=new DepositDAO().deposit(ub,req,res);
		if(k>0)
		{
			req.setAttribute("msg","Deposited Successfully...<br>");
			ub.setTransactionId((int)(Math.random()*100));
			ub.setTransactionTime(Calendar.HOUR_OF_DAY);
			RequestDispatcher rd=req.getRequestDispatcher("Transaction.jsp");
			rd.forward(req, res);
		}
	}

}

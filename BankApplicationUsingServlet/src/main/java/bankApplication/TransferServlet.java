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
@WebServlet("/tran")
public class TransferServlet extends HttpServlet{
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		String targetAcc=req.getParameter("targetAcc");
		Double amount=Double.parseDouble(req.getParameter("transferAmount"));
		UserBean ub1=new UserBean();
		ub1.setAccno(targetAcc);
		ServletContext sct=req.getServletContext();
		UserBean ub2=(UserBean)sct.getAttribute("ubean");
		ub2.setAmount(amount);
		int k=new TransferDAO().transfer(ub1,ub2);
		if(k>0)
		{
			req.setAttribute("msg", "Transaction Successfull...<br>");
			RequestDispatcher rd=req.getRequestDispatcher("Transaction.jsp");
			rd.forward(req, res);
		}
	}

}

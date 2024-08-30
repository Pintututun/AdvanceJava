package bankApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DepositDAO {
	public int k=0;
public int deposit(UserBean ub,HttpServletRequest req,HttpServletResponse res)
{
	try {
		
		Connection con=DBConnection.getCon();
		PreparedStatement ps=con.prepareStatement("update  BankAccount set balance=balance+? where accno=? ");
		if(ub.getAmount()<=0)
		{
			throw new Exception();
		}
		ps.setDouble(1, ub.getAmount());
		ps.setString(2, ub.getAccno());
		k=ps.executeUpdate();
	}catch(Exception e)
	{
		ServletContext sct=req.getServletContext();
		sct.setAttribute("exception","Please enter amount greater than zero");
		RequestDispatcher rd=req.getRequestDispatcher("Fail.jsp");
		try {
		rd.forward(req, res);
		}catch(Exception e1)
		{
			e1.printStackTrace();
		}
	}
	return k;
}
}

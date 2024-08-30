package bankApplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TransferDAO {
	public int k=0;
public int transfer(UserBean ub1,UserBean ub2)
{
	try {
		Connection con=DBConnection.getCon();
		PreparedStatement ps=con.prepareStatement("update BankAccount set balance=balance+? where accno=?");
		PreparedStatement ps1=con.prepareStatement("update BankAccount balance=balance-? where accno=?");
		ps1.setDouble(1, ub2.getAmount());
		ps1.setString(2, ub2.getAccno());
		int m=ps1.executeUpdate();
		if(m>0)
		{
			ResultSet rs1=ps1.executeQuery();
			if(rs1.getInt(3)>ub2.getAmount())
			{
			ps.setDouble(1, ub2.getAmount());
			ps.setString(2, ub1.getAccno());
			k=ps.executeUpdate();
				
			}
		}
		
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	return k;
}
}

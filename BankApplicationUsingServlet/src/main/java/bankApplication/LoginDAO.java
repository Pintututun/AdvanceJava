package bankApplication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {
	int  chk=0;
public int check(UserBean ub)
{
	try {
	Connection con=DBConnection.getCon();
	PreparedStatement ps=con.prepareStatement("select * from BankAccount where accno=? and accname=?");
	ps.setString(2, ub.getAccHolderName());
	ps.setString(1, ub.getAccno());
	//ResultSet rs=ps.executeQuery();
	 chk=ps.executeUpdate();
	
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	return chk;
}
}

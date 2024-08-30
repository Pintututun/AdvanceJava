package authenticateTheUserUsingPreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Autheticate {
public static boolean isValidUser(String user,String pass)
{
	boolean b=false;
	try
	{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Priyabrata");
		PreparedStatement ps=con.prepareStatement("select * from userreg where uname=? and pword=?");
		ps.setString(1, user);
		ps.setString(2, pass);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			b= true;
		}
		else
		{
			b= false;
		}
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return b;
	
}
}

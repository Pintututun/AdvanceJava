package hotel_Application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {
String fname=null;
public String check(String user,String pword)
{
	try {
		Connection con=DBConnection.getCon();
		PreparedStatement ps=con.prepareStatement("select * from HotelReg where p_user=? AND pword=?");
		ps.setString(1, user);
		ps.setString(2, pword);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			System.out.println(rs.getString(3));
			 fname=rs.getString(3);
		}
		
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	return fname;
	
}
}

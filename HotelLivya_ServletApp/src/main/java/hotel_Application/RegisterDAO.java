package hotel_Application;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RegisterDAO {
public static int k=0;
public static int insert(RegisterBean rb)
{
	try {
		Connection con=DBConnection.getCon();
		PreparedStatement ps=con.prepareStatement("insert into HotelReg values(?,?,?,?,?,?)");
		ps.setString(1, rb.getUser());
		ps.setString(2, rb.getPword());
		ps.setString(3, rb.getFname());
		ps.setString(4, rb.getLname());
		ps.setString(5, rb.getMail());
		ps.setString(6, rb.getPhno());
		k=ps.executeUpdate();
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	return k;
}
}

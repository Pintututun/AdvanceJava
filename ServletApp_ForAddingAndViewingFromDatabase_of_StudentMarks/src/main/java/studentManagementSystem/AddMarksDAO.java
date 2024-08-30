package studentManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddMarksDAO {
public int t=0;
public int insert2(MarksBean mb)
{
	try {
		
	Connection con=DBConnection.getCon();
	PreparedStatement ps1=con.prepareStatement("insert into Marks77 values(?,?,?,?,?,?)");
	ps1.setString(1, mb.getRoll());
	ps1.setInt(2, mb.getMath());
	ps1.setInt(3, mb.getPhy());
	ps1.setInt(4, mb.getChem());
	ps1.setInt(5, mb.getEng());
	ps1.setInt(6, mb.getBio());
	t=ps1.executeUpdate();
	
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	return t;
}
}

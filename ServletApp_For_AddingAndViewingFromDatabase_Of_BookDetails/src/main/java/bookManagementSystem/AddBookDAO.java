package bookManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddBookDAO {
public int k=0;
public int insert(BookBean bo)
{
	try
	{
		Connection con=DBConnection.getCon();
		PreparedStatement ps=con.prepareStatement("insert into Book100 values(?,?,?,?,?)");
		ps.setString(1, bo.getCode());
		ps.setString(2, bo.getName());
		ps.setString(3, bo.getAuthor());
		ps.setFloat(4, bo.getPrice());
		ps.setInt(5, bo.getQty());
		k=ps.executeUpdate();
		
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	return k;
}
}

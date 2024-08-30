package addingAndViewingFromDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ViewAllProductsDAO {
public ArrayList<ProductBean> al=new ArrayList<ProductBean>();
public ArrayList<ProductBean> retrieve()
{
	try {
		Connection con=DBConnection.getCon();
		//Accessing Database Connection
		PreparedStatement ps=con.prepareStatement("select * from Product55");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			ProductBean pb=new ProductBean();
			pb.setpCode(rs.getString(1));
			pb.setpName(rs.getString(2));
			pb.setpPrice(rs.getFloat(3));
			pb.setpQty(rs.getInt(4));
			al.add(pb);//Adding ProductBean object to ArrayList
		}
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	return al;
}
}

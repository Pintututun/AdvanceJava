package studentManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class ViewAllStudentDAO {
public Map<StudentBean,MarksBean> retrieve()
{
	Map<StudentBean,MarksBean> map=new HashMap<StudentBean,MarksBean>();
	try {
		Connection con=DBConnection.getCon();
		PreparedStatement ps1=con.prepareStatement("select * from Student77");
		ResultSet rs1=ps1.executeQuery();
		PreparedStatement ps2=con.prepareStatement("select * from Marks77");
		ResultSet rs2=ps2.executeQuery();
		while(rs1.next()&&rs2.next())
		{
			StudentBean sb=new StudentBean();
			sb.setRoll(rs1.getString(1));
			sb.setName(rs1.getString(2));
			sb.setBranch(rs1.getString(3));
			sb.setTotalMarks(rs1.getInt(4));
			sb.setPercentage(rs1.getFloat(5));
			sb.setResult(rs1.getString(6));
			MarksBean mb=new MarksBean();
			mb.setMath(rs2.getInt(2));
			mb.setPhy(rs2.getInt(3));
			mb.setChem(rs2.getInt(4));
			mb.setEng(rs2.getInt(5));
            mb.setBio(rs2.getInt(6));	
            map.put(sb, mb);
		}
		
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	return map;
}
}

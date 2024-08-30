package studentManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddStudentDAO {
public int k=0;
public int insert1(StudentBean st)
{
	try {
		Connection con=DBConnection.getCon();
		PreparedStatement ps=con.prepareStatement("insert into Student77 values(?,?,?,?,?,?)");
		ps.setString(1,st.getRoll() );
		ps.setString(2, st.getName());
		ps.setString(3, st.getBranch());
		ps.setInt(4, st.getTotalMarks());
		ps.setFloat(5, st.getPercentage());
		ps.setString(6, st.getResult());
		k=ps.executeUpdate();
	}catch(Exception e)
	{
		e.printStackTrace();
	}

return k;
}
}

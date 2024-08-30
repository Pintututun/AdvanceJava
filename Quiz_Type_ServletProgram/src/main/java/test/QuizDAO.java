package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class QuizDAO {
   int k=0;
   public int insert(QuizBean qb)
   {
	   try {
		   Connection con=DBConnection.getCon();
		   PreparedStatement ps=con.prepareStatement("insert into quiz55 values(?,?,?) ");
		   ps.setString(1, qb.getName());
		   ps.setString(2, qb.getRollNumber());
		   ps.setInt(3,qb.getMarks());
		   k=ps.executeUpdate();
	   }catch(Exception e)
	   {
		   e.printStackTrace();
	   }
	   return k;
   }
}

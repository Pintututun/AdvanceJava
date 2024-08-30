package jdbc_programming_UsingStatementInterface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ExecuteNormalQueriesWithoutInParameter {
public static void main(String[] args) {
	try
	{
		//Loading Driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Creating connection
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","Priyabrata");
		//Crwating object
		Statement str=con.createStatement();
		ResultSet rs=str.executeQuery("select * from Product_Details");
		System.out.println("===============Product_Details================");
		System.out.println(" CODE\tPRODUCT NAME\tPRICE\tQTY");
		while(rs.next())
		{
			System.out.println(" "+rs.getString(1)+"\t"+rs.getString(2)+"     \t"+rs.getDouble(3)+"\t"+rs.getInt(4));
			
		}
		con.close();
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
}

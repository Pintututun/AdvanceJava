package readingBookDetailsFromConsoleAndInsertIntoDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DisplayingBookDetails {
	public static void main(String[] args) {
		try {
		//step-1 : Loading driver

		Class.forName("oracle.jdbc.driver.OracleDriver");
		//step-2 : Creating Connection
		Connection con = DriverManager.getConnection
		("jdbc:oracle:thin:@localhost:1521:xe","system","Priyabrata");
		//step-3 : Preparing statements
		Statement stm = con.createStatement();
		//step-4 : Executing queries
		ResultSet rs = stm.executeQuery("select * from BookDetails");
		System.out.println("=============================BookDetails===============================");
		while(rs.next())
		{
		System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"             \t"+rs.getString(3)+"     \t"+rs.getFloat(4)+"     \t"+rs.getInt(5));
		}
		//step-5 : Closing Connection
		con.close();
		}catch(Exception e) {e.printStackTrace();}
		}
}

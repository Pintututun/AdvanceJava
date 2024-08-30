package readingBookDetailsFromConsoleAndInsertIntoDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DisplayingBookDetailsBasedOnBookCode {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		try(s;){
		try {
		System.out.println("Enter the BookCode:");
		String bCode = s.nextLine();

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection
		("jdbc:oracle:thin:@localhost:1521:xe","system","Priyabrata");
		Statement stm = con.createStatement();

		ResultSet rs = stm.executeQuery("select * from BookDetails where bookcode='"+bCode+"'");
		if(rs.next()) {
		System.out.println("Code:"+rs.getString(1)+
		"\nName"+rs.getString(2)+"\nAuthor:"+rs.getString(3)+
		"\nPrice:"+rs.getFloat(4)+"\nQty:"+rs.getInt(5));
		}else {
		System.out.println("Invalid BookCode..");
		}
		con.close();

		}catch(Exception e) {e.printStackTrace();}
		}//end of try with resource
		}
}

package readingBookDetailsFromConsoleAndInsertIntoDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class BookDetailsInserting {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		try(s;){
		      try {
		//Reading data from Console
		System.out.println("Enter the BookCode:");
		String bCode = s.nextLine();
		System.out.println("Enter the BookName:");
		                   String bName = s.nextLine();
		System.out.println("Enter the BookAuthor:");
		String bAuthor = s.nextLine();

		System.out.println("Enter the BookPrice:");
		float bPrice = s.nextFloat();
		System.out.println("Enter the BookQty:");
		int bQty = s.nextInt();

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Priyabrata");
		Statement stm = con.createStatement();
		int k = stm.executeUpdate("insert into BookDetails values('"+bCode+"','"+bName+"','"+bAuthor+"',"+bPrice+","+bQty+")");
		if(k>0) {
		System.out.println("BookDetails inserted successfully..");
		}
		con.close();
		}catch(Exception e) {e.printStackTrace();}
		}//end of try with resource statement
		}
}

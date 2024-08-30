package incrementing_salaryOfEmployee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Deleting_AParticularEmployeeNumber {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.print("Enter the employee number whose record you want to delete:");
	int eNum=sc.nextInt();
	try(sc;)
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Priyabrata");
			Statement str=con.createStatement();
			
			int k=str.executeUpdate("delete from myemp where eno="+eNum);
			ResultSet rs=str.executeQuery("select * from myemp");
			if(k>0)
			{
				System.out.println("Deleted successfully");
				
			}
			else
			{
				System.out.println("Not deleted successfully");
			}
			while(rs.next())
			{
				System.out.println("     "+rs.getInt(1)+"\t"+rs.getString(2)+"    \t"+rs.getInt(3)+"\t"+rs.getString(4));
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
}

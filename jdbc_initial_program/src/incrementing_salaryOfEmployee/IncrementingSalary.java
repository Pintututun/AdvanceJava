package incrementing_salaryOfEmployee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class IncrementingSalary {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	try (sc;) {
		System.out.print("Enter the employee number you want to increment:");
		int eNum = sc.nextInt();
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
    		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system","Priyabrata");
    		Statement str=con.createStatement();
    		int k =str.executeUpdate("update myemp set esal=esal+10000");
    		if(k>0)
    		{
    			System.out.println("Updated successfully" );
    		}
    		else
    		{
    			System.out.println("Not updated");
    		}
    		ResultSet rs=str.executeQuery("select * from myemp");
    		while(rs.next())
    		{
    			System.out.println("     "+rs.getInt(1)+"\t"+rs.getString(2)+"    \t"+rs.getInt(3)+"\t"+rs.getString(4));
    		}
    		
    		int t=str.executeUpdate("update myemp set esal=esal+5000 where eno="+eNum);
    		 rs=str.executeQuery("select * from myemp where eno="+eNum);
    		if(rs.next())
    		{
    			System.out.println("===================================================================================");
    			System.out.println("     "+rs.getInt(1)+"\t"+rs.getString(2)+"    \t"+rs.getInt(3)+"\t"+rs.getString(4));
    		}
    		else
    		{
    			System.out.println("Not updated successfully ");
    		}
    		
    		con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
}

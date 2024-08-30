package jdbc_programming_UsingStatementInterface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ExecuteEmployeeDetailsBasedOnEmployeeNumber {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
    try(sc;)
    {
    	try
    	{
    		System.out.print("Enter the employee number want to show details:");
    		int eNumber=sc.nextInt();
    		Class.forName("oracle.jdbc.driver.OracleDriver");
    		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system","Priyabrata");
    		Statement str=con.createStatement();
    		ResultSet rs=str.executeQuery("select * from myemp where eno='"+eNumber+"'");
    		if(rs.next())
    		{
    			System.out.println("     "+rs.getInt(1)+"\t"+rs.getString(2)+"    \t"+rs.getInt(3)+"\t"+rs.getString(4));
    		}
    		else {
    			System.out.println("Invalid Employee number");
    		}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }//end of try with resource
}
}

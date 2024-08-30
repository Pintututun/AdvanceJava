package jdbc_programming_UsingStatementInterface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ExtractingQueriesAndPrintingInConsole {
public static void main(String[] args) {
	try {
	//Loading Driver
	Class.forName("oracle.jdbc.driver.OracleDriver");
	//Creating Connection
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","Priyabrata");
	//Creating Object
	Statement str=con.createStatement();
	ResultSet rs=str.executeQuery("select * from myemp");
	System.out.println("=========================Employee Details======================");
	System.out.println(" EmployeeNumber\tEname\t\tEsal\tEaddr ");
	System.out.println("===============================================================");
	while(rs.next())
	{
		System.out.println("     "+rs.getInt(1)+"\t"+rs.getString(2)+"    \t"+rs.getInt(3)+"\t"+rs.getString(4));
	}
	con.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
}

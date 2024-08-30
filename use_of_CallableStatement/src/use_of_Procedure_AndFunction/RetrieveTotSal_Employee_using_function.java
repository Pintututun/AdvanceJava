package use_of_Procedure_AndFunction;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

public class RetrieveTotSal_Employee_using_function {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	try(sc;)
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Priyabrata");
			CallableStatement cs=con.prepareCall("{call ?:= RetrieveTotSal55(?)}");
			System.out.println("Enter EmpId:");
			int eid=sc.nextInt();
			cs.setInt(2, eid);
			cs.registerOutParameter(1, Types.FLOAT);
			cs.execute();
			System.out.println("=============Employee Details=========");
			System.out.println("EmpId:"+eid);
			System.out.println("Employee Total Salary:"+cs.getFloat(1));
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
}

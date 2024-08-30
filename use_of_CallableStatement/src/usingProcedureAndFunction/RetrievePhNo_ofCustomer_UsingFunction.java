package usingProcedureAndFunction;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

public class RetrievePhNo_ofCustomer_UsingFunction {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	try(sc;)
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Priyabrata");
			CallableStatement cs=con.prepareCall("{call ?:=RetrievePhNo55(?)}");
			System.out.println("Enter the Cust id:");
			int cid=sc.nextInt();
			cs.setInt(2, cid);
			cs.registerOutParameter(1, Types.BIGINT);
			cs.execute();
			System.out.println("==========Details========");
			System.out.println("CustId:"+cid);
			System.out.println("CustPhNo:"+cs.getLong(1));
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
}

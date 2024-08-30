package batchProcessingUsingPreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class BatchProcessing {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		try(s;){
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con =DriverManager.getConnection
		("jdbc:oracle:thin:@localhost:1521:xe","system","Priyabrata");
		PreparedStatement ps =con.prepareStatement("insert into Employee55 values(?,?,?,?,?)");
		System.out.println("Enter the number of employees...:");
		int n = Integer.parseInt(s.nextLine());
		System.out.println("Enter "+n+" Employee details...");
		for(int i=1;i<=n;i++)
		{

		System.out.println("====EmployeeDetails-"+i+"====");
		System.out.println("Enter empId:");
		String eId = s.nextLine();
		System.out.println("Enter empName:");
		String eName = s.nextLine();
		System.out.println("Enter empDesg:");
		String eDesg = s.nextLine();
		System.out.println("Enter empBSal:");
		int bSal =Integer.parseInt(s.nextLine());
		float totSal =bSal+(0.93F*bSal)+(0.63F*bSal);
		ps.setString(1, eId);
		ps.setString(2, eName);
		ps.setString(3, eDesg);
		ps.setInt(4, bSal);
		ps.setFloat(5, totSal);
		ps.addBatch();//Adding query with values to Batch
		System.out.println("query added to batch...");
		}//end of loop
		int k[] = ps.executeBatch();
		for(int i=0;i<k.length;i++) {
		System.out.println("Executed Successfully...");
		}
		ps.clearBatch();
		con.close();
		}catch(Exception e) {e.printStackTrace();}
		}//end of try with resource
		}
}

package insert_Modify_Delete_program_july28;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertMultipleRecordsInCustomerTable {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	try(sc;)
	{
		try
		{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Priyabrata");
	PreparedStatement ps=con.prepareStatement("insert into Customer values(?,?,?,?)");
	System.out.println("-----------------Enter the Customer Details:---------------------------");
	while(true)
	{
		
		System.out.print("Enter the customer id:");
		int cId=Integer.parseInt(sc.nextLine());
		System.out.print("Enter the customer name:");
		String cName=sc.nextLine();
		System.out.print("Enter the customer bill:");
		double bill=Double.parseDouble(sc.nextLine());
		System.out.print("Enter the customer address:");
		String addr=sc.nextLine();
		ps.setInt(1, cId);
		ps.setString(2, cName);
		ps.setDouble(3, bill);
		ps.setString(4, addr);
		int k=ps.executeUpdate();
		if(k>0)
		{
			System.out.println("Inserted properly");
			System.out.print("Do you want to continue:Press Yes/No");
			String option=sc.nextLine();
			if(option.startsWith("Y")||option.startsWith("y"))
			{
				System.out.println("------Please read the following:--------");
			}
			else
			{
				System.out.println("Thank you for exiting");
				break;
			}
		}
		else
		{
			System.out.println("Inserted unsuccessfully");
		}
	}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
			
	}
	
}
}

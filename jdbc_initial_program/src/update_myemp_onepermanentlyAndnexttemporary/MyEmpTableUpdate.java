package update_myemp_onepermanentlyAndnexttemporary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class MyEmpTableUpdate {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	try(sc;)
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Priyabrata");
			
			Statement st=con.createStatement();
			System.out.print("Enter the employee number:");
			int eno=Integer.parseInt(sc.nextLine());
			System.out.print("Enter the employee salary:");
			int esal=Integer.parseInt(sc.nextLine());
			System.out.print("Enter the employee address:");
			String eaddr=sc.nextLine();
			int k=st.executeUpdate("update myemp set esal= "+esal+" where eno="+eno+"");
			if(k>0)
			{
				System.out.println("Updated successfully");
			}
						System.out.print("Enter the employee number:");
			int eno1=Integer.parseInt(sc.nextLine());
			System.out.print("Enter the employee salary:");
			int esal11=Integer.parseInt(sc.nextLine());
			System.out.print("Enter the employee address:");
			String eaddr1=sc.nextLine();
			con.setAutoCommit(false);
			Statement stm=con.createStatement();

			int t=st.executeUpdate("update myemp set esal= "+esal+" where eno="+eno+"");
			if(t>0)
			{
				System.out.println("Updated Successfully temporarily");
				System.out.print("Do you want to save permanently:Press Yes/No");
				String option=sc.nextLine();
				if(option.startsWith("y")||option.startsWith("Y"))
				{
					con.commit();
				}
				else
				{
					System.out.println("Not saved permanently");
				}
					
			}
			else
			{
				System.out.println("Not updated successfully ");
			}
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
}

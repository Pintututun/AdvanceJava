package insertingFromTextFileToDatabase;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import connectionHelper.DBConnection;

public class EmployeeInfo {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	try(sc;)
	{
		try
		{
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("insert into employee22 values(?,?,?,?,?,?)");
			System.out.print("Enter the employee id:");
			String id=sc.nextLine();
			System.out.print("Enter the employee name:");
			String name=sc.nextLine();
			System.out.print("Enter the employee Address:");
			String addr=sc.nextLine();
			System.out.print("Enter the employee mailid:");
			String mail=sc.nextLine();
			System.out.print("Enter the employee phone number:");
			long num=Long.parseLong(sc.nextLine());
			System.out.print("Enter the employee resume path:");
			File f=new File(sc.nextLine());
			FileInputStream fis = null;
			if(f.exists())
			{
				fis=new FileInputStream(f);
			}
			while(true)
			{
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, addr);
			ps.setString(4, mail);
			ps.setLong(5, num);
			ps.setBinaryStream(6, fis,f.length());
			int k=ps.executeUpdate();
			if(k>0)
			{
				System.out.println("Employee details updated successfully");
			}
			else
			{
				System.out.println("Employee details not updated");
			}
			System.out.print("Do you want to continue:Press Yes/No");
			String option=sc.nextLine();
			if(option.startsWith("Y")||option.startsWith("y"))
			{
				System.out.println("Please read the following");
				fis.close();
			}
			else
			{
				System.out.println("Thank u for exiting");
				break;
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

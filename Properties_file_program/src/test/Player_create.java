package test;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import connectionHelper.DBConnection;

public class Player_create {
public static void main(String[] args) {
	try
	{
		Connection con = DBConnection.getCon();
		System.out.println("Connection created");
		PreparedStatement ps=con.prepareStatement("insert into Player_info values(?,?,?,?) ");
		Scanner sc=new Scanner(System.in);
		try(sc;con;)
		{
			while(true)
			{
			System.out.print("Enter the Player id:");
			String id=sc.nextLine();
			ps.setString(1, id);
			System.out.print("Enter the Player name:");
			String name=sc.nextLine();
			ps.setString(2, name);
			System.out.print("Enter the Player image file path and file name:");
			File f=new File(sc.nextLine());
			if(f.exists())
			{
				FileInputStream fis=new FileInputStream(f);
				ps.setBinaryStream(3, fis,f.length());
				
			}
			else
			{
				ps.setBinaryStream(3, null,0);
			}
			System.out.print("Enter the Player Date of Birth:");
			String dob=sc.nextLine();
			ps.setString(4, dob);
			int k=ps.executeUpdate();
			if(k>0)
			{
				System.out.println("Successfully updated");
			}
			else
			{
				System.out.println("Not Succesffuly updated");
			}
			System.out.print("Do you want to continue:Press Yes/No");
			String option=sc.nextLine();
			if(option.startsWith("Y")||option.startsWith("y"))
			{
				System.out.println("Please read the following");
			}
			else
			{
				System.out.println("Thank u....Exiting");
				break;
			}
			
			}
		}
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
}

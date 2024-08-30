package usingProcedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Scanner;

import connectionHelper.DBConnection;

public class InsertingStudentInformation {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try
		{
		Connection con=DBConnection.getCon();
		CallableStatement cs = con.prepareCall("{call RetrieveDetails(?,?,?,?,?,?,?,?)}");
		
		while(true)
		{
			System.out.println("Enter the StudentId:");
			String id = sc.nextLine();
	    System.out.print("Enter the student rollno:");
	    int number=Integer.parseInt(sc.nextLine());
	    System.out.print("Enter the student branch:");
	    String branch=sc.nextLine();
	    System.out.print("Enter the student houseno:");
	    String hno=sc.nextLine();
	    System.out.print("Enter the student city:");
	    String city=sc.nextLine();
	    System.out.print("Enter the student pincode:");
	    int pincode=Integer.parseInt(sc.nextLine());
	    System.out.print("Enter the student maid:");
	    String mid=sc.nextLine();
	    System.out.print("Enter the student phone number:");
	    long num=Long.parseLong(sc.nextLine());
		
		cs.setString(1, id);
		cs.setInt(2,number);
		cs.setString(3, branch);
		cs.setString(4,hno);
		cs.setString(5,city);
		cs.setInt(6,pincode);
		cs.setString(7,mid);
		cs.setLong(8,num);
		cs.execute();
		 System.out.print("Do you want to continue:Press Yes/No");
		    String option=sc.nextLine();
		    if(option.startsWith("Y")||option.startsWith("y"))
		    {
		    	System.out.println("Please read the following");
		    }
		    else
		    {
		    	System.out.println("Thank u for exiting");
		    	con.close();
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

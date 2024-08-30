package user_registrationAndLoginProcessUsingPreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class UserRegistrationAndLogin {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	try(sc;){
	      try {
	    	  Class.forName("oracle.jdbc.driver.OracleDriver");
	    	  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Priyabrata");
	    	  PreparedStatement ps1=con.prepareStatement("insert into userreg values(?,?,?,?,?,?,?)");
	    	  PreparedStatement ps2=con.prepareStatement("select * from userreg where uname=? ");
	    	  
	    	  while(true)
	    	  {
	    		  System.out.print("Enter 1:Registration\nEnter 2:Login");
	    		  int option=sc.nextInt();
	    		  sc.nextLine();
	    		  switch(option)
	    		  {
	    		  
	    		  case 1:System.out.println("------Welcome to Registration------");
	    		  System.out.println("Please provide the following details:");
	    		  System.out.print("Enter the user name:");
	    		  String name=sc.nextLine();
	    		  System.out.print("Enter the password:");
	    		  String pword=sc.nextLine();
	    		  System.out.print("Enter the first name:");
	    		  String fname=sc.nextLine();
	    		  System.out.print("Enter the last name:");
	    		  String lname=sc.nextLine();
	    		  System.out.print("Enter the address:");
	    		  String addr=sc.nextLine();
	    		  System.out.print("Enter the mailing id:");
	    		  String mid=sc.nextLine();
	    		  System.out.print("Enter the phone number:");
	    		  long phno=sc.nextLong();
	    		  ps1.setString(1, name);
	    		  ps1.setString(2, pword);
	    		  ps1.setString(3, fname);
	    		  ps1.setString(4,lname);
	    		  ps1.setString(5, addr);
	    		  ps1.setString(6, mid);
	    		  ps1.setLong(7, phno);
	    		  int k=ps1.executeUpdate();
	    		  if(k>0)
	    		  {
	    			  System.out.println("Registration Successfully");
	    		  }
	    		  else
	    		  {
	    			  System.out.println("Registration Unsuccessful");
	    		  }
	    		  break;
	    		  case 2:System.out.println("-------------Welcome to Login Process-------------");
	    		  System.out.print("Enter the username:");
	    		  String name1=sc.nextLine();
	    		  System.out.print("Enter the password:");
	    		  String pword1=sc.nextLine();
	    		  ps2.setString(1, name1);
	    		  ResultSet rs=ps2.executeQuery();
	    		  if(rs.next()&&(rs.getString(2).equals(pword1)))
	    		  {
	    			  System.out.println("Login Successful");
	    			  System.out.println("FirstName: "+rs.getString(3)+"\nLastName: "+rs.getString(4)+"\nAddress: "+rs.getString(5)+"\nMailingId: "+rs.getString(6)+"\nPhoneNumber: "+rs.getLong(7));
	    			 System.exit(0);
	    		  }
	    		  else {
	    			  System.out.println("Invalid Login Process");
	    		   System.out.println("Please provide correct username and password");
		    		  	  
	    		  }
	    		  break;
	    		 
	    	      default: System.out.println("Please provide the correct option:");
	    	     } 
	    	  }
	      } catch(Exception e)
	       {
	    	  e.printStackTrace();
	       }
	}
}
}



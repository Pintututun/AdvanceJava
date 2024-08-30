package studentChecking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Student {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	try (sc;) {
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
					"Priyabrata");
			PreparedStatement ps1 = con.prepareStatement("select * from Student");
			PreparedStatement ps2=con.prepareStatement("insert into Student values(?,?,?,?)");
			System.out.print("Enter the number of Students:");
			int choice=Integer.parseInt(sc.nextLine());
			int t;
			for(int j=1;j<=choice;j++)
			{
			System.out.print("Enter the Student id:");
			int id=Integer.parseInt(sc.nextLine());
			ps2.setInt(1, id);
			System.out.print("Enter the Student Name:");
			String name=sc.nextLine();
			ps2.setString(2, name);
			while(true)
			{
			System.out.print("Enter the email id:");
			String mailId=sc.nextLine();
			StringBuilder sbl=new StringBuilder(mailId);
			int check=sbl.lastIndexOf("@gmail.com");
			if(check!=-1)
			{
				System.out.println("Correct mail id");
				ps2.setString(3, mailId);
				break;
			}
			else
			{
			sbl.append("@gmail.com");
			ps2.setString(3, sbl.toString());
			break;
			}
			
			}
			while(true)
			{
			System.out.print("Enter the mobile number:");
			String mobile=sc.nextLine();
			StringBuilder sb=new StringBuilder("+91-");
			if(mobile.length()==10)
			{
				char[] m=mobile.toCharArray();
				for(char check:m)
				{
					if(check>=48&&check<=57)
					{
						sb.append(check);
					}
					else
					{
						System.out.println("Enter only digit");
						break;
					}
					
				}
				ps2.setString(4, mobile);
				break;
			}
			else
			{
				System.out.println("Enter the mobile number digits equal to 10");
			}
			}
			t=ps2.executeUpdate();
			if(t>0)
			{
				System.out.println("Student with roll number:"+j+" is updated properly");
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


package authenticateTheUserUsingPreparedStatement;

import java.util.Scanner;

public class ValidateUser {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	try(sc;)
	{
		System.out.print("Enter user name:");
		String name=sc.nextLine();
		System.out.print("Enter the password:");
		String password=sc.nextLine();
		boolean check=Autheticate.isValidUser(name,password);
		if(check==true)
		{
			System.out.println("Correct username and password");
		}
		else
		{
			System.out.println("Incoorect username and password");
		}
		
	}
}
}

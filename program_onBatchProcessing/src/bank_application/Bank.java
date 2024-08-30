package bank_application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	try(sc;)
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Priyabrata");
			Statement stm=con.createStatement();
			ArrayList<Float> al = new ArrayList<>();
			System.out.print("Enter the number of accounts want to add:");
			int num=Integer.parseInt(sc.nextLine());
			for(int i=1;i<=num;i++)
			{
				System.out.print("Enter the account number:");
				long accNo=Long.parseLong(sc.nextLine());
				System.out.print("Enter the customer name:");
				String cusName=sc.nextLine();
				System.out.print("Enter the balance:");
				float bal=Float.parseFloat(sc.nextLine());
				stm.addBatch("insert into Accounts values("+accNo+",'"+cusName+"',"+bal+")");
				
			}
			
			while(true)
			{
				System.out.print("Enter the account number you want to update:");
				long acc1=Long.parseLong(sc.nextLine());
				System.out.println("Enter 1:Withdraw");
				System.out.println("Enter 2:Add");
				int option=Integer.parseInt(sc.nextLine());
				if(option==1)
				{
					System.out.print("Enter the amount to withdraw:");
					float amount=Float.parseFloat(sc.nextLine());
					
					stm.addBatch("update Accounts set balance=balance-"+amount+"where account_number="+acc1);
				}
				else
				{
					System.out.println("Enter the ammount to add:");
					float amt=Float.parseFloat(sc.nextLine());
					stm.addBatch("update Accounts set balance=balance+"+amt+" where account_number="+acc1);
				}
				System.out.print("Do you want to continue:Press Yes/No");
				String choice=sc.nextLine();
				if(choice.startsWith("y")||choice.startsWith("Y"))
				{
					System.out.println("Thank you for continuing");
				}
				else
				{
					System.out.println("Execution stopped");
					break;
				}
			}
			stm.executeBatch();
			stm.clearBatch();
			ResultSet rs  = stm.executeQuery("select * from accounts");
			
			while(rs.next())
			{
				al.add(rs.getFloat(3));
			}
			
			}
		
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}


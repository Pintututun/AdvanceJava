package program_toExecuteProcedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class CustomerDetails {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		try(s;){
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Priyabrata");
		CallableStatement cs = con.prepareCall("{call CustDetails55(?,?,?,?,?,?,?)}");
		System.out.println("Enter CustId:");
		int cId = Integer.parseInt(s.nextLine());
		System.out.println("Enter CustName:");
		String cName = s.nextLine();
		System.out.println("Enter CustCity:");
		String city = s.nextLine();
		System.out.println("Enter CustState:");
		String state = s.nextLine();
		System.out.println("Enter PinCode:");
		int pinCode =Integer.parseInt(s.nextLine());
		System.out.println("Enter CustMailId:");
		String mId = s.nextLine();
		System.out.println("Enter CustPhNo:");
		long phNo = Long.parseLong(s.nextLine());
		cs.setInt(1, cId);
		cs.setString(2, cName);
		cs.setString(3, city);
		cs.setString(4, state);
		cs.setInt(5, pinCode);
		cs.setString(6, mId);
		cs.setLong(7, phNo);
		cs.execute();
		System.out.println("Procedure executed Successfully...");
		con.close();
		}catch(Exception e) {e.printStackTrace();}

		}//end of try with resource
		}
}

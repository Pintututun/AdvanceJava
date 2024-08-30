package use_of_Procedure_AndFunction;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class Employee {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try (sc;) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
						"Priyabrata");
				CallableStatement cs = con.prepareCall("{call EmpDetails55(?,?,?,?,?,?,?,?,?,?,?,?)}");
				System.out.print("Enter the employee id:");
				int id = Integer.parseInt(sc.nextLine());
				System.out.print("Enter the employee name:");
				String name = sc.nextLine();
				System.out.print("Enter the employee designation:");
				String desg = sc.nextLine();
				System.out.print("Enter the employee city:");
				String city = sc.nextLine();
				System.out.print("Enter the employee state:");
				String state = sc.nextLine();
				System.out.print("Enter the employee pincode:");
				int pincode = Integer.parseInt(sc.nextLine());
				System.out.print("Enter the employee mail id:");
				String mid = sc.nextLine();
				System.out.print("Enter the employee phone number:");
				long phno = Long.parseLong(sc.nextLine());
				System.out.print("Enter the employee basic salary:");
				float bsal = Float.parseFloat(sc.nextLine());
				float hra = 0.93F * bsal;
				float da = 0.61F * bsal;
				float totsal = bsal + hra + da;
				cs.setInt(1, id);
				cs.setString(2, name);
				cs.setString(3, desg);
				cs.setString(4, city);
				cs.setString(5, state);
				cs.setInt(6, pincode);
				cs.setString(7, mid);
				cs.setLong(8, phno);
				cs.setFloat(9, bsal);
				cs.setFloat(10, hra);
				cs.setFloat(11, da);
				cs.setFloat(12, totsal);
				cs.execute();
				System.out.println("Procedure executed completely");
				try (con;) {
				}

			} catch (Exception e) {
				e.printStackTrace();

			}
		}
	}
}

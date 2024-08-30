package incrementing_salaryOfEmployee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class InsertingEmployeeAndConvertingToUpperCase {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try (sc;) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
						"Priyabrata");
				Statement str = con.createStatement();
				while (true) {
					System.out.print("Enter the employee number:");
					int eNum = sc.nextInt();
					System.out.print("Enter the employee name:");
					String eName = sc.nextLine();
					System.out.print("Enter the employee salary:");
					int eSal = sc.nextInt();
					System.out.print("Enter the employee Address");
					String eAddr = sc.nextLine();
					int k = str.executeUpdate(
							"insert into myemp values (" + eNum + ",'" + eName + "'," + eSal + ",'" + eAddr + "')");
					if (k > 0) {
						System.out.println("Inserted");
					} else {
						System.out.println("Not inserted");
					}
					System.out.print("Do you want to continue ,Press Yes/No");
					if (sc.nextLine().startsWith("y") || sc.nextLine().startsWith("Y")) {
						System.out.println("Please enter the value");
					} else {
						break;
					}
				}
			} catch (Exception e) {

			}
		}
	}
}

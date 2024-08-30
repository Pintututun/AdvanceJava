package jdbc_programming_UsingStatementInterface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class InsertingData {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try (sc;) {
			System.out.print("Enter how many employee details want to insert:");
			int num = sc.nextInt();

			try {
				// Loading Driver
				Class.forName("oracle.jdbc.driver.OracleDriver");
				// Creating Connection
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system",
						"Priyabrata");
				// Creating Object
				Statement str = con.createStatement();
				for (int i = 1; i <= num; i++) {
					System.out.print("Enter the employee number:");
					int eNumber = sc.nextInt();sc.nextLine();
					System.out.print("Enter the employee name:");
					String eName = sc.nextLine();
					System.out.print("Enter the employee salary:");
					double eSal = sc.nextDouble();sc.nextLine();
					System.out.print("Enter the employee address:");
					String eAddr = sc.nextLine();
					int k = str.executeUpdate("insert into myemp values('" + eNumber + "','" + eName + "','" + eSal
							+ "','" + eAddr + "')");
					if (k > 0) {
						System.out.println("Inserted Succeffuly");
					}
				}
				ResultSet rs = str.executeQuery("select * from myemp");
				System.out.println("=========================Employee Details======================");
				System.out.println(" EmployeeNumber\tEname\t\tEsal\tEaddr ");
				System.out.println("===============================================================");
				while (rs.next()) {
					System.out.println("     " + rs.getInt(1) + "\t" + rs.getString(2) + "    \t" + rs.getInt(3) + "\t"
							+ rs.getString(4));
				}
				con.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

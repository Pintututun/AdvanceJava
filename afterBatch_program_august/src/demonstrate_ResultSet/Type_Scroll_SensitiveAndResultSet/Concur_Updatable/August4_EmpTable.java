package demonstrate_ResultSet.Type_Scroll_SensitiveAndResultSet.Concur_Updatable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class August4_EmpTable {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try (sc;) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
						"Priyabrata");
				PreparedStatement ps = con.prepareStatement("insert into emp values(?,?,?,?)",
						ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				PreparedStatement ps1 = con.prepareStatement("select * from emp", ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				System.out.print("Enter how many employee records want to insert:");
				int num = Integer.parseInt(sc.nextLine());
				for (int i = 1; i <= num; i++) {
					System.out.print("Enter the employee number:");
					int eno = Integer.parseInt(sc.nextLine());
					System.out.print("Enter the employee name:");
					String name = sc.nextLine();
					System.out.print("Enter the employee job:");
					String job = sc.nextLine();
					System.out.print("Enter the employee salary:");
					int sal = Integer.parseInt(sc.nextLine());
					ps.setInt(1, eno);
					ps.setString(2, name);
					ps.setString(3, job);
					ps.setInt(4, sal);
					int k = ps.executeUpdate();
					if (k > 0) {
						System.out.println("Inserted Successfully");
					} else {
						i--;
					}
				}
				ResultSet rs1 = ps1.executeQuery();
				while (true) {
					System.out.println("Press 1:Print the records in top-to-bottom order.");
					System.out.println("Press 2:Print the records in bottom-to-top order.");
					System.out.println("Press 3:Print the first record..");
					System.out.println("Press 4:Print the last record.");
					System.out.println(
							"Press 5:Print the record at an absolute position (3rd record from the beginning).");
					System.out.println("Press 6:Print the record at an absolute position (6th record from the end).");
					System.out.println(
							"Press 7:Print the record at a relative position (2 records ahead of the current position)");
					System.out.println(
							"Press 8:Print the record at a relative position (4 records back from the current position)");
					System.out.print("Enter the your option:");
					int option = Integer.parseInt(sc.nextLine());
					switch (option) {
					case 1:
						System.out.println("ENO\tENAME\tEJOB\tESAL");
						while (rs1.next()) {
							System.out.println(rs1.getInt(1) + "\t" + rs1.getString(2) + "\t" + rs1.getString(3) + "\t"
									+ rs1.getInt(4));
						}
						break;
					case 2:
						rs1.afterLast();
						System.out.println("ENO\tENAME\tEJOB\tESAL");
						while (rs1.previous()) {
							System.out.println(rs1.getInt(1) + "\t" + rs1.getString(2) + "\t" + rs1.getString(3) + "\t"
									+ rs1.getInt(4));
						}
						break;
					case 3:
						rs1.first();
						System.out.println("ENO\tENAME\tEJOB\tESAL");
						System.out.println(rs1.getInt(1) + "\t" + rs1.getString(2) + "\t" + rs1.getString(3) + "\t"
								+ rs1.getInt(4));
						break;
					case 4:
						rs1.last();
						System.out.println("ENO\tENAME\tEJOB\tESAL");
						System.out.println(rs1.getInt(1) + "\t" + rs1.getString(2) + "\t" + rs1.getString(3) + "\t"
								+ rs1.getInt(4));
						break;
					case 5:
						rs1.absolute(3);
						System.out.println("ENO\tENAME\tEJOB\tESAL");
						System.out.println(rs1.getInt(1) + "\t" + rs1.getString(2) + "\t" + rs1.getString(3) + "\t"
								+ rs1.getInt(4));
						break;
					case 6:
						rs1.absolute(-6);
						System.out.println("ENO\tENAME\tEJOB\tESAL");
						System.out.println(rs1.getInt(1) + "\t" + rs1.getString(2) + "\t" + rs1.getString(3) + "\t"
								+ rs1.getInt(4));
						break;
					case 7:
						rs1.relative(2);
						System.out.println("ENO\tENAME\tEJOB\tESAL");
						System.out.println(rs1.getInt(1) + "\t" + rs1.getString(2) + "\t" + rs1.getString(3) + "\t"
								+ rs1.getInt(4));
						break;
					case 8:
						rs1.relative(-4);
						System.out.println("ENO\tENAME\tEJOB\tESAL");
						System.out.println(rs1.getInt(1) + "\t" + rs1.getString(2) + "\t" + rs1.getString(3) + "\t"
								+ rs1.getInt(4));
						break;
					default:
						System.out.println("Wrong choice");
					}

					System.out.println("Do you want to continue:Press Yes/No");
					String choice = sc.nextLine();
					if (choice.startsWith("Y") || choice.startsWith("y")) {
						System.out.println("Please read the following");
					} else {
						System.out.println("Execution completed");
						break;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

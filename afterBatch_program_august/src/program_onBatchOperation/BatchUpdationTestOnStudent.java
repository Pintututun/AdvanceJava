package program_onBatchOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class BatchUpdationTestOnStudent {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try (sc;) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
						"Priyabrata");
				PreparedStatement ps = con.prepareStatement("insert into Student55 values(?,?,?,?)");
				PreparedStatement ps1 = con.prepareStatement("update Student55 set avg=avg+10 where sno>=10000");
				PreparedStatement ps2 = con.prepareStatement("delete from Student55 where sno<=10");
				System.out.println("Enter the number of Student deatils...:");
				int n = Integer.parseInt(sc.nextLine());
				System.out.println("Enter " + n + " Student details...");
				for (int i = 1; i <= n; i++) {

					System.out.println("====Student Details-" + i + "====");
					System.out.println("Enter Student SNO:");
					int sno = Integer.parseInt(sc.nextLine());
					System.out.println("Enter Student Name:");
					String sName = sc.nextLine();
					System.out.println("Enter Student location:");
					String sLoc = sc.nextLine();
					System.out.println("Enter Student average:");
					int avg = Integer.parseInt(sc.nextLine());
					ps.setInt(1, sno);
					ps.setString(2, sName);
					ps.setString(3, sLoc);
					ps.setInt(4, avg);
					ps.addBatch();
				}
				ps1.addBatch();
				ps2.addBatch();
				int[] k = ps.executeBatch();
				int[] t=ps1.executeBatch();
				int[] m=ps2.executeBatch();
				ps.clearBatch();
				ps1.clearBatch();
				ps2.clearBatch();
				

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}

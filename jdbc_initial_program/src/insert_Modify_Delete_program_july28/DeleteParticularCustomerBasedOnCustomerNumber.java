package insert_Modify_Delete_program_july28;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteParticularCustomerBasedOnCustomerNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try (sc;) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
						"Priyabrata");
				PreparedStatement ps = con.prepareStatement("delete from customer  where cid=?");
				System.out.print("Enter the customer id which you want to delete:");
				int cId = Integer.parseInt(sc.nextLine());
				ps.setInt(1, cId);
				int k = ps.executeUpdate();
				if (k > 0) {
					System.out.println("Deleted successfully");
				} else {
					System.out.println("Enter the correct customer id:");
				}
				con.close();
			} catch (Exception e) {

			}
		}

	}
}

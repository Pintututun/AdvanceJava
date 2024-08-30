package insert_Modify_Delete_program_july28;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class ModifyCustomerAddress {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try (sc;) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
						"Priyabrata");
				PreparedStatement ps = con.prepareStatement("update customer set addr=? where cid=?");
				System.out.print("Enter the customer id whose address want to modify:");
				int cId = Integer.parseInt(sc.nextLine());
				System.out.print("Enter the customer address:");
				String addr = sc.nextLine();
				ps.setString(1, addr);
				ps.setInt(2, cId);
				int k = ps.executeUpdate();
				if (k > 0) {
					System.out.println("Modified successfully");
				} else {
					System.out.println("Customer id does not exist");
				}
			} catch (Exception e) {

			}

		}
	}
}

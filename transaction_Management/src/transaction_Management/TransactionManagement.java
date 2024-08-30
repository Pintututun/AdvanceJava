package transaction_Management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.util.Scanner;

public class TransactionManagement {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		try (s;) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","Priyabrata");
				System.out.println("Commit-status:" + con.getAutoCommit());
				con.setAutoCommit(false);
				System.out.println("Commit-status:" + con.getAutoCommit());
				PreparedStatement ps1 = con.prepareStatement("select * from Bank55 where accno=?");
				PreparedStatement ps2 = con.prepareStatement("update Bank55 set bal=bal+? where accno=?");
				Savepoint sp = con.setSavepoint();
				System.out.println("Enter the HomeAccNo(Alex):");

				long hAccNo = s.nextLong();
				ps1.setLong(1, hAccNo);
				ResultSet rs1 = ps1.executeQuery();
				if (rs1.next()) {
					float bl = rs1.getFloat(3); // bl=10000/-
					System.out.println("Enter beneficiery AccNo(Ram):");
					long bAccNo = s.nextLong();
					ps1.setLong(1, bAccNo);
					ResultSet rs2 = ps1.executeQuery();
					if (rs2.next()) {
						System.out.println("Enter the amt to be transferred:");
						float amt = s.nextFloat();// amt=3000/-
						if (amt <= bl) {
							ps2.setFloat(1, -amt);
							ps2.setLong(2, hAccNo);
							int p = ps2.executeUpdate();// Updated in Buffer
							ps2.setFloat(1, +amt);
							ps2.setLong(2, bAccNo);
							int q = ps2.executeUpdate();// Updated in Buffer
							if (p == 1 && q == 1) {
								con.commit();// Update in database
								System.out.println("Transaction Successfull...");
							} else {
								System.out.println("Transaction failed...");
								con.rollback(sp);
							}
						} else {
							System.out.println("Insufficient fund...");
						}

					} else {
						System.out.println("Invalid bAccNo...");
					}
				} else {
					System.out.println("Invalid HomeAccNo...");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // end of try with resource
	}
}

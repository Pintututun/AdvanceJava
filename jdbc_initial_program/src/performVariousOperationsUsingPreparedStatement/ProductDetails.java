package performVariousOperationsUsingPreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ProductDetails {
public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	try (s;) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","Priyabrata");
			PreparedStatement ps1 = con.prepareStatement("insert into Product values(?,?,?,?,?)");// Compilation
			PreparedStatement ps2 = con.prepareStatement("select * from Product");// Compilation
			PreparedStatement ps3 = con.prepareStatement("select * from Product where ProductId=?");// Compilation
			PreparedStatement ps4 = con.prepareStatement("update Product set Price=?,Total=? where ProductId=?");// Compilation
			PreparedStatement ps5 = con.prepareStatement("delete from Product where ProductId=?");// Compilation
			
			while (true) {
				System.out.println("************************************Choice**********************************************");
				System.out.println("\t1.AddProduct" + "\n\t2.ViewAllProduct" + "\n\t3.ViewProductByCode"+"\n\t4.UpdateProductByCode(price-qty)" + "\n\t5.DeleteProductByCode" + "\n\t6.Exit");
				System.out.println("Enter the Choice:");

				int choice = Integer.parseInt(s.nextLine());
				switch (choice) {
				case 1:
					System.out.println("------------Employee-Details-----------");
					System.out.println("Enter the ProductId:");
					String eId = s.nextLine();
					System.out.println("Enter the Product Name:");
					String eName = s.nextLine();
					System.out.println("Enter the Product Price:");
					int price = Integer.parseInt(s.nextLine());
					System.out.println("Enter the Product Quantity:");
					int qty = Integer.parseInt(s.nextLine());
					float total=price*qty;
					// Loading data to PreparedStatement Object
					ps1.setString(1, eId);
					ps1.setString(2, eName);
					ps1.setInt(3, price);
					ps1.setInt(4, qty);
					ps1.setFloat(5,total);
					
					int k = ps1.executeUpdate();// Execution
					if (k > 0) {
						System.out.println("Product Added Successfully...");
					}
					break;
				case 2:
					ResultSet rs = ps2.executeQuery();// Execution

					while (rs.next()) {
						System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) + "\t"
								+ rs.getInt(4) + "\t" + rs.getFloat(5));
					}
					break;
				case 3:
					System.out.println("Enter the ProdutId:");
					String eId2 = s.nextLine();
			        ps3.setString(1, eId2);
					ResultSet rs2 = ps3.executeQuery();// Execution
					if (rs2.next()) {
						System.out.println("Id:" + rs2.getString(1) + "\nName:" + rs2.getString(2) + "\nPrice:"
								+ rs2.getInt(3) + "\nQuantiy:" + rs2.getInt(4) + "\nTotal:" + rs2.getFloat(5));
					} else {
						System.out.println("Invalid ProductId...");
					}
					break;
				case 4:
					System.out.println("Enter the ProductId:");
					String eId3 = s.nextLine();
					ps3.setString(1, eId3);
					ResultSet rs3 = ps3.executeQuery();
					if (rs3.next()) {

						System.out.println("Enter new price:");
						int nprice = Integer.parseInt(s.nextLine());
						float nTotSal = nprice*rs3.getInt(4);
						ps4.setInt(1, nprice);
						ps4.setFloat(2, nTotSal);
						int k2 = ps4.executeUpdate();
						if (k2 > 0) {
							System.out.println("Product Updated...");
						}
					} else {
						System.out.println("Invalid ProductId...");
					}
					break;
				case 5:
					System.out.println("Enter the ProductId:");
					String eId4 = s.nextLine();
					ps3.setString(1, eId4);
					ResultSet rs4 = ps3.executeQuery();
					if (rs4.next()) {
						ps5.setString(1, eId4);
						int k3 = ps5.executeUpdate();// Execution
						if (k3 > 0) {
							System.out.println("Product deleted...");
						}
					} else {
						System.out.println("Invalid ProductId..");
					}
					break;
				case 6:
					System.out.println("Operations Stopped...");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid choice...");
				}// end of switch
			} // end of loop
		} catch (Exception e) {
			e.printStackTrace();
		}
}
}
}

package performVariousOperationsOnBookDetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class BookDetails {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try (sc;) {
			try {
				
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","Priyabrata");
				PreparedStatement ps1 = con.prepareStatement("insert into BookDetails values(?,?,?,?,?)");
				PreparedStatement ps2 = con.prepareStatement("select * from BookDetails");
				PreparedStatement ps3 = con.prepareStatement("select * from BookDetails where bookcode=?");
				PreparedStatement ps4 = con.prepareStatement("update bookdetails set bookprice=?,bookqty=? where bookcode=?");
				PreparedStatement ps5 = con.prepareStatement("delete from bookdetails where bookcode=?");
				while(true)
				{
				System.out.println("1:AddBook   \n2:ViewAllBooks  \n3:ViewBookByCode   \n4:UpdateBookByCode(price-qty)   \n5:DeleteBookByCode    \n6:Exit");
				System.out.print("Enter the option:");
				int option = Integer.parseInt(sc.nextLine());
				switch (option) {
				case 1:
					System.out.print("Enter the bookcode:");
					int bcode = Integer.parseInt(sc.nextLine());
					System.out.print("Enter the book name:");
					String bname = sc.nextLine();
					System.out.print("Enter the book author:");
					String bauthor = sc.nextLine();
					System.out.print("Enter the book price:");
					float price = Float.parseFloat(sc.nextLine());
					System.out.print("Enter the book quantity:");
					int qty = Integer.parseInt(sc.nextLine());
					ps1.setInt(1, bcode);
					ps1.setString(2, bname);
					ps1.setString(3, bauthor);
					ps1.setFloat(4, price);
					ps1.setInt(5, qty);
					int k = ps1.executeUpdate();
					if (k > 0) {
						System.out.println("Added Successfully");
					} else {
						System.out.println("Not Added");
					}
					break;
				case 2:
					ResultSet rs2 = ps2.executeQuery();
					System.out.println("BCode\tBName\tBAuthor\tBPrice\tBQty");
					while (rs2.next()) {
						System.out.println(rs2.getInt(1) + "\t" + rs2.getString(2) + "\t" + rs2.getString(3) + "\t"
								+ rs2.getFloat(4) + rs2.getInt(5));
					}
					break;
				case 3:
					System.out.print("Enter the book code:");
					int bcode1 = Integer.parseInt(sc.nextLine());
					ps3.setInt(1, bcode1);
					ResultSet rs3 = ps3.executeQuery();
					if (rs3.next()) {
						System.out.println("BookCode: " + rs3.getInt(1) + "\nBookName: " + rs3.getString(2)
								+ "\nBookAuthor: " + rs3.getString(3) + "\nBookPrice: " + rs3.getFloat(4)
								+ "\nBookQuantity: " + rs3.getInt(5));
					} else {
						System.out.println("Book code not found");
					}
					break;
				case 4:
					System.out.print("Enter the book code:");
					int bcode2 = Integer.parseInt(sc.nextLine());
					System.out.print("Enter the book price:");
					float nprice = Float.parseFloat(sc.nextLine());
					System.out.print("Enter the book quantity:");
					int nqty = Integer.parseInt(sc.nextLine());
					ps4.setFloat(1, nprice);
					ps4.setInt(2, nqty);
					ps4.setInt(3, bcode2);
					int t = ps4.executeUpdate();
					if (t > 0) {
						System.out.println("Updated Successfully");
					} else {
						System.out.println("Not updated");
					}
					break;
				case 5:
					System.out.print("Enter the book code:");
					int bcode3 = Integer.parseInt(sc.nextLine());
					ps5.setInt(1, bcode3);
					int l = ps5.executeUpdate();
					if (l > 0) {
						System.out.println("Deleted Successfully");
					} else {
						System.out.println("Book code not found");
					}
					break;
				case 6:
					System.out.println("Operations stopped..");
					System.exit(0);
				default:System.out.println("Invalid Choice");

				}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

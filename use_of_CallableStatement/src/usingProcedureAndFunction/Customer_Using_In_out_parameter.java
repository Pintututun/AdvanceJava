package usingProcedureAndFunction;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

public class Customer_Using_In_out_parameter {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try (sc;) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
						"Priyabrata");
				CallableStatement cs = con.prepareCall("{call RetrieveDetails55(?,?,?,?,?,?,?)}");
				System.out.println("Enter the CustId:");
				int cid = sc.nextInt();
				cs.setInt(1, cid);
				cs.registerOutParameter(2, Types.VARCHAR);
				cs.registerOutParameter(3, Types.VARCHAR);
				cs.registerOutParameter(4, Types.VARCHAR);
				cs.registerOutParameter(5, Types.INTEGER);
				cs.registerOutParameter(6, Types.VARCHAR);
				cs.registerOutParameter(7, Types.BIGINT);
				cs.execute();
				System.out.println("=============CustDetails============");
				System.out.println("CustId:" + cid);
				System.out.println("CustName:" + cs.getString(2));
				System.out.println("CustCity:" + cs.getString(3));
				System.out.println("CustState:" + cs.getString(4));
				System.out.println("Pincode:" + cs.getInt(5));
				System.out.println("Mailid:" + cs.getString(6));
				System.out.println("Phone no:" + cs.getLong(7));
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

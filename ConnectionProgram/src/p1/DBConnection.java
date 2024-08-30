package p1;

import java.sql.Connection;
import java.util.Scanner;

public class DBConnection {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		try (s;) {
			try {
				System.out.println("Enter DB-UserName:");
				String uName = s.nextLine();
				System.out.println("Enter DB-PassWord:");
				String pWord = s.nextLine();
				System.out.println("Enter the number of Connections:");
				int n = s.nextInt();
				ConnectionPool cp = new ConnectionPool("jdbc:oracle:thin:@localhost:1521:xe", uName, pWord);// Con_Call
				System.out.println("****Pool-size****");
				System.out.println("Pool-Size:" + cp.v.size());
				cp.createConnetions(n);
				System.out.println("****Pool-size****");
				System.out.println("Pool-Size:" + cp.v.size());
				System.out.println("=====User-1=====");
				Connection con1 = cp.getConnectionFromPool();
				System.out.println(con1);
				System.out.println("****Pool-size****");
				System.out.println("Pool-Size:" + cp.v.size());
				System.out.println("=====User-2=====");

				Connection con2 = cp.getConnectionFromPool();
				System.out.println(con2);
				System.out.println("****Pool-size****");
				System.out.println("Pool-Size:" + cp.v.size());
				System.out.println("****User-1*****");
				cp.returnConnection(con1);
				System.out.println("****Pool-size****");
				System.out.println("Pool-Size:" + cp.v.size());
				System.out.println("****User-2****");
				cp.returnConnection(con2);
				System.out.println("****Pool-size****");
				System.out.println("Pool-Size:" + cp.v.size());
				System.out.println("=====DisplayAllConnection====");
				cp.v.forEach((k) -> {
					System.out.println(k);
				});
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // end of try
	}
}

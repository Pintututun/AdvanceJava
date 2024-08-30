package p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Vector;

public class ConnectionPool {
	// Instance Variables
	public String url, uName, pWord;
	public Vector<Connection> v = new Vector<Connection>();

	// Vector object created to hold UnLimited Connection Objects
	public ConnectionPool(String url, String uName, String pWord) {
		this.url = url;
		this.uName = uName;
		this.pWord = pWord;
	}

	public void createConnetions(int n) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			while (v.size() < n) {
				System.out.println("Pool is not full...");
				Connection con = DriverManager.getConnection(url, uName, pWord);

				v.addElement(con);// Adding Connection to Pool
				System.out.println(con);
			} // end of loop
			if (v.size() == n) {
				System.out.println("Pool is full...");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// end of method

	public Connection getConnectionFromPool() {
		Connection con = v.elementAt(0);// Connection from index 0
		v.removeElementAt(0);// Connection removed from pool
		return con;
	}// end of method

	public void returnConnection(Connection con) {
		v.addElement(con);// Connection added back to pool
		System.out.println("Connection added back to pool...");
	}// end of method
}

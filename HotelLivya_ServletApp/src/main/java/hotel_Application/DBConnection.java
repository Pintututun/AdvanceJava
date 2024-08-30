package hotel_Application;


import java.sql.Connection;
import java.sql.DriverManager;
import static hotel_Application.DBInfo.*;

public class DBConnection {
	private DBConnection() {
	}

	public static Connection con = null;
	static {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, uname, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getCon()
	{
		return con;
	}
}


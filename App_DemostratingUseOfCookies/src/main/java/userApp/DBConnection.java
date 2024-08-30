package userApp;

import static userApp.DBInfo.*;
import java.sql.Connection;

import java.sql.*;

public class DBConnection {
	public static Connection con=null;

	private DBConnection() {
	}

	static {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(dbURL, uName, pWord);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getCon() {
		return con;
	}
}

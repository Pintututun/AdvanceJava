package studentManagementSystem;



import java.sql.Connection;
import java.sql.DriverManager;
import static studentManagementSystem.DBInfo.*;
public class DBConnection {
	private static Connection con;
	private DBConnection() {}
	static
	{
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(dburl,duser,dpword);
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static Connection getCon()
	{
		return con;
	}

	}




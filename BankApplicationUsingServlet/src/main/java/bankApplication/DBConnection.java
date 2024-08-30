package bankApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import static bankApplication.DBInfo.*;
public class DBConnection {
public  static Connection con=null;
static
{
	try {
		Class.forName(driver);
		con=DriverManager.getConnection(dbURL,user,pword);
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

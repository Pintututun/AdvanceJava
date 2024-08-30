package connectionHelper;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
public class DBConnection	
{
	private static Connection con = null;
	private DBConnection() {}
	static
	{
		try
		{
			FileInputStream fis=new FileInputStream("JDBC.properties");
			Properties po=new Properties();
			po.load(fis);
			Class.forName(po.getProperty("jdbc.driver"));
			String user=po.getProperty("jdbc.user");
			String pass=po.getProperty("jdbc.password");
			String url=po.getProperty("jdbc.url");
			 con=DriverManager.getConnection(url,user,pass);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getCon()
	{
		return con;
	}
}

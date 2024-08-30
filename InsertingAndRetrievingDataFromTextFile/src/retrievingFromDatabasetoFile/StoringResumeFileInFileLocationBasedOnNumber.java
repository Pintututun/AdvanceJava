package retrievingFromDatabasetoFile;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import connectionHelper.DBConnection;

public class StoringResumeFileInFileLocationBasedOnNumber {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	try(sc;)
	{
		try
		{
			Connection con=DBConnection.getCon();
			System.out.println("Connection created");
			PreparedStatement ps=con.prepareStatement("select * from employee22 where empphno=?");
			System.out.print("Enter the phone number:");
			long num=Long.parseLong(sc.nextLine());
			ps.setLong(1, num);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
			InputStream re=rs.getBinaryStream(6);
			FileOutputStream fos=new FileOutputStream("E:\\Resume.txt");
			int k;
			while((k=re.read())!=-1)
			{
				fos.write(k);
				
			}
			System.out.println("File retrieved");
			fos.close();
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
}

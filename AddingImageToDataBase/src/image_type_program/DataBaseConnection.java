package image_type_program;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DataBaseConnection {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	try(sc;)
	{
		try
		{
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Priyabrata");
			PreparedStatement ps=con.prepareStatement("insert into StreamTab55 values(?,?)");
			System.out.println("Enter the Id:");
			String id=sc.nextLine();
			ps.setString(1, id);
			System.out.println("Enter file path And file name(Source)");
			File f=new File(sc.nextLine());
			if(f.exists())
			{
				FileInputStream fis=new FileInputStream(f);
				ps.setBinaryStream(2, fis,f.length());
				int k=ps.executeUpdate();
				if(k>0)
				{
					System.out.println("Image stored successfully");
				}
				else
				{
					System.out.println("Invalid file path or file name...");
				}
			}
			con.close();
			}catch(Exception e)
		{
				e.printStackTrace();
		}
	}
}
}

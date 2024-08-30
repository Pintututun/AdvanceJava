package test;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;

import connectionHelper.DBConnection;

public class RetrievePlayerDetails {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	try(sc;)
	{
	try
	{
		Connection con=DBConnection.getCon();
		System.out.println("Connection created");
		PreparedStatement ps=con.prepareStatement("select * from Player_info where PID=?");
		System.out.println("Enter the player id:");
		String playerId=sc.nextLine();
		ps.setString(1, playerId);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			System.out.println(rs.getString(1)+rs.getString(2)+rs.getString(4));
			InputStream is = rs.getBinaryStream(3);
			System.out.println("Enter Path : ");
			String path = sc.next();
			FileOutputStream fos = new FileOutputStream(path);
			IOUtils.copy(is, fos);
		}
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}
}
}

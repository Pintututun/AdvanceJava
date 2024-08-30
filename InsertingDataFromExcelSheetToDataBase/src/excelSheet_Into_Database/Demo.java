package excelSheet_Into_Database;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.Scanner;

import connectionHelper.DBConnection;

public class Demo {
	public static void main(String[] args) throws Exception {
		Connection con = DBConnection.getCon();
		PreparedStatement ps = con.prepareStatement("insert into demo values(?,?,?)");
		InputStream fis = new FileInputStream("E:\\MOCK_DATA.csv");
	    Scanner sc = new Scanner(fis);
		while(sc.hasNext())
		{
			String [] arr = sc.next().split(",");
			System.out.println(Arrays.toString(arr));
			for(int i = 1;i<=arr.length;i++)
			{
				ps.setString(i, arr[i-1]);
			}
			ps.executeUpdate();
		}
	}
}

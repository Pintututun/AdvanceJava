package row_set_program;

import java.util.Scanner;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class DBCon {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		try(s;){
		try {
		//RowSetFactory implementation Object

		RowSetFactory rsf =RowSetProvider.newFactory();
		System.out.println("=====Choice======");
		System.out.println("\t1.JdbcRowSet"+ "\n\t2.CachedRowSet");
		System.out.println("Enter the Choice:");
		int choice = s.nextInt();
		switch(choice) {
		case 1:
		//JdbcRowSet implementation Object
		JdbcRowSet jrs = rsf.createJdbcRowSet();
		jrs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		jrs.setUsername("system");
		jrs.setPassword("Priyabrata");
		jrs.setCommand("select * from BookDetails");
		jrs.execute();
		System.out.println("====BookDetails=====");
		while(jrs.next()) {
		System.out.println(jrs.getString(1)+"\t"+jrs.getString(2)+"\t"+jrs.getString(3)+"\t"+jrs.getFloat(4)+"\t"+jrs.getInt(5));
		}
		break;
		case 2:
		//CachedRowSet implementation Object
		CachedRowSet crs =rsf.createCachedRowSet();
		crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		crs.setUsername("system");
		crs.setPassword("Priyabrata");
		crs.setCommand("select * from Employee55");
		crs.execute();

		System.out.println("=====EmployeeDetails======");
		while(crs.next()) {
		System.out.println(crs.getString(1)+"\t"+crs.getString(2)+"\t"+crs.getString(3)+"\t"+crs.getInt(4)+"\t"+crs.getFloat(5));
		}
		break;
		default:
		System.out.println("Invalid Choice.....");
		}//end of switch
		}catch(Exception e) {e.printStackTrace();}
		}//end of try with resource
		}
}

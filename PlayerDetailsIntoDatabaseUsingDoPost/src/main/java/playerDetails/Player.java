package playerDetails;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/fill")
public class Player extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		FileInputStream fis=new FileInputStream("E:\\Pictures\\"+req.getParameter("image"));
		PlayerBean pb=new PlayerBean();
		pb.setId(id);
		pb.setName(name);
		pb.setImg(fis);
		int k=new AddPlayersDAO().insert(pb);
		if(k>0)
		{
			pw.println("Image successfully inserted");
		}
		
	}
}


package hotel_Application;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/sweetRoom")
public class SweetRoomServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		String room1=req.getParameter("sweet");
		HttpSession session=req.getSession(false);
		FoodBean fb=(FoodBean)session.getAttribute("fbean");
		fb.setSweetRoom(room1);
		Double hotelBill=fb.getSweetRoomPrice();
		session.setAttribute("room", hotelBill);
		System.out.println(fb);
		RequestDispatcher rd=req.getRequestDispatcher("ViewTotal.jsp");
		rd.forward(req, res);
	}

}

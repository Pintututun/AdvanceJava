package hotel_Application;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/dessert")
public class DessertServlet extends HttpServlet{
  @Override
  public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		 String[] food3 = req.getParameterValues("food");
	        String fiQuantity = req.getParameter("fi");
	        String hgjQuantity = req.getParameter("hgj");
	        HttpSession session=req.getSession(false);
	        FoodBean fb=(FoodBean)session.getAttribute("fbean");
	        if (food3 != null) {
	            for (String food : food3) {
	                if(food.equals("fi"))
	                {
	                	fb.setIceCream("Fried Ice Cream");
	                	fb.setIceCreamQty(Integer.parseInt(fiQuantity));
	                }
	                if(food.equals("hgj"))
	                {
	                	fb.setGulabJamun("Hot Gulab Jamun");
	                	fb.setGulabJamunQty(Integer.parseInt(hgjQuantity));
	                }
	            }
	        }
	        System.out.println(fb);
	        res.sendRedirect("Food.html");
	}

  }

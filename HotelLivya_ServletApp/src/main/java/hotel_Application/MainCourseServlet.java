package hotel_Application;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/maincourse")
public class MainCourseServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		 String[] food2 = req.getParameterValues("food");
	        String cbmQuantity = req.getParameter("cbm");
	        String chQuantity = req.getParameter("ch");

	        // Process the form data as needed
	        // You can perform actions based on the selected checkboxes and quantities

	        // For demonstration purposes, let's just print the selected values
	       HttpSession session=req.getSession(false);
	       FoodBean fb=(FoodBean)session.getAttribute("fbean");
	        if (food2 != null) {
	            for (String food : food2) {
	                if(food.equals("cbm"))
	                {
	                	fb.setButterMasala("Chicken Butter Masala");
	                	fb.setButterMasalaQty(Integer.parseInt(cbmQuantity));
	                }
	                if(food.equals("ch"))
	                {
	                	fb.setHyderabadi("Chicken hyderabadi");
	                	fb.setHyderabadiQty(Integer.parseInt(chQuantity));
	                }
	            }
	        }

//	        System.out.println("Chicken Butter Masala: " + cbmQuantity);
//	        System.out.println("Chicken hyderabadi: " + chQuantity);

	        // You can perform further processing here

	        // Redirect back to the form page or another appropriate page
	        res.sendRedirect("Food.html");
	}

}

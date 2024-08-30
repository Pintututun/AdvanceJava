package hotel_Application;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/starter")
public class StarterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve values from the request parameters
        String[] food1 = request.getParameterValues("food");
        String clQuantity = request.getParameter("cl");
        String ccQuantity = request.getParameter("cc");

        // Process the form data as needed
        // You can perform actions based on the selected checkboxes and quantities

        FoodBean fb= (FoodBean) request.getSession(false).getAttribute("fbean");
        
        if (food1 != null) {
            for (String food : food1) {
            	System.out.println(food);
                if(food.equals("cl"))
                {
                	
                	fb.setLollypop("Chicken Lollypop");
                	fb.setLollypopQty(Integer.parseInt(clQuantity));
                }
                if(food.equals("cc"))
                {
                	fb.setCrispyChicken("Crispy Chicken");
                	fb.setCrispyChickenQty(Integer.parseInt(ccQuantity));
                }
            }
        }
        System.out.println(fb);
        // Redirect back to the form page or another appropriate page
        response.sendRedirect("Food.html");
    }
}
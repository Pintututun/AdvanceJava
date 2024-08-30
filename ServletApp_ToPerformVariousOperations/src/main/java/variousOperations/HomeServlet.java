package variousOperations;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.swing.DefaultBoundedRangeModel;
@WebServlet("/dis")
public class HomeServlet extends GenericServlet {

	@Override
	public void init() throws ServletException {

	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		int option = Integer.parseInt(req.getParameter("op"));
		int num = Integer.parseInt(req.getParameter("num"));
		switch (option) {

		case 1:
			long fac = 1;
			for (int i = 1; i <= num; i++) {
				fac = fac * i;
			}
			pw.println("Factorial of the number:" + num);
			break;
		case 2:
			String factor = ",";
			for (int i = 1; i <= num; i++) {
				if (num % i == 0) {
					factor = i + factor;
				}
			}
			pw.println("Factor of the number:" + factor);
			break;
		case 3:
			int count = 0;
			for (int i = 2; i < num; i++) {
				if (num % i == 0) {
					count++;
				}
				if (count > 2) {
					pw.println("It is not prime");
					break;
				}
			}
			if (count == 2) {
				pw.println("It is prime");
			}
			break;
		case 4:
			int rev = 0;
			for (int i = num; i != 0; i /= 10) {
				int rem = i % 10;
				rev = rev * 10 + rem;

			}
			if (rev == num) {
				pw.println("It is palindrome");
			} else {
				pw.println("It is not palindrome");
			}
			break;
		case 5:
			int digit = 0;
			for (int i = num; i != 0; i /= 10) {
				digit++;
			}
			int arm = 0;
			for (int i = num; i != 0; i /= 10) {
				int rem = i % 10;
				arm = arm + (int) Math.pow(rem, digit);
			}
			if (arm == num) {
				pw.println("It is armstrong");
			} else {
				pw.println("It is not armstrong");
			}
			break;
		default:
			pw.println("Invalid option");
		}

	}

	@Override
	public void destroy() {

	}

}

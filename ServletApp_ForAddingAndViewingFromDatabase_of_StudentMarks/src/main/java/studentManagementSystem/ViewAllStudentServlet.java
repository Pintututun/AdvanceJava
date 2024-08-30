package studentManagementSystem;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewAllStudentServlet extends GenericServlet {

	@Override
	public void init() {
		
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter pw1=res.getWriter();
		res.setContentType("text/html");
		Map<StudentBean,MarksBean> map=new ViewAllStudentDAO().retrieve();
		pw1.println("==============All Student Details==========<br>");
		for(Map.Entry<StudentBean, MarksBean> m:map.entrySet())
		{
			StudentBean sb=(StudentBean)m.getKey();
			MarksBean mb=(MarksBean)m.getValue();
			pw1.println(sb+""+mb+"<br>================");
		}
//		pw1.println(map.size());
	}
	@Override
	public void destroy()
	{
		
	}

}

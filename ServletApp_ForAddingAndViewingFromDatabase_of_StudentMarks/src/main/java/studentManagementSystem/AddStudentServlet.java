package studentManagementSystem;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@SuppressWarnings("serial")
@WebServlet("/fill")
public class AddStudentServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
     PrintWriter pw=res.getWriter();
     res.setContentType("text/html");
     String roll=req.getParameter("roll");
     String name=req.getParameter("sname");
     String branch=req.getParameter("branch");
     int math=Integer.parseInt(req.getParameter("math"));
     int chem=Integer.parseInt(req.getParameter("chem"));
     int phy=Integer.parseInt(req.getParameter("phy"));
     int eng=Integer.parseInt(req.getParameter("eng"));
     int bio=Integer.parseInt(req.getParameter("bio"));
     int totalmarks=math+chem+phy+eng+bio;
     float percentage=(float)(math+chem+phy+eng+bio)/5;
     String result;
     if(percentage>40)
     {
    	 result="Pass";
     }
     else
     {
    	 result="Fail";
     }
     StudentBean st=new StudentBean();
     MarksBean mb=new MarksBean();
     st.setRoll(roll);
     st.setName(name);
     st.setBranch(branch);
     st.setTotalMarks(totalmarks);
     st.setPercentage(percentage);
     st.setResult(result);
     mb.setRoll(roll);
     mb.setMath(math);
     mb.setPhy(phy);
     mb.setChem(chem);
     mb.setEng(eng);
     mb.setBio(bio);
     int k=new AddStudentDAO().insert1(st);
     int t=new AddMarksDAO().insert2(mb);
     if(k>0&&t>0)
     {
    	 pw.println("Welcome");
    	RequestDispatcher rd=req.getRequestDispatcher("home.html");
    	rd.include(req, res);
     }
     else
     {
    	 pw.println("Please give deatils");
     }
	}
     @Override
     public void destroy()
     {
    	 
     }
		
	

}



import java.io.IOException;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class registerVoter
 */
@WebServlet("/registerVoter")
public class registerVoter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		 DbManager db = new DbManager();
		 java.sql.Connection con = db.getConnection();
		 
		 String fname = request.getParameter("fname");
		 String phone = request.getParameter("phone");
		 String emailid = request.getParameter("emailid");
		 String gender = request.getParameter("gender");
		 String dob = request.getParameter("dateof");
		 String address = request.getParameter("add");
		 String voternum = request.getParameter("voternum");
		 
		 try
		 {
			PreparedStatement st = con.prepareStatement("insert into Voters(fname,phone,emailid,gender,dob,address,voternum)values('"+fname+"','"+phone+"','"+emailid+"','"+gender+"','"+dob+"','"+address+"','"+voternum+"')"); 
			st.executeUpdate();
			response.sendRedirect("adminwel.jsp");
		 }
		 
		 catch(Exception e)
		 {
			e.printStackTrace(); 
		 }
		
		  
		 
		
	}

}

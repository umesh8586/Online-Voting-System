

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class voterLogin
 */
@WebServlet("/voterLogin")
public class voterLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		 DbManager db = new DbManager();
		 java.sql.Connection con = db.getConnection();
		
		 String voternum = request.getParameter("voterNumber");
		 
		 try
		 {
			 PreparedStatement st = con.prepareStatement("select voternum from Votes where voternum='"+voternum+"'");  
				ResultSet rs = ((java.sql.Statement)st).executeQuery("select voternum from Votes where voternum='"+voternum+"'");  
				if(rs.next())
				{
						response.sendRedirect("voted.jsp");
					
				}
				else
				{
					PreparedStatement st2 = con.prepareStatement("select voternum from Voters where voternum='"+voternum+"'");  
					ResultSet rs1 = ((java.sql.Statement)st2).executeQuery("select voternum from Voters where voternum='"+voternum+"'");  
					if(rs1.next())
					{
						response.sendRedirect("userlog.jsp");
							
						
					} 
					else
					{
						System.out.println("User not registered");
						response.sendRedirect("notReg.jsp");
					}
				} 
			 
		 }
		catch(Exception e)
		 {
			e.printStackTrace();
		 }
	}

}

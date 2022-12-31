  

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/adminWelcome")
public class adminWelcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public adminWelcome()
	{
		super();
	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			response.setContentType("text/html");
			 DbManager db = new DbManager();
			 java.sql.Connection con = db.getConnection();
			 
			 String aname = request.getParameter("userId");
			 String password = request.getParameter("apass");
			 
			 try
			 {
				PreparedStatement st = con.prepareStatement("select * from adminl where aname='"+aname+"' and password='"+password+"'");  
				ResultSet rs = ((java.sql.Statement)st).executeQuery("select * from adminl where aname='"+aname+"' and password='"+password+"'");  
				if(rs.next())
				{
					HttpSession session = request.getSession();
					session.setAttribute("aname", aname);
					response.sendRedirect("adminwel.jsp");
					
				}
				else
				{
					response.sendRedirect("wrongCredentials.jsp");
					System.out.println("wrong credintials");
				}
			 }
			 catch(Exception e)
			 {
				e.printStackTrace(); 
			 }
			 
	} 

}

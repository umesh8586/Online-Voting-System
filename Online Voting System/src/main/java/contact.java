

import java.io.IOException;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class contact
 */
@WebServlet("/contact")
public class contact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public contact() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
		 DbManager db = new DbManager();
		 java.sql.Connection con = db.getConnection();
		 
		 String Name = request.getParameter("fname");
		 String PhoneNumber = request.getParameter("phone");
		 String Email = request.getParameter("emailid");
		 String Comments = request.getParameter("comments");
		 
		 try
		 {
			PreparedStatement st = con.prepareStatement("insert into contact(Name,PhoneNumber,Email,Comments)values('"+Name+"','"+PhoneNumber+"','"+Email+"','"+Comments+"')"); 
			st.executeUpdate();
			response.sendRedirect("formSub.jsp");
		 }
		 
		 catch(Exception e)
		 {
			e.printStackTrace(); 
		 }
		 
		 
		 
		  
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

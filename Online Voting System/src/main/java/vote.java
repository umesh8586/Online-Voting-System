

import java.io.IOException;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class vote
 */
@WebServlet("/vote")
public class vote extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		 DbManager db = new DbManager();
		 java.sql.Connection con = db.getConnection();
		
		 
		 String voternum = request.getParameter("voterNumber");
		 String parties = request.getParameter("parties");
		 
		 try
		 {
		 
		 PreparedStatement st1 = con.prepareStatement("insert into votes(voternum,fname)values('"+voternum+"',(select fname from voters WHERE voternum = '"+voternum+"'))");
		 PreparedStatement st2 = con.prepareStatement("insert into votecount(voternum,parties)values('"+voternum+"','"+parties+"')");
		 st1.executeUpdate();
		 st2.executeUpdate();
		 response.sendRedirect("voteDone.jsp");
		 
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
	} 

}

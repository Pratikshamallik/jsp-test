import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/editreturn")
public class EditReturn extends HttpServlet {

	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	int row;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String phone = request.getParameter("phone");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb", "root", "1234");
			
			pst = con.prepareStatement("select * from member where phone =?");
			pst.setString(1, phone);
			
			rs = pst.executeQuery();
			
			while(rs.next())
			{

				out.println("<head><link rel=\"stylesheet\" href=\"https://bootswatch.com/4/yeti/bootstrap.min.css\"></head>");
				out.println("<body>");
				out.println("<nav class='navbar justify-content-between navbar-expand navbar-dark bg-primary'>\r\n"
						+ "	<a class='navbar-brand' href='index.jsp'>Pratiksha's Project</a>\r\n"
						+ "	<ul class='navbar-nav navbar-right'>\r\n"
						+ "		<li class='nav-item'><a class='nav-link' href='logout.jsp'>Logout</a></li>\r\n"
						+ "	</ul>\r\n"
						+ "</nav>");
				
				out.println("<div class='container mt-5'>\r\n"
						+ "<div class='card'>\r\n"

						+ "<h4 class='card-header'>Update Details</h4>\r\n"
						+ "<div class='card-body'>\r\n"
						+ "<form action='editservlet' method='POST'>\r\n"
				
						+ "<div class='form-group'>\r\n"
						+ "<label>Name</label>\r\n"
						+ "<input class='form-control' type='text' name='uname' value='" 
						+ rs.getString("uname") + "'/>\r\n"
						+ "</div>\r\n"
				
						+ "<div class='form-group '>\r\n"
						+ "<label>Age</label>\r\n"
						+ "<input class='form-control' type='text' name='age' value='" 
						+ rs.getString("age") + "'/>\r\n"
						+ "</div>");
				
				out.println("<div class='form-group '>");out.println("<label>Gender</label>\r\n"
						+ "<input class='form-control' type='text' name='gender' value='" 
						+ rs.getString("gender") + "'/>");
				out.println("</div>");				
				
				out.println("<div class='form-group '>");
				out.println("<label>Address</label>\r\n" 
						+ "<input class='form-control' type='text' name='address' value='" 
						+ rs.getString("address") + "'/>");
				out.println("</div>");				
				
				out.println("<div class='form-group  '>");out.println("<label>Password</label>\r\n" 
						+ "<input class='form-control' type='text' name='password' value='" 
						+ rs.getString("password") 
						+ "'/>");
				out.println("</div>");
				
				out.println("<div class='form-group '>");
				out.println("<input class='btn btn-danger' type='submit' name='submit' value='Update' />");
				out.println("</div>");
				out.println("</form>");
				out.println("</div>");
				out.println("</div>");
				out.println("</div>");
				
				out.println("</body>");
			}
			
		
		
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			out.println ("fialed");
		}
	}

	
}

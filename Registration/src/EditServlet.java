import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/editservlet")
public class EditServlet extends HttpServlet {

	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	int row;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
				
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb", "root", "1234");
			
			String uname = request.getParameter("uname");
			String age = request.getParameter("age");			
			String gender = request.getParameter("gender");
			String address = request.getParameter("address");
			String password = request.getParameter("password");			
		
			pst = con.prepareStatement("update member set uname = ?, age = ?, gender = ?, address = ?, password = ?");
			pst.setString(1, uname);
			pst.setString(2, age);
			pst.setString(3, gender);
			pst.setString(4, address);
			pst.setString(5, password);
			
			row = pst.executeUpdate();
			
//			response.sendRedirect("login.jsp");
			
			out.println("<head><link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css\" integrity=\"sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l\" crossorigin=\"anonymous\"></head>");
			out.println("<body>");
			out.println("<nav class='navbar justify-content-between navbar-expand navbar-dark bg-secondary'>\r\n"
					+ "	<a class='navbar-brand' href='index.jsp'>Pratiksha's Project</a>\r\n"
					+ "	<ul class='navbar-nav navbar-right'>\r\n"
					+ "		<li class='nav-item'><a class='nav-link' href='logout.jsp'>Logout</a></li>\r\n"
					+ "	</ul>\r\n"
					+ "</nav>");
			
			out.println("<div class='container mt-5'>\r\n"
					+ "<div class='card'>\r\n"

					+ "<h1 class='card-header'><font color='green'>Update Success.</font></h1>\r\n"
					+ "<div class='card-body'>");
			out.println("<a class='btn btn-success' href='logout.jsp'>Logout</a>");
			
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			out.println ("fialed");
		}
	}
	
	
}

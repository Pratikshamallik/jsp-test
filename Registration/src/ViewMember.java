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


@WebServlet("/viewmember")
public class ViewMember extends HttpServlet {
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	int row;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb", "root", "1234");
			
			String sql;
			String phone = request.getParameter("phone");
			
			pst = con.prepareStatement("select * from member where phone=?");
			pst.setString(1, phone);
			
			rs = pst.executeQuery();
			out.println("<head><link rel=\"stylesheet\" href='https://bootswatch.com/4/yeti/bootstrap.min.css'\"></head>");
			out.println("<body>");
			out.println("<nav class='navbar justify-content-between navbar-expand navbar-dark bg-primary'>\r\n"
					+ "	<a class='navbar-brand' href='index.jsp'>Pratiksha's Project</a>\r\n"
					+ "	<ul class='navbar-nav navbar-right'>\r\n"
					+ "		<li class='nav-item'><a class='nav-link' href='logout.jsp'>Logout</a></li>\r\n"
					+ "	</ul>\r\n"
					+ "</nav>");
			out.println("<div class='container'>");
			out.println("<table class='table table-striped table-hover m-5'>");
			out.println("<thead class=' bg-info'>");
			out.println("<tr>");out.println("<th width ='250px'> <strong>Info</strong> </th><th>Value</th>");out.println("</tr>");
			out.println("</thead>");
			out.println("<tbody>");
			while(rs.next())
			{
			out.println("<tr>");out.println("<td width ='250px'> <strong>Name</strong> </td><td>"+ rs.getString("uname") + "</td>");out.println("</tr>");
			out.println("<tr>");out.println("<td> <strong>Phone</strong> </td><td>" + rs.getString("phone") + "</td>");out.println("</tr>");
			out.println("<tr>");out.println("<td> <strong>Age</strong> </td><td>" + rs.getString("age") + "</td>");out.println("</tr>");
			out.println("<tr>");out.println("<td> <strong>Gender</strong> </td><td>" + rs.getString("gender") + "</td>");out.println("</tr>");
			out.println("<tr>");out.println("<td> <strong>Address</strong> </td><td>" + rs.getString("address") + "</td>");out.println("</tr>");
			out.println("<tr>");out.println("<td> <strong>Password</strong> </td><td>" + rs.getString("password") + "</td>");out.println("</tr>");
			out.println("<tr>");
			out.println("<td colspan=2>"+ "<a class='btn btn-danger btn-sm' href='editreturn?phone=" + rs.getString("phone")+ "'>Edit</a>" + "</td>");
			out.println("</tr>");

			}
			out.println("</tbody>");
			out.println("</table>");
			out.println("</contanier>");
			out.println("</body>");
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			out.println ("fialed");
		}
	}
	
}

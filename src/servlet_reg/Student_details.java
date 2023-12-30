package servlet_reg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Student_details
 */
@WebServlet("/Student_details")
public class Student_details extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Student_details() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		try {
			HttpSession session=request.getSession(false);
			String n=session.getAttribute("staffid").toString();
			PrintWriter p=response.getWriter(); 
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/proj1","root","root");
			String sql=" select * from student_account where staffid='"+n+"' ";
			PreparedStatement stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery(sql);
			response.setContentType("text/html");
			p.print("<!DOCTYPE html>\r\n" + 
					"<html lang=\"en\">\r\n" + 
					"<head>\r\n" + 
					"    <meta charset=\"UTF-8\">\r\n" + 
					"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + 
					"    <title>Staff Dashboard</title>\r\n" + 
					"    <link rel=\"stylesheet\" href=\"Student_details.css\">\r\n" + 
					"    <link rel=\"stylesheet\" href=\"fontawesome-free-6.4.2-web/fontawesome-free-6.4.2-web/css/all.css\">\r\n" + 
					"    \r\n" + 
					"</head>\r\n" + 
					"<body>\r\n" + 
					"    <div class=\"container\">\r\n" + 
					"        <div class=\"row\">\r\n" + 
					"            <nav>\r\n" + 
					"                <a href=\"home.html\" style=\"text-decoration: none;\"><label class=\"logo\">ABC College</label></a>\r\n" + 
					"                \r\n" + 
					"                <ul>\r\n" + 
					"                    <i class=\"profile fa-solid fa-user fa-lg\"></i>\r\n" + 
					"                        <div class=\"dropdown\">\r\n" + 
					"                            <button class=\"dropbtn\">Profile</button>\r\n" + 
					"                            <div class=\"dropdown-content\">\r\n" + 
					"                              <a href=\"#\">SignOut</a>\r\n" + 
					"                              <a href=\"#\">Link 2</a>\r\n" + 
					"                              <a href=\"#\">Link 3</a>\r\n" + 
					"                            </div>\r\n" + 
					"                          </div>\r\n" + 
					"                </ul>\r\n" + 
					"            </nav>\r\n" + 
					"        </div>\r\n" + 
					"        <div class=\"body1\">\r\n" + 
					"           \r\n" + 
					"            <div class=\"sidebar\">\r\n" + 
					"                <form action=\"\">\r\n" + 
					"                    <div class=\"bar\">\r\n" + 
					"                        <div class=\"bar1\"></div>\r\n" + 
					"                        <button class=\"btn1\"><a href=\"dash_servlet\">Dashboard</a></button>\r\n" + 
					"                    </div>\r\n" + 
					"                    <div class=\"bar\">\r\n" + 
					"                        <div class=\"bar1\"></div>\r\n" + 
					"                        <button class=\"btn1\"><a href=\"Staff_details.html\">Staff details</a></button>\r\n" + 
					"                    </div>\r\n" + 
					"                    <div class=\"bar\">\r\n" + 
					"                        <div class=\"bar1\"></div>\r\n" + 
					"                        <button class=\"btn1\"><a href=\"Staff_update.html\">Update Details</a></button>\r\n" + 
					"                    </div>\r\n" + 
					"                    <div class=\"bar\">\r\n" + 
					"                        <div class=\"bar1\"></div>\r\n" + 
					"                        <button class=\"btn1\">Delete Details</button>\r\n" + 
					"                    </div>\r\n" + 
					"                    <div class=\"bar\">\r\n" + 
					"                        <div class=\"bar1\"></div>\r\n" + 
					"                        <button class=\"btn1\"><a href=\"Student_details.html\">Student details</a></button>\r\n" + 
					"                    </div>\r\n" + 
					"                    <div class=\"bar\">\r\n" + 
					"                        <div class=\"bar1\"></div>\r\n" + 
					"                        <button class=\"btn1\"><a href=\"Student_add.html\">Add Details</a></button>\r\n" + 
					"                    </div>\r\n" + 
					"                    <div class=\"bar\">\r\n" + 
					"                        <div class=\"bar1\"></div>\r\n" + 
					"                        <button class=\"btn1\"><a href=\"Student_update.html\">Update Details</a></button>\r\n" + 
					"                    </div>\r\n" + 
					"                    <div class=\"bar\">\r\n" + 
					"                        <div class=\"bar1\"></div>\r\n" + 
					"                        <button class=\"btn1\"><a href=\"Student_delete.html\">Add Marklist</a></button>\r\n" + 
					"                    </div>\r\n" + 
					"                </form>\r\n" + 
					"            </div>\r\n" + 
					"\r\n" + 
					"            <div class=\"workspace\">\r\n" + 
					"               \r\n" + 
					"                    <label for=\"\" class=\"heading\">Student Details</label>\r\n" + 
					"                    <div class=\"table1\">");
			
			p.print("<table>");
			p.print("<thead> \r\n" + 
					"			<th>Regno</th>\r\n" + 
					"			<th>Name</th>\r\n" + 
					"			<th>Branch</th>\r\n" + 
					"			<th>Date of Birth</th>\r\n" + 
					"			<th>Action</th>\r\n" + 
					"			</thead>");
			
				while(rs.next()) {
				p.print(" <tbody> <td>"+rs.getInt("regno")+" </td>"
						+ "<td>"+rs.getString("name")+" </td>"
						+ "<td>"+rs.getString("branch")+" </td>"
						+ "<td>"+rs.getDate("dob")+" </td>");
						
				p.print("<td style='display:flex;'><button class='btn'><a href='view_servlet?stid="+rs.getInt("slno")+"'>View</a></button> <button class='btn'><a href='Delete_servlet?stid="+rs.getInt("slno")+"'>Remove</a></button> <button class='btn'><a href='Studentmarklist_servlet?stid="+rs.getInt("regno")+"'>Add Mark</a></button> <button class='btn'><a href='viewMark_servlet?stid="+rs.getInt("regno")+"'>View Mark</a></button></td>");
				p.print("</tbody>");
		

			}
				
			p.print("</table>");
			p.print(" </div>\r\n" + 
					"            </div>\r\n" + 
					"        \r\n" + 
					"        </div>\r\n" + 
					"\r\n" + 
					"    </div>\r\n" + 
					"\r\n" + 
					"    \r\n" + 
					"</body>\r\n" + 
					"</html> ");
		} catch (Exception e) {
			System.out.println(e);
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

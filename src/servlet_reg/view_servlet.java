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

/**
 * Servlet implementation class update_servlet
 */
@WebServlet("/view_servlet")
public class view_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public view_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id=request.getParameter("stid");
		response.setContentType("text/html");
		PrintWriter p=response.getWriter();
		
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/proj1","root","root");
			String sql="select * from Student_account where slno='"+id+"'";
			PreparedStatement stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
			p.print("<!DOCTYPE html>\r\n" + 
					"<html lang=\"en\">\r\n" + 
					"<head>\r\n" + 
					"    <meta charset=\"UTF-8\">\r\n" + 
					"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + 
					"    <title>Student view</title>\r\n" + 
					"    <link rel=\"stylesheet\" href=\"Student_view.css\">\r\n" + 
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
					"                              \r\n" + 
					"                            </div>\r\n" + 
					"                        </div>\r\n" + 
					"                </ul>\r\n" + 
					"            </nav>\r\n" + 
					"        </div>\r\n" + 
					"        <div class=\"body1\">\r\n" + 
					"           \r\n" + 
					"            <div class=\"sidebar\">\r\n" + 
					"                <form action=\"\">\r\n" + 
					"                    <div class=\"bar\">\r\n" + 
					"                        <div class=\"bar1\"></div>\r\n" + 
					"                        <button class=\"btn\"><a href=\"dash_servlet\">Dashboard</a></button>\r\n" + 
					"                    </div>\r\n" + 
					"                    <div class=\"bar\">\r\n" + 
					"                        <div class=\"bar1\"></div>\r\n" + 
					"                        <button class=\"btn\"><a href=\"Staff_details.html\">Staff details</a></button>\r\n" + 
					"                    </div>\r\n" + 
					"                    <div class=\"bar\">\r\n" + 
					"                        <div class=\"bar1\"></div>\r\n" + 
					"                        <button class=\"btn\"><a href=\"Staff_update.html\">Update Details</a></button>\r\n" + 
					"                    </div>\r\n" + 
					"                    <div class=\"bar\">\r\n" + 
					"                        <div class=\"bar1\"></div>\r\n" + 
					"                        <button class=\"btn\">Delete Details</button>\r\n" + 
					"                    </div>\r\n" + 
					"                    <div class=\"bar\">\r\n" + 
					"                        <div class=\"bar1\"></div>\r\n" + 
					"                        <button class=\"btn\"><a href=\"Student_details\">Student details</a></button>" + 
					"                    </div>\r\n" + 
					"                    <div class=\"bar\">\r\n" + 
					"                        <div class=\"bar1\"></div>\r\n" + 
					"                        <button class=\"btn\"><a href=\"Student_add.html\">Add Details</a></button>\r\n" + 
					"                    </div>\r\n" + 
					"                    <div class=\"bar\">\r\n" + 
					"                        <div class=\"bar1\"></div>\r\n" + 
					"                        <button class=\"btn\"><a href=\"Student_update.html\">Update Details</a></button>\r\n" + 
					"                    </div>\r\n" + 
					"                    <div class=\"bar\">\r\n" + 
					"                        <div class=\"bar1\"></div>\r\n" + 
					"                        <button class=\"btn\"><a href=\"Student_delete.html\">Delete Details</a></button>\r\n" + 
					"                    </div>\r\n" + 
					"                </form>\r\n" + 
					"            </div>\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"            <div class=\"workspace\">\r\n" + 
					"                <div class=\"box\">\r\n" + 
					"                    <label for=\"\" class=\"heading\">Student Details</label>\r\n" + 
					"                    <form action=\"dash_servlet\" method=\"get\">\r\n" + 
					"                        <label for=\"\" class=\"text\" >Full Name</label><br>\r\n" + 
					"                        <input type=\"text\" class=\"textbox\" value="+rs.getString("name")+"><br>\r\n" + 
					"                        <label for=\"\" class=\"text\">Regno</label><br>\r\n" + 
					"                        <input type=\"text\" class=\"textbox\" value="+rs.getString("regno")+"><br>\r\n" + 
					"                        <label for=\"\" class=\"text\">Date of Birth</label><br>\r\n" + 
					"                        <input type=\"text\" class=\"textbox\" value="+rs.getString("dob")+"><br>\r\n" + 
					"                        <label for=\"\" class=\"text\">Branch</label><br>\r\n" + 
					"                        <input type=\"text\" class=\"textbox\" value="+rs.getString("branch")+"><br>\r\n" + 
					"                        <label for=\"\" class=\"text\">Username</label><br>\r\n" + 
					"                        <input type=\"text\" class=\"textbox\" value="+rs.getString("username")+"><br>\r\n" + 
					"                    </form>\r\n" + 
					"            </div>\r\n" + 
					"            </div>\r\n" + 
					"        \r\n" + 
					"        </div>\r\n" + 
					"\r\n" + 
					"    </div>\r\n" + 
					"</body>\r\n" + 
					"</html>");
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
	}

}

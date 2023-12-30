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
 * Servlet implementation class dash_servlet
 */
@WebServlet("/dash_servlet")
public class dash_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dash_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String name1=request.getParameter("name");
		String email1=request.getParameter("email");
		String phone1=request.getParameter("phone");
		String dept1=request.getParameter("dept");
		String uname=request.getParameter("username");
		String pass=request.getParameter("password");
		
		HttpSession session=request.getSession(false);
		String n=session.getAttribute("staffid").toString();
		PrintWriter p=response.getWriter();
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/proj1","root","root");
			String sql=" select * from staff_account where loginid='"+n+"' ";
			PreparedStatement stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				p.print("<!DOCTYPE html>\r\n" + 
						"<html lang=\"en\">\r\n" + 
						"<head>\r\n" + 
						"    <meta charset=\"UTF-8\">\r\n" + 
						"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + 
						"    <title>Staff Dashboard</title>\r\n" + 
						"    <link rel=\"stylesheet\" href=\"Staff_dash.css\">\r\n" + 
						"    <link rel=\"stylesheet\" href=\"fontawesome-free-6.4.2-web/fontawesome-free-6.4.2-web/css/all.css\">\r\n" + 
						"    \r\n" + 
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
						"                    <li>\r\n" + 
						"                        <a href=\"#\">\r\n" + 
						"                          Profile\r\n" + 
						"                        </a>\r\n" + 
						"                        <!-- <ul class=\"dropdown-menu\" aria-labelledby=\"navbarDropdownMenuLink\">\r\n" + 
						"                          <li><a class=\"dropdown-item\" href=\"#\">Manage Account</a></li>\r\n" + 
						"                          <li><a class=\"dropdown-item\" href=\"home.html\">Sign Out</a></li>\r\n" + 
						"                        </ul> -->\r\n" + 
						"                    </li>\r\n" + 
						"                \r\n" + 
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
						"                        <button class=\"btn\"><a href=\"Student_details\">Student details</a></button>\r\n" + 
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
						"                    <label for=\"\" class=\"heading\">Staff Details</label>\r\n" + 
						"                    <form action=\"dash_servlet\" method=\"get\">\r\n" + 
						"                        <label for=\"\" class=\"text\" >Full Name</label><br>\r\n" + 
						"                        <input type=\"text\" class=\"textbox\" value='"+rs.getString("name")+"'><br>\r\n" + 
						"                        <label for=\"\" class=\"text\">E-mail</label><br>\r\n" + 
						"                        <input type=\"text\" class=\"textbox\" value='"+rs.getString("email")+"'><br>\r\n" + 
						"                        <label for=\"\" class=\"text\">Phone</label><br>\r\n" + 
						"                        <input type=\"text\" class=\"textbox\" value='"+rs.getString("phone")+"'><br>\r\n" + 
						"                        <label for=\"\" class=\"text\">Department</label><br>\r\n" + 
						"                        <input type=\"text\" class=\"textbox\" value='"+rs.getString("dept")+"'><br>\r\n" + 
						"                        <label for=\"\" class=\"text\">Username</label><br>\r\n" + 
						"                        <input type=\"text\" class=\"textbox\" value='"+rs.getString("username")+"'><br>\r\n" + 
						"                    </form>\r\n" + 
						"            </div>\r\n" + 
						"            </div>\r\n" + 
						"        \r\n" + 
						"        </div>\r\n" + 
						"\r\n" + 
						"    </div>\r\n" + 
						"\r\n" + 
						"    \r\n" + 
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

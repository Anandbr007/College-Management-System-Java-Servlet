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
 * Servlet implementation class Studentmarklist_servlet
 */
@WebServlet("/Studentmarklist_servlet")
public class Studentmarklist_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Studentmarklist_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter p=response.getWriter(); 
		String id=request.getParameter("stid");
		
		p.print("<!DOCTYPE html>\r\n" + 
				"<html lang=\"en\">\r\n" + 
				"<head>\r\n" + 
				"    <meta charset=\"UTF-8\">\r\n" + 
				"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + 
				"    <title>Student Marklist</title>\r\n" + 
				"    <link rel=\"stylesheet\" href=\"Student_delete.css\">\r\n" + 
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
				"                    <div class=\"dropdown\">\r\n" + 
				"                        <button class=\"dropbtn\">Profile</button>\r\n" + 
				"                        <div class=\"dropdown-content\">\r\n" + 
				"                          <a href=\"#\">SignOut</a>\r\n" + 
				"                          \r\n" + 
				"                        </div>\r\n" + 
				"                    </div>\r\n" + 
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
				"                        <button class=\"btn\"><a href=\"Staff_dash.html\">Dashboard</a></button>\r\n" + 
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
				"                        <button class=\"btn\"><a href=\"Student_delete.html\">Add Marklist</a></button>\r\n" + 
				"                    </div>\r\n" + 
				"                </form>\r\n" + 
				"            </div>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"            <div class=\"workspace\">\r\n" + 
				"               <form action=\"marklist_servlet\" method=\"post\">\r\n" + 
				"\r\n" + 
				"                <label for=\"\" class=\"text\">Add Student Marklist</label><br>\r\n" + 
				"				\r\n" + 
				"                <input type=\"text\" placeholder=\"Enter maths mark\" class=\"input1\" name=\"maths\">\r\n" + 
				"				<input type=\"text\" placeholder=\"Enter physics mark\" class=\"input1\" name=\"phy\">\r\n" + 
				"				<input type=\"text\" placeholder=\"Enter chemistry mark\" class=\"input1\" name=\"che\">\r\n" + 
				"				<input type=\"text\" placeholder=\"Enter cs mark\" class=\"input1\" name=\"cs\">\r\n" + 
				"               <input type=\"hidden\"  class=\"input1\" name=\"id\" value='"+id+"'>\r\n" +
				"				<input class=\"submit\" type=\"submit\" value=\"submit\">\r\n" + 
				"               \r\n" + 
				"\r\n" + 
				"\r\n" + 
				"               </form>\r\n" + 
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
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}



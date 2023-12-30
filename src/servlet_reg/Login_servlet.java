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
 * Servlet implementation class Login_servlet
 */
@WebServlet("/Login_servlet")
public class Login_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("uname");
		String pass=request.getParameter("password");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/proj1","root","root");
			String sql=" select * from login where username='"+name+"' and password='"+pass+"' ";
			PreparedStatement stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery(sql);
		
			while(rs.next()) {
				int id=rs.getInt("id");
				String role=rs.getString("role");
				
				switch(role) {
				case "teacher": 
					
					HttpSession session=request.getSession();
					session.setAttribute("staffid",id);
					response.sendRedirect("dash_servlet");
						break;
				case "student":
					HttpSession session1=request.getSession();
					session1.setAttribute("studentid",id);
					response.sendRedirect("Studentdash_servlet");
						break;
				}
//				HttpSession session=request.getSession();
//				session.setAttribute("sid",id);
//				response.sendRedirect("dash_servlet");
			}
			

		} catch (Exception e) {
			System.out.println(e);
		}
	}

		
	}



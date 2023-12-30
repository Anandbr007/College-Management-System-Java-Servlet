package servlet_reg;

import java.io.IOException;
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
 * Servlet implementation class RegForm
 */
@WebServlet("/RegForm")
public class RegForm extends HttpServlet {
	public static PreparedStatement stmt;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegForm() {
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
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String dept=request.getParameter("dept");
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		
		String role="teacher";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/proj1","root","root");
			String sql="insert into login(username,password,role)values('"+uname+"','"+pass+"','"+role+"')";
			stmt=con.prepareStatement(sql);
			 int i=stmt.executeUpdate();
			 if(i==1)
			 {
				
					String sql2="select max(id) from login"; 
					ResultSet rs=stmt.executeQuery(sql2);
					while(rs.next()) {
					 String sql1="insert into staff_account(id,name,email,phone,dept,username,password,loginid)values('"+id+"','"+name+"','"+email+"','"+phone+"','"+dept+"','"+uname+"','"+pass+"','"+rs.getInt("max(id)")+"')";
					 stmt=con.prepareStatement(sql1);
					 int j=stmt.executeUpdate();
					 if(j==1) 
						 response.sendRedirect("reg3.html");
					}
			 }
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}

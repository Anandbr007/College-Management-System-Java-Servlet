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
 * Servlet implementation class Student_add
 */
@WebServlet("/Student_add")
public class Student_add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Student_add() {
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
	
		
		String name=request.getParameter("name");
		String regno=request.getParameter("regno");
		String dob=request.getParameter("dob");
		String branch=request.getParameter("branch");
		String uname=request.getParameter("username");
//		String id=request.getParameter("id");
		String role="student";
		
		try {
			HttpSession session=request.getSession(false);
			String n=session.getAttribute("staffid").toString();
			PrintWriter p=response.getWriter(); 
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/proj1","root","root");
			String sql="insert into login(username,password,role)values('"+uname+"','"+dob+"','"+role+"')";
			PreparedStatement stmt=con.prepareStatement(sql);
			 int i=stmt.executeUpdate();
			 if(i==1)
			 {
				 try {
					 String sql2="select max(id) from login"; 
					 ResultSet rs=stmt.executeQuery(sql2);
					 while(rs.next()) {
					 String sql1="insert into student_account(name,regno,dob,branch,username,staffid,loginid)values('"+name+"','"+regno+"','"+dob+"','"+branch+"','"+uname+"','"+n+"','"+rs.getInt("max(id)")+"')";
					 stmt=con.prepareStatement(sql1);
					 int j=stmt.executeUpdate();
					 if(i==1) 
					 {
						 response.sendRedirect("Student_add.html");
					 }
					 
					 }
					 } catch (Exception e) {
					System.out.println(e);
				}
				 
				 
			 }
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}

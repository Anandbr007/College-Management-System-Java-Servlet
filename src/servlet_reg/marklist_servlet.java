package servlet_reg;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class marklist_servlet
 */
@WebServlet("/marklist_servlet")
public class marklist_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public marklist_servlet() {
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
		
		String regno=request.getParameter("id");
		String maths=request.getParameter("maths");
		String phy=request.getParameter("phy");
		String che=request.getParameter("che");
		String cs=request.getParameter("cs");
		
		try {
			
			response.setContentType("text/html");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/proj1","root","root");
			String sql="insert into student_mark(maths,phy,che,cs,regno)values('"+maths+"','"+phy+"','"+che+"','"+cs+"','"+regno+"')";
			PreparedStatement stmt=con.prepareStatement(sql);
			 int i=stmt.executeUpdate();
			 if(i==1)
			 {
					response.sendRedirect("Student_details"); 
				 
			 }
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
	}

}

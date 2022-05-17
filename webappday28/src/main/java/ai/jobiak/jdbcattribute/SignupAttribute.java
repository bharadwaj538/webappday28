package ai.jobiak.jdbcattribute;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignupAttribute
 */
@WebServlet("/signupAttribute")
public class SignupAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupAttribute() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="jdbc:mysql://localhost:3306/mail";
		String userName="root";
		String password="admin";
		try {
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,userName,password);
		
		Statement stmt=con.createStatement();
		String sql="select * from empdetails";
		ResultSet rs=stmt.executeQuery(sql);
		
		PrintWriter out=response.getWriter();
		ServletContext context=getServletContext();
		request.setAttribute("EmpName", rs.getString(1));	
		request.setAttribute("EmpId", rs.getString(2));
		request.setAttribute("EmpSalary", rs.getString(3));
		}
		
		catch(Exception e) {
			e.printStackTrace();
		
		}
	}

}

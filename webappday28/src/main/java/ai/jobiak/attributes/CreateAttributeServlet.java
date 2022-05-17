package ai.jobiak.attributes;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateAttributeServlet
 */
@WebServlet("/createAttribute")
public class CreateAttributeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAttributeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();//.append("Served at: ").append(request.getContextPath());
		
		ServletContext context=getServletContext();
		context.setAttribute("DBName","Mysql");
		context.setAttribute("dbversion", "8.0.28");
		
		request.setAttribute("jdk","17.0.1"); //will be alive till the request in progress on server side
		request.setAttribute("os", "Windows10");//they are lost once the response is sent to client
		
		
		RequestDispatcher dispatcher=context.getRequestDispatcher("/readAttribute");
		dispatcher.forward(request, response);
		
	}

}

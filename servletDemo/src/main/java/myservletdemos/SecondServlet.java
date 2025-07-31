package myservletdemos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Servlet Can be configured in 2 ways
 * 1.web.xml =>deployment descriptor
 * 2.annotation
 */
@WebServlet("/SignUp")//communicate to the WEB CONTAINER SERVER

//http://localhost:8080/WIPROServletsDemo2025/SignUp

public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");//MIME TYPE
		
		PrintWriter out=response.getWriter();
		out.println("Hello Servlet!");
		out.println("<font color=red><h1>Hello Servlet!");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

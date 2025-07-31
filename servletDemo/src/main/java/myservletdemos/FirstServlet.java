package myservletdemos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
 * MAVEN PROJECT(org.apache.maven.archetypes(webapp)
 */
/*
 * 8080  is the default HTTP PORT NUMBER!
 * 
 */
//Default Location of deployment descriptor(web.xml) is src\main\webapp\WEB-INF\web.xml

//http://localhost:8080/WIPROServletsDemo2025/Wipro_UpdateEmployee
//http://localhost:8080/WIPROServletsDemo2025/Wipro_AddEmployee
//http://localhost:8080/WIPROServletsDemo2025/Wipro_UpdateEmployee34234=>404 NOT FOUND


public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//default HTTP method is doGet

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");//MIME TYPE
		
		PrintWriter outobj=response.getWriter();//Character Stream
		outobj.println("Hello Servlet!");
		outobj.println("<font color=red><h1>Hello Servlet!");//Servlet+HTML 
		outobj.println("<h1 style=color:yellow>Servlet With Inline css</h1>");//CSS=>Cascading Style Sheet

	}
	//doPost will work only with html files!
	

}

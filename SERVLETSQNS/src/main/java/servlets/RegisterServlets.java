package servlets;


import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")  // This matches the form's action="register"
public class RegisterServlets extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Read form data
        String fullName = request.getParameter("fullname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String birthday = request.getParameter("birthday");
        String gender = request.getParameter("gender");
        String profession = request.getParameter("profession");
        String married = request.getParameter("married");
        String note = request.getParameter("note");

        // Convert checkbox to meaningful value
        String marriedStatus = (married != null) ? "Yes" : "No";

        // Display received data
        out.println("<html><body>");
        out.println("<h2>User Registered Successfully!</h2>");
        out.println("<p><strong>Full Name:</strong> " + fullName + "</p>");
        out.println("<p><strong>Email:</strong> " + email + "</p>");
        out.println("<p><strong>Password:</strong> " + password + "</p>");
        out.println("<p><strong>Birthday:</strong> " + birthday + "</p>");
        out.println("<p><strong>Gender:</strong> " + gender + "</p>");
        out.println("<p><strong>Profession:</strong> " + profession + "</p>");
        out.println("<p><strong>Married:</strong> " + marriedStatus + "</p>");
        out.println("<p><strong>Note:</strong> " + note + "</p>");
        out.println("</body></html>");

        out.close();
    }
}

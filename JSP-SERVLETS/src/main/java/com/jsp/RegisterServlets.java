package com.jsp;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/register1")
public class RegisterServlets extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String fullName = request.getParameter("fullname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String birthday = request.getParameter("birthday");
        String gender = request.getParameter("gender");
        String profession = request.getParameter("profession");
        String married = request.getParameter("married") != null ? "Yes" : "No";
        String note = request.getParameter("note");

        request.setAttribute("fullname", fullName);
        request.setAttribute("email", email);
        request.setAttribute("password", password);
        request.setAttribute("birthday", birthday);
        request.setAttribute("gender", gender);
        request.setAttribute("profession", profession);
        request.setAttribute("married", married);
        request.setAttribute("note", note);

        RequestDispatcher dispatcher = request.getRequestDispatcher("display.jsp");
        dispatcher.forward(request, response);
    }
}

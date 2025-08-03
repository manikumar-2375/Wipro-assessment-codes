package servletdemo;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.sql.*;

@WebServlet("/addBook")
public class AddBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        double price = Double.parseDouble(request.getParameter("price"));

        try {
            Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO books(title, author, price) VALUES(?, ?, ?)");
            ps.setString(1, title);
            ps.setString(2, author);
            ps.setDouble(3, price);
            ps.executeUpdate();

            response.sendRedirect("listBooks");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

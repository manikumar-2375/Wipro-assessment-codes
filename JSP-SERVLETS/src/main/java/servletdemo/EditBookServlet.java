package servletdemo;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.sql.*;

@WebServlet("/editBook")
public class EditBookServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        try {
            Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM books WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Book b = new Book(rs.getInt("id"), rs.getString("title"),
                        rs.getString("author"), rs.getDouble("price"));
                request.setAttribute("book", b);
                RequestDispatcher rd = request.getRequestDispatcher("edit-book.jsp");
                rd.forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        double price = Double.parseDouble(request.getParameter("price"));

        try {
            Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement("UPDATE books SET title=?, author=?, price=? WHERE id=?");
            ps.setString(1, title);
            ps.setString(2, author);
            ps.setDouble(3, price);
            ps.setInt(4, id);
            ps.executeUpdate();

            response.sendRedirect("listBooks");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

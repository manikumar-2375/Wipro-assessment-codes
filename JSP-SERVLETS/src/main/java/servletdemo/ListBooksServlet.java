package servletdemo;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/listBooks")
public class ListBooksServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Book> books = new ArrayList<>();
        try {
            Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM books");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Book b = new Book(rs.getInt("id"), rs.getString("title"),
                        rs.getString("author"), rs.getDouble("price"));
                books.add(b);
            }

            request.setAttribute("books", books);
            RequestDispatcher rd = request.getRequestDispatcher("list-books.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

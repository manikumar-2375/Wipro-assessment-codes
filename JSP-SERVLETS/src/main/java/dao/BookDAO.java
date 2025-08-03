package dao;

import java.sql.*;
import java.util.*;

public class BookDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/bookdb_q6";
    private String jdbcUsername = "root";
    private String jdbcPassword = "yourpassword";

    private static final String INSERT_BOOK = "INSERT INTO books (title, author, price) VALUES (?, ?, ?)";
    private static final String SELECT_ALL_BOOKS = "SELECT * FROM books";
    private static final String DELETE_BOOK = "DELETE FROM books WHERE id = ?";
    private static final String SELECT_BOOK_BY_ID = "SELECT * FROM books WHERE id = ?";
    private static final String UPDATE_BOOK = "UPDATE books SET title = ?, author = ?, price = ? WHERE id = ?";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public void insertBook(Book book) { /* implement */ }

    public List<Book> listAllBooks() { /* implement */ }

    public boolean deleteBook(int id) { /* implement */ }

    public Book getBook(int id) { /* implement */ }

    public boolean updateBook(Book book) { /* implement */ }
}

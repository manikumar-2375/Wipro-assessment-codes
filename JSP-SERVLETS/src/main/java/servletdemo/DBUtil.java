package servletdemo;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    private static Connection con;

    public static Connection getConnection() throws Exception {
        if (con == null || con.isClosed()) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/book_q6", // ✅ changed database name
                "root", // your MySQL username
                "root"  // your MySQL password
            );
        }
        return con;
    }
}

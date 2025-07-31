package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcStudent {
    public static void main(String[] args) {
        // Database connection info
        String url = "jdbc:mysql://localhost:3306/school"; // ✅ DB name is 'school'
        String user = "root"; // Replace with your MySQL username if different
        String password = "M@ni7497"; // 🔁 Replace with your actual MySQL password

        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to database
            Connection con = DriverManager.getConnection(url, user, password);

            // Create a statement
            Statement stmt = con.createStatement();

            // Execute query
            ResultSet rs = stmt.executeQuery("SELECT * FROM Student");

            // Display results
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String course = rs.getString("course");
                int marks = rs.getInt("marks");

                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age +
                                   ", Course: " + course + ", Marks: " + marks);
            }

            // Close resources
            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

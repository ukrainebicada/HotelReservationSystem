package Database;

import java.sql.Connection;

public class TestConnection {
    public static void main(String[] args) {
        Connection conn = DBConnection.getConnection();
        if (conn != null) {
            System.out.println("✅ Successfully connected to XAMPP MySQL Database!");
        } else {
            System.out.println("❌ Failed to connect to MySQL. Ensure XAMPP MySQL is active.");
        }
    }
}
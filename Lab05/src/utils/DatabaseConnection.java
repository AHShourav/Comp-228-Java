package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection { //sql credentials user "COMP228_F24_soh_56" password "Javadatabase97"
    private static final String DB_URL = "jdbc:oracle:thin:@199.212.26.208:1521:SQLD";
    private static final String USER = "COMP228_F24_soh_56";
    private static final String PASSWORD = "Javadatabase97";

    //method to get the connection
    public static Connection getConnection() {
        try {
            //establish connection
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Database connection successful!");
            return conn;
        } catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
            return null;
        }
    }

    //method to test the connection
    public static void testConnection() {
        try (Connection conn = getConnection()) {
            if (conn != null) {
                System.out.println("Connection is valid.");
            } else {
                System.out.println("Failed to connect.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error while testing connection: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        testConnection();  //test connection
    }
}


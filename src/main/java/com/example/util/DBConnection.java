package com.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/access_management";
    private static final String USER = "postgres"; // your DB username
    private static final String PASSWORD = "root"; // your DB password

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("PostgreSQL JDBC Driver not found.");
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

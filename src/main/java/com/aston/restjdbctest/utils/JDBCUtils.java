package com.aston.restjdbctest.utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Utility class for managing connection to DB
 */

public class JDBCUtils {
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/bookstore";
    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "root";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
        } catch (SQLException | ClassNotFoundException ex) {
            ex.getMessage();
        }
        return connection;
    }

    public static Connection getConnection(String url, String username, String pass) {
        Connection connection = null;
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(url, username, pass);
        } catch (SQLException | ClassNotFoundException ex) {
            ex.getMessage();
        }
        return connection;
    }
}

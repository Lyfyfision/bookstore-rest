package com.aston.restjdbctest.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtils {
    private static final String jdbcURL = "jdbc:postgresql://localhost:3306/Bookstore";
    private static final String jdbcUsername = "root";
    private static final String jdbcPassword = "root";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException exception) {
            exception.getMessage();
        }
        return connection;
    }

    public static void disconnect() throws SQLException {
        if (getConnection().isClosed() || getConnection() == null) {
            getConnection().close();
        }
    }
}

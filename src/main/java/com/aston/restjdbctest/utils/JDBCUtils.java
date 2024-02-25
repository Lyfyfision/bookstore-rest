package com.aston.restjdbctest.utils;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JDBCUtils {
    private static final String jdbcURL = "jdbc:postgresql://localhost:3306/bookstore";
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

    /**
     * Method help to convert SQL request data to your custom DTO Java class object.
     * Requirements: fields of your Java class should have Type: String and have the same name as in sql table
     *
     * @param resultSet     - sql-request result
     * @param clazz - Your DTO Class for mapping
     * @return <T> List <T> - List of converted DTO java class objects
     */
    public static <T> List<T> convertSQLResultSetToObject(ResultSet resultSet, Class<T> clazz)
            throws SQLException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        List<Field> fields = Arrays.asList(clazz.getDeclaredFields());
        for(Field field: fields) {
            field.setAccessible(true);
        }

        List<T> list = new ArrayList<>();
        while(resultSet.next()) {

            T dto = clazz.getConstructor().newInstance();

            for(Field field: fields) {
                String name = field.getName();
                try{
                    String value = resultSet.getString(name);
                    field.set(dto, field.getType().getConstructor(String.class).newInstance(value));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            list.add(dto);
        }
        return list;
    }
}

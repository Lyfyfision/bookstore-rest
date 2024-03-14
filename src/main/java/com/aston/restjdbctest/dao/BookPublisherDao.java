package com.aston.restjdbctest.dao;

import com.aston.restjdbctest.repositories.BookPublisherRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.aston.restjdbctest.utils.BookSqlQuery.INSERT_INTO_JUNCTION;

public class BookPublisherDao implements BookPublisherRepo {
    private Connection connection;
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    public void insertBookPublisher(int bookId, int publisherId) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_JUNCTION)) {
            preparedStatement.setInt(1, bookId);
            preparedStatement.setInt(2, publisherId);
            preparedStatement.executeUpdate();
        } catch (SQLException ex ) {
            ex.printStackTrace();
        }
    }
}

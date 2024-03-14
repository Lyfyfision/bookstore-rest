package com.aston.restjdbctest.dao;

import com.aston.restjdbctest.dto.PublisherDto;
import com.aston.restjdbctest.entities.Publisher;
import com.aston.restjdbctest.repositories.PublisherRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static com.aston.restjdbctest.utils.PublisherSqlQuery.*;

public class PublisherDAO implements PublisherRepo {

    private Connection connection;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insertPublisher(PublisherDto publisher) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_PUBLISHER)) {
            preparedStatement.setString(1, publisher.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deletePublisher(int publisherId) {

    }

    @Override
    public void updatePublisher(Publisher publisher) {

    }

    @Override
    public PublisherDto getPublisher(int publisherId) {
        return null;
    }

    @Override
    public List<Publisher> getAllPublishers() {
        return null;
    }

    @Override
    public List<Publisher> getPublishersByBookId(int publisherId) {
        return null;
    }
}

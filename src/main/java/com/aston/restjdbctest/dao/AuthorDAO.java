package com.aston.restjdbctest.dao;

import com.aston.restjdbctest.dto.AuthorDto;
import com.aston.restjdbctest.entities.Author;
import com.aston.restjdbctest.repositories.AuthorRepo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.aston.restjdbctest.utils.AuthorSqlQuery.*;

public class AuthorDAO implements AuthorRepo {

    private Connection connection;
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insertAuthor(AuthorDto author) {
        try(PreparedStatement ps = connection.prepareStatement(INSERT_INTO_AUTHOR)) {
            ps.setString(1, author.getName());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteAuthorById(int authorId) {
        try(PreparedStatement ps = connection.prepareStatement(DELETE_FROM_AUTHOR)) {
            ps.setInt(1, authorId);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void updateAuthor(Author author) {
        try(PreparedStatement ps = connection.prepareStatement(UPDATE_AUTHOR)) {
            ps.setString(1, author.getName());
            ps.setInt(2, author.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Author getAuthorById(int authorId) {
        Author author = null;
        try(PreparedStatement ps = connection.prepareStatement(GET_AUTHOR)) {
            ps.setInt(1, authorId);
            try(ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    String name = resultSet.getString("name");
                    author = new Author(authorId, name);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return author;
    }

    @Override
    public List<Author> getAllAuthors() {
        List<Author> authors = new ArrayList<>();
        try(Statement statement = connection.createStatement()) {
            try(ResultSet resultSet = statement.executeQuery(SELECT_FROM_AUTHOR)) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("author_id");
                    String name = resultSet.getString("name");
                    Author author = new Author(id, name);
                    authors.add(author);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return authors;
    }
}

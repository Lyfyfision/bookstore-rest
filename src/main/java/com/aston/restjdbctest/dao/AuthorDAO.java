package com.aston.restjdbctest.dao;

import com.aston.restjdbctest.entities.Author;
import com.aston.restjdbctest.repositories.AuthorRepo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.aston.restjdbctest.utils.AuthorSqlQuery.*;
import static com.aston.restjdbctest.utils.JDBCUtils.*;

public class AuthorDAO implements AuthorRepo {
    @Override
    public void insertAuthor(Author author) {
        try(Connection connection = getConnection();
        PreparedStatement ps = connection.prepareStatement(INSERT_INTO_AUTHOR)) {
            ps.setString(1, author.getName());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteAuthor(Author author) {
        try(Connection connection = getConnection();
        PreparedStatement ps = connection.prepareStatement(DELETE_FROM_AUTHOR)) {
            ps.setInt(1, author.getId());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void updateAuthor(Author author) {
        try(Connection connection = getConnection();
        PreparedStatement ps = connection.prepareStatement(UPDATE_AUTHOR)) {
            ps.setString(1, author.getName());
            ps.setInt(2, author.getId());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Author getAuthorById(int authorId) {
        Author author = null;
        try(Connection connection = getConnection();
        PreparedStatement ps = connection.prepareStatement(GET_AUTHOR)) {
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
        try(Connection connection = getConnection();
        Statement statement = connection.createStatement()) {
            try(ResultSet resultSet = statement.executeQuery(SELECT_FROM_AUTHOR);
                ResultSet keys = statement.getGeneratedKeys()) {
                while (resultSet.next()) {
                    int id = keys.getInt(1);
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

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
            ps.setString(1, author.getFirstName());
            ps.setString(2, author.getLastName());
            ps.setString(3, author.getBook());
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
            ps.setString(1, author.getFirstName());
            ps.setString(2, author.getLastName());
            ps.setString(3, author.getBook());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Author getAuthorById(int authorId) {
        Author author = null;
        try(Connection connection = getConnection();
        PreparedStatement ps = connection.prepareStatement(GET_AUTHOR)) {
            try(ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    String firstName = resultSet.getString("firstName");
                    String lastName = resultSet.getString("lastName");
                    String book = resultSet.getString("book");
                    author = new Author(firstName, lastName, book);
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
            try(ResultSet resultSet = statement.executeQuery(SELECT_FROM_AUTHOR)) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("author_id");
                    String firstName = resultSet.getString("firstName");
                    String lastName = resultSet.getString("lastName");
                    String book = resultSet.getString("book");
                    Author author = new Author(id, firstName, lastName, book);
                    authors.add(author);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return authors;
    }
}

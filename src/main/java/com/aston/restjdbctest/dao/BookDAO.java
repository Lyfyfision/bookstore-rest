package com.aston.restjdbctest.dao;

import com.aston.restjdbctest.entities.Book;
import com.aston.restjdbctest.repositories.BookRepo;
import com.aston.restjdbctest.utils.BookSqlQuerry;
import com.aston.restjdbctest.utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO implements BookRepo {

    @Override
    public void insertBook(Book book) {
        try(Connection connection = JDBCUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(BookSqlQuerry.INSERT_INTO_BOOK)) {
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setFloat(3, book.getPrice());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteBookById(Book book) {
        try(Connection connection = JDBCUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(BookSqlQuerry.DELETE_FROM_BOOK)) {
            preparedStatement.setInt(1, book.getId());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void updateBookById(Book book) {
        try(Connection connection = JDBCUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(BookSqlQuerry.UPDATE_BOOK)) {
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setFloat(3, book.getPrice());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Book getBookById(int bookId) {
        Book book = null;
        try(Connection connection = JDBCUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(BookSqlQuerry.GET_BOOK)) {
            preparedStatement.setInt(1, bookId);
            try(ResultSet result = preparedStatement.executeQuery()) {
                if(result.next()) {
                    String title = result.getString("title");
                    String author = result.getString("author");
                    float price = result.getFloat("price");
                    book = new Book(bookId, title, author, price);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return book;
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> bookList = new ArrayList<>();
        try(Connection connection = JDBCUtils.getConnection();
            Statement statement = connection.createStatement()) {
            try(ResultSet result = statement.executeQuery(BookSqlQuerry.SELECT_FROM_BOOK)) {
                while(result.next()) {
                    int id = result.getInt("book_id");
                    String title = result.getString("title");
                    String author = result.getString("author");
                    float price = result.getFloat("price");
                    Book book = new Book(id, title, author, price);
                    bookList.add(book);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return bookList;
    }
}

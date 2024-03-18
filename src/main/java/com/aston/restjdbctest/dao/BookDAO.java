package com.aston.restjdbctest.dao;

import com.aston.restjdbctest.dto.BookDto;
import com.aston.restjdbctest.entities.Book;
import com.aston.restjdbctest.repositories.BookRepo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.aston.restjdbctest.utils.BookSqlQuery.*;

public class BookDAO implements BookRepo {

    private Connection connection;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insertBook(BookDto book) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_BOOK)) {
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setFloat(2, book.getPrice());
            preparedStatement.setInt(3, book.getAuthorId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteBookById(int bookId) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FROM_BOOK)) {
            preparedStatement.setInt(1, bookId);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void updateBookById(int bookId, BookDto book) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BOOK)) {
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setFloat(2, book.getPrice());
            preparedStatement.setInt(3, book.getAuthorId());
            preparedStatement.setInt(4, bookId);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public BookDto getBookById(int bookId) {
        BookDto book = null;
        try(PreparedStatement preparedStatement = connection.prepareStatement(GET_BOOK)) {
            preparedStatement.setInt(1, bookId);
            try(ResultSet result = preparedStatement.executeQuery()) {
                if(result.next()) {
                    String title = result.getString("title");
                    float price = result.getFloat("price");
                    int authorId = result.getInt("author_id");
                    book = new BookDto(bookId, title, price, authorId);
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
        try(Statement statement = connection.createStatement()) {
            try(ResultSet result = statement.executeQuery(SELECT_FROM_BOOK)) {
                while(result.next()) {
                    int id = result.getInt("book_id");
                    String title = result.getString("title");
                    float price = result.getFloat("price");
                    int authorId = result.getInt("author_id");
                    Book book = new Book(id, title, price, authorId);
                    bookList.add(book);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return bookList;
    }

    @Override
    public List<Book> getBooksByAuthorId(int authorId) {
        List<Book> authorBooks = new ArrayList<>();
        try(PreparedStatement statement = connection.prepareStatement(GET_AUTHOR_BOOKS)) {
            statement.setInt(1, authorId);
            try(ResultSet result = statement.executeQuery()) {
                while(result.next()) {
                    int id = result.getInt("book_id");
                    String title = result.getString("title");
                    float price = result.getFloat("price");
                    Book book = new Book(id, title, price, authorId);
                    authorBooks.add(book);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return authorBooks;
    }
}

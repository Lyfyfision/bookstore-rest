package com.aston.restjdbctest.dao;

import com.aston.restjdbctest.dto.BookDto;
import com.aston.restjdbctest.entities.Book;
import com.aston.restjdbctest.repositories.BookRepo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.aston.restjdbctest.utils.BookSqlQuery.*;
import static com.aston.restjdbctest.utils.JDBCUtils.*;

public class BookDAO implements BookRepo {

    private BookPublisherDao bookPublisherDao;

    public void setBookPublisherDao(BookPublisherDao bookPublisherDao) {
        this.bookPublisherDao = bookPublisherDao;
    }

    @Override
    public void insertBook(BookDto book) {
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO_BOOK)) {
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setFloat(2, book.getPrice());
            preparedStatement.setInt(3, book.getAuthorId());
            preparedStatement.setInt(4, book.getPublisherId());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        //TODO - add mapping to junction table
//        for (int publisherId : book.getPublishers()) {
//            bookPublisherDao.insertBookPublisher(book.getId(), publisherId);
//        }
    }

    @Override
    public void deleteBookById(Book book) {
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FROM_BOOK)) {
            preparedStatement.setInt(1, book.getId());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void updateBookById(Book book) {
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BOOK)) {
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setFloat(2, book.getPrice());
            preparedStatement.setInt(3, book.getAuthorId());
            preparedStatement.setInt(4, book.getPublisherId());
            preparedStatement.setInt(5, book.getId());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Book getBookById(int bookId) {
        Book book = null;
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_BOOK)) {
            preparedStatement.setInt(1, bookId);
            try(ResultSet result = preparedStatement.executeQuery()) {
                if(result.next()) {
                    String title = result.getString("title");
                    float price = result.getFloat("price");
                    int authorId = result.getInt("author_id");
                    int publisherId = result.getInt("publisher_id");
                    book = new Book(bookId, title, price, authorId, publisherId);
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
        try(Connection connection = getConnection();
            Statement statement = connection.createStatement()) {
            try(ResultSet result = statement.executeQuery(SELECT_FROM_BOOK);
                ResultSet keys = statement.getGeneratedKeys()) {
                while(result.next()) {
                    int id = keys.getInt(1);
                    String title = result.getString("title");
                    float price = result.getFloat("price");
                    int authorId = result.getInt("author_id");
                    int publisherId = result.getInt("publisher_id");
                    Book book = new Book(id, title, price, authorId, publisherId);
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
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_AUTHOR_BOOKS)) {
            statement.setInt(1, authorId);
            try(ResultSet result = statement.executeQuery();
                ResultSet keys = statement.getGeneratedKeys()) {
                while(result.next()) {
                    int id = keys.getInt(1);
                    String title = result.getString("title");
                    float price = result.getFloat("price");
                    int publisherId = result.getInt("publisher_id");
                    Book book = new Book(id, title, price, authorId, publisherId);
                    authorBooks.add(book);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return authorBooks;
    }
}

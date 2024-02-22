package com.aston.restjdbctest.repositories;

import com.aston.restjdbctest.entities.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookRepo {
    void insertBook(Book book) throws SQLException;
    void deleteBookById(Book book);
    void updateBookById(Book book);
    Book getBookById(int bookId);
    List<Book> getAllBooks();
}
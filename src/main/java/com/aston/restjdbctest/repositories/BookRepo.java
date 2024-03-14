package com.aston.restjdbctest.repositories;

import com.aston.restjdbctest.dto.BookDto;
import com.aston.restjdbctest.entities.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookRepo {
    void insertBook(BookDto book) throws SQLException;
    void deleteBookById(int bookId);
    void updateBookById(int bookId, BookDto book);
    Book getBookById(int bookId);
    List<Book> getAllBooks();
    List<Book> getBooksByAuthorId(int authorId);

}

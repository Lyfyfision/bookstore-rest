package com.aston.restjdbctest.utils;

public class BookSqlQuerry {
    public static final String INSERT_INTO_BOOK = "INSERT INTO book (title, author, price) VALUES (?, ?, ?)";
    public static final String DELETE_FROM_BOOK = "DELETE FROM book where book_id = ?";
    public static final String SELECT_FROM_BOOK = "SELECT * FROM book";
    public static final String UPDATE_BOOK = "UPDATE book SET title = ?, author = ?, price = ?";
    public static final String GET_BOOK = "SELECT * FROM book WHERE book_id = ?";
}

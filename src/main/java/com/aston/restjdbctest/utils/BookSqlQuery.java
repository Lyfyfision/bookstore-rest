package com.aston.restjdbctest.utils;

public class BookSqlQuery {
    public static final String INSERT_INTO_BOOK = "INSERT INTO book (title, price, author_id, publisher_id) VALUES (?, ?, ?, ?)";
    public static final String DELETE_FROM_BOOK = "DELETE FROM book WHERE book_id = ?";
    public static final String SELECT_FROM_BOOK = "SELECT * FROM book";
    public static final String UPDATE_BOOK = "UPDATE book SET title = ?, price = ?, author_id = ?, publisher_id = ? " +
            "WHERE book_id = ?";
    public static final String GET_BOOK = "SELECT * FROM book WHERE book_id = ?";
    public static final String GET_AUTHOR_BOOKS = "SELECT b.* FROM book b JOIN author a ON b.author_id = a.id WHERE a.id = ?";
    private BookSqlQuery() {
        throw new IllegalStateException("Plz do not initialize utility class");
    }
}

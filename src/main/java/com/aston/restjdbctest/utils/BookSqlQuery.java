package com.aston.restjdbctest.utils;

public class BookSqlQuery {
    public static final String INSERT_INTO_BOOK = "INSERT INTO book (title, price, author_id) VALUES (?, ?, ?)";
    public static final String DELETE_FROM_BOOK = "DELETE FROM book WHERE book_id = ?";
    public static final String SELECT_FROM_BOOK = "SELECT * FROM book";
    public static final String UPDATE_BOOK = "UPDATE book SET title = ?, price = ?, author_id = ? " +
            "WHERE book_id = ?";
    public static final String GET_BOOK = "SELECT * FROM book WHERE book_id = ?";

    public static final String GET_AUTHOR_BOOKS = "SELECT b.book_id, b.title, b.price " +
            "FROM book b " +
            "JOIN author a ON b.author_id = a.author_id " +
            "WHERE a.author_id = ?";

    public static final String GET_PUBLISHER_BOOKS = "SELECT b.book_id, b.title, b.price, b.author_id, bp.publisher_id AS publisher_id " +
            "FROM book_publisher bp " +
            "JOIN book b ON bp.book_id = b.book_id " +
            "JOIN publisher p ON bp.publisher_id = p.publisher_id " +
            "WHERE p.publisher_id = ?";
    public static final String INSERT_INTO_JUNCTION = "INSERT INTO book_publisher (book_id, publisher_id) VALUES (?, ?)";
    private BookSqlQuery() {
        throw new IllegalStateException("Plz do not initialize utility class");
    }
}

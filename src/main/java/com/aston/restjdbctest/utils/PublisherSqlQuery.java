package com.aston.restjdbctest.utils;

public class PublisherSqlQuery {
    public static final String INSERT_INTO_PUBLISHER = "INSERT INTO publisher (name) VALUES (?)";
    public static final String DELETE_FROM_PUBLISHER = "DELETE FROM publisher WHERE publisher_id = ?";
    public static final String SELECT_FROM_PUBLISHER = "SELECT * FROM publisher";
    public static final String UPDATE_PUBLISHER = "UPDATE publisher SET name = ? WHERE publisher_id = ?";
    public static final String GET_PUBLISHER = "SELECT * FROM publisher WHERE publisher_id = ?";
    public static final String GET_BOOK_PUBLISHERS = "SELECT b.book_id, b.title, b.price, b.author_id, b.publisher_id " +
            "FROM book_publisher bp " +
            "JOIN book b ON bp.book_id = b.book_id " +
            "JOIN publisher p ON bp.publisher_id = p.publisher_id " +
            "WHERE bp.book_id = ?";

    private PublisherSqlQuery() {
        throw new IllegalStateException("Plz do not initialize utility class");
    }
}

package com.aston.restjdbctest.utils;

public class AuthorSqlQuery {
    public static final String INSERT_INTO_AUTHOR = "INSERT INTO author (name) VALUES (?)";
    public static final String DELETE_FROM_AUTHOR = "DELETE FROM author WHERE author_id = ?";
    public static final String SELECT_FROM_AUTHOR = "SELECT * FROM author";
    public static final String UPDATE_AUTHOR = "UPDATE author SET name = ? WHERE author_id = ?";
    public static final String GET_AUTHOR = "SELECT * FROM author WHERE author_id = ?";
    private AuthorSqlQuery() {
        throw new IllegalStateException("Plz do not initialize utility class");
    }
}

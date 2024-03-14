package com.aston.restjdbctest.repositories;

/**
 * DAO-contract for working with Junction table only (Books and Publishers)
 */
public interface BookPublisherRepo {
    void insertBookPublisher(int bookId, int publisherId);
}

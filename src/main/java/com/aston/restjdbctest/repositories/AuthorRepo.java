package com.aston.restjdbctest.repositories;

import com.aston.restjdbctest.entities.Author;

import java.util.List;

public interface AuthorRepo {
    void insertAuthor(Author author);
    void deleteAuthor(Author author);
    void updateAuthor(Author author);
    Author getAuthorById(int authorId);
    List<Author> getAllAuthors();
}

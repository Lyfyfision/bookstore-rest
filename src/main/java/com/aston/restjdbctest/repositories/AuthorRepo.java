package com.aston.restjdbctest.repositories;

import com.aston.restjdbctest.dto.AuthorDto;
import com.aston.restjdbctest.entities.Author;

import java.util.List;

public interface AuthorRepo {
    void insertAuthor(AuthorDto author);
    void deleteAuthorById(int authorId);
    void updateAuthor(Author author);
    Author getAuthorById(int authorId);
    List<Author> getAllAuthors();

}

package com.aston.restjdbctest.repositories;

import com.aston.restjdbctest.dao.AuthorDAO;
import com.aston.restjdbctest.entities.Author;
import com.aston.restjdbctest.utils.AuthorMapper;
import com.aston.restjdbctest.utils.JDBCUtils;
import org.junit.jupiter.api.*;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AuthorDAOTest {

    private AuthorDAO authorDao;
    Author author;

    @Container
    static final PostgreSQLContainer<?> POSTGRES_CONTAINER = new PostgreSQLContainer<>("postgres:15-alpine")
            .withDatabaseName("bookstore")
            .withUsername("root")
            .withPassword("root")
            .withInitScript("db/schema.sql");

    @BeforeAll
    static void beforeAll() {
        POSTGRES_CONTAINER.start();
    }

    @AfterAll
    static void afterAll() {
        POSTGRES_CONTAINER.stop();
    }

    @BeforeEach
    void setUp() {
        author = new Author("John Doe");
        authorDao = new AuthorDAO();
        authorDao.setConnection(JDBCUtils.getConnection(POSTGRES_CONTAINER.getJdbcUrl(), POSTGRES_CONTAINER.getUsername(),
                POSTGRES_CONTAINER.getPassword()));
    }

    @Test
    @DisplayName("Author can be inserted in DB")
    void testInsertAuthor_whenCorrectNameGiven_shouldReturnInsertedAuthor() {
        //Act
        authorDao.insertAuthor(AuthorMapper.instance.toDto(author));
        //Assert
        assertEquals(author.getName(), authorDao.getAuthorById(6).getName());
    }

    @Test
    @DisplayName("Author can be deleted from DB")
    void testDeleteAuthor_whenCorrectIdGiven_shouldReturnNull() {
        //Act
        authorDao.deleteAuthorById(5);
        //Assert
        assertNull(authorDao.getAuthorById(5));
    }

    @Test
    @DisplayName("Author can be updated")
    void testUpdateAuthor_whenExistingAuthorGiven_shouldReturnUpdatedAuthor() {
        //Arrange
        Author updatedAuthor = new Author(1, "Ray Bradbury");
        //Act
        authorDao.updateAuthor(updatedAuthor);
        //Assert
        assertEquals(updatedAuthor.getName(), authorDao.getAuthorById(1).getName());
    }

    @Test
    @DisplayName("All authors can be returned from DB")
    void testGetAllAuthors_shouldReturnListOfAllAuthors() {
        //Act
        List<Author> authors = authorDao.getAllAuthors();
        //Assert
        assertTrue(authors.size() > 1);

    }
}
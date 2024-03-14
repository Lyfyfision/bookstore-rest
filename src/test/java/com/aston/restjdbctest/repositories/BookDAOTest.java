package com.aston.restjdbctest.repositories;

import com.aston.restjdbctest.dao.BookDAO;
import com.aston.restjdbctest.dto.BookDto;
import com.aston.restjdbctest.entities.Book;
import com.aston.restjdbctest.utils.BookMapper;
import com.aston.restjdbctest.utils.JDBCUtils;
import org.junit.jupiter.api.*;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;


import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookDAOTest {
    private BookDAO bookDAO;
    Book book;
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
    void setUp() throws SQLException {
        book = new Book(4,"Book", 12, 1);
        bookDAO = new BookDAO();
        bookDAO.setConnection(JDBCUtils.getConnection(POSTGRES_CONTAINER.getJdbcUrl(), POSTGRES_CONTAINER.getUsername(),
                POSTGRES_CONTAINER.getPassword()));
    }

    @Test
    @DisplayName("Book can be inserted in DB")
    void testInsertBook_whenCorrectBookGiven_shouldReturnInsertedBook() {
        //Act
        bookDAO.insertBook(BookMapper.instance.toDto(book));
        //Assert
        assertNotNull(bookDAO.getBookById(4));
    }

    @Test
    @DisplayName("Book can be deleted from DB")
    void testDeleteBookById_whenCorrectIdGiven_shouldReturnNull() {
        //Act
        bookDAO.deleteBookById(3);
        //Assert
        assertNull(bookDAO.getBookById(3));
    }

    @Test
    @DisplayName("Book can be updated")
    void testUpdateBookById_whenExistingBookGiven_shouldReturnUpdatedBookFromDB() {
        //Arrange
        BookDto updatedBook = new BookDto(3, "NEW BOOK", 111, 2);
        //Act
        bookDAO.updateBookById(3, updatedBook);
        //Assert
        assertEquals(bookDAO.getBookById(3).getPrice(), updatedBook.getPrice());
        assertEquals(bookDAO.getBookById(3).getTitle(), updatedBook.getTitle());
    }

    @Test
    @DisplayName("All books can be returned from DB")
    void testGetAllBooks_shouldReturnListOfAllBooksInDB() {
        //Act
        List<Book> books = bookDAO.getAllBooks();
        //Assert
        assertNotNull(books);
        assertTrue(books.size() > 0);
    }

    @Test
    @DisplayName("All books of specified author can be returned from DB")
    void testGetBooksByAuthorId_whenCorrectAuthorIdGiven_shouldReturnAuthorsBooksListFromDB() {
        //Act
        List<Book> booksByAuthorId = bookDAO.getBooksByAuthorId(1);
        //Assert
        assertNotNull(booksByAuthorId);
        assertTrue(booksByAuthorId.size() > 0);
    }
}

package com.aston.restjdbctest.servlets.book;

import com.aston.restjdbctest.dao.BookDAO;
import com.aston.restjdbctest.entities.Book;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.Ignore;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BookServletsTest {
    @Spy
    private GetBookServlet getBookServlet;
    @Spy
    private GetAllBooksServlet getAllBooksServlet;
    @Spy
    private InsertBookServlet insertBookServlet;
    @Spy
    private DeleteBookServlet deleteBookServlet;
    @Spy
    private UpdateBookServlet updateBookServlet;
    @Mock
    private BookDAO bookDAO;
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    private StringWriter stringWriter;
    private PrintWriter writer;
    private Book bookOne;
    private Book bookTwo;

    @BeforeEach
    void setUp() throws IOException {
        bookOne = new Book("Some book", 111, 1);
        bookTwo = new Book("Some another book 2", 11, 2);
        stringWriter = new StringWriter();
        writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
    }

    @Test
    void testGetBook_whenValidBookIdGiven_shouldReturnBookInfo() {
        //Arrange
        getBookServlet = new GetBookServlet();
        getBookServlet.init();
        //Act

        //Assert
    }

    @Test
    @DisplayName("GetAllBooks servlet returns a books list")
    void testGetAllBooks_shouldReturnBooksList() throws ServletException, IOException {
        //Arrange
        getAllBooksServlet.init();
        when(bookDAO.getAllBooks()).thenReturn(Arrays.asList(bookOne, bookTwo));
        List<Book> books = bookDAO.getAllBooks();
        //Act
        getAllBooksServlet.doGet(request, response);
        //Assert
        assertEquals(2, books.size());
        verify(response).setContentType("text/html;charset=UTF-8");
        assertTrue(stringWriter.toString().contains("<h1>Books List</h1>"));
    }

    @Test
    void testInsertBook_shouldReturn200Code() {
        //Arrange
        insertBookServlet = new InsertBookServlet();
        insertBookServlet.init();


        //Act



        //Assert


    }

    @Test
    void testDeleteBook_shouldReturn200Code() {
        //Arrange
        deleteBookServlet = new DeleteBookServlet();
        deleteBookServlet.init();


        //Act



        //Assert


    }

    @Test
    void updateBook_shouldReturnUpdatedBook() {
        //Arrange
        updateBookServlet = new UpdateBookServlet();
        updateBookServlet.init();


        //Act



        //Assert


    }
}

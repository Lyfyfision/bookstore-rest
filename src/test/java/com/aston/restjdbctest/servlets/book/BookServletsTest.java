package com.aston.restjdbctest.servlets.book;

import com.aston.restjdbctest.dao.BookDAO;
import com.aston.restjdbctest.dto.BookDto;
import com.aston.restjdbctest.entities.Book;
import com.aston.restjdbctest.servlets.JunctionTableServlet;
import com.aston.restjdbctest.utils.BookMapper;
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

import static org.mockito.ArgumentMatchers.anyInt;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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
    private JunctionTableServlet junctionTableServlet;
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
    private BookDto bookThree;

    @BeforeEach
    void setUp() throws IOException {
        bookOne = new Book(1, "Some book", 111, 1);
        bookTwo = new Book(2, "Some another book 2", 11, 2);
        bookThree = new BookDto(3, "MyBook", 99, 1);
        stringWriter = new StringWriter();
        writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
    }

    @Test
    void testGetBook_whenValidBookIdGiven_shouldReturnBookInfo() throws ServletException, IOException {
        //Arrange
        getBookServlet = new GetBookServlet();
        getBookServlet.init();
        when(bookDAO.getBookById(3)).thenReturn(bookThree);
        when(request.getParameter("book_id")).thenReturn("3");
        //Act
        BookDto book = bookDAO.getBookById(3);
        getBookServlet.doGet(request, response);
        //Assert
        verify(response).setContentType("text/html;charset=UTF-8");
        verify(response).setStatus(HttpServletResponse.SC_OK);
        assertTrue(stringWriter.toString().contains("<h1>This is your Book</h1>"));
        assertEquals(bookThree.getTitle(), book.getTitle());
    }

    @Test
    @DisplayName("GetAllBooks servlet returns a books list")
    void testGetAllBooks_shouldReturnBooksList() throws ServletException, IOException {
        //Arrange
        getAllBooksServlet.init();
        when(bookDAO.getAllBooks()).thenReturn(Arrays.asList(bookOne, bookTwo));
        //Act
        List<Book> books = bookDAO.getAllBooks();
        getAllBooksServlet.doGet(request, response);
        //Assert
        assertEquals(2, books.size());
        verify(response).setContentType("text/html;charset=UTF-8");
        assertTrue(stringWriter.toString().contains("<h1>Books List</h1>"));
    }

    @Test
    void testInsertBook_shouldReturn201Code() throws IOException {
        //Arrange
        insertBookServlet = new InsertBookServlet();
        insertBookServlet.init();
        when(request.getParameter("title")).thenReturn("AAAAAAA");
        when(request.getParameter("price")).thenReturn("12");
        when(request.getParameter("author_id")).thenReturn("2");
        //Act
        insertBookServlet.doPost(request, response);
        //Assert
        verify(response).setContentType("text/html;charset=UTF-8");
        verify(response).setStatus(HttpServletResponse.SC_CREATED);
        assertTrue(stringWriter.toString().contains("Book has been successfully added :)"));
    }

    @Test
    void testDeleteBook_shouldReturn200Code() throws IOException {
        //Arrange
        deleteBookServlet = new DeleteBookServlet();
        deleteBookServlet.init();
        when(request.getParameter("book_id")).thenReturn("1");
        //Act
        deleteBookServlet.doDelete(request, response);
        //Assert
        verify(response).setContentType("text/html;charset=UTF-8");
        verify(response).setStatus(HttpServletResponse.SC_OK);
        assertTrue(stringWriter.toString().contains("Book has been successfully deleted"));
    }
    @Test
    void testAddToJunctionTable_whenValidPublisherAndBookIDsGiven_shouldReturn200Code() throws ServletException, IOException {
        //Arrange
        junctionTableServlet = new JunctionTableServlet();
        junctionTableServlet.init();
        when(request.getParameter("book_id")).thenReturn("3");
        when(request.getParameter("publisher_id")).thenReturn("3");
        //Act
        junctionTableServlet.doPost(request, response);
        //Assert
        verify(response).setContentType("text/html;charset=UTF-8");
        verify(response).setStatus(HttpServletResponse.SC_OK);
        assertTrue(stringWriter.toString().contains("Book and publisher connection has been successfully established :)"));
    }
}

package com.aston.restjdbctest.servlets.book;

import com.aston.restjdbctest.dao.BookDAO;
import com.aston.restjdbctest.dto.BookDto;
import com.aston.restjdbctest.entities.Book;
import com.aston.restjdbctest.utils.BookMapper;
import com.aston.restjdbctest.utils.JDBCUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "GetAllBooksServlet", value = "/getAllBooks")
public class GetAllBooksServlet extends HttpServlet {
    private transient BookDAO bookDAO;

    @Override
    public void init() {
        bookDAO = new BookDAO();
        bookDAO.setConnection(JDBCUtils.getConnection());
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        List<BookDto> books = getAllBooks();
        PrintWriter out = response.getWriter();

        out.println("<h1>Books List</h1>");
        out.print("<table border='1' width='100%'");
        out.print("<tr><th>Id</th><th>Title</th><th>Price</th><th>AuthorId</th></tr>");
        for(BookDto book : books) {
            out.print("<tr><td>" + book.getId() + "</td><td>" + book.getTitle() + "</td><td>" + book.getPrice() + "</td>" +
                    "<td>" + book.getAuthorId() + "</td></tr>");
        }
        out.print("</table>");
        out.close();

        response.setStatus(HttpServletResponse.SC_OK);
    }

    private List<BookDto> getAllBooks() {
        List<Book> books = bookDAO.getAllBooks();
        List<BookDto> returnedBooks = new ArrayList<>();
            for (Book book: books) {
                returnedBooks.add(BookMapper.instance.toDto(book));
            }
        return returnedBooks;
    }
}

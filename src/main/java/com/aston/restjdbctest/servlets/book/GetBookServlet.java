package com.aston.restjdbctest.servlets.book;

import com.aston.restjdbctest.dao.BookDAO;
import com.aston.restjdbctest.dto.BookDto;
import com.aston.restjdbctest.utils.JDBCUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "GetBookServlet", value = "/getBook")
public class GetBookServlet extends HttpServlet {
    private transient BookDAO bookDAO;

    @Override
    public void init() {
        bookDAO = new BookDAO();
        bookDAO.setConnection(JDBCUtils.getConnection());
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        BookDto book;
        book = getBook(request,response);
        assert book != null;
        response.getWriter().println("<h1>This is your Book</h1>");
        response.getWriter().print("<table border='1' width='100%'");
        response.getWriter().print("<tr><th>Id</th><th>Title</th><th>Price</th></tr>");
        response.getWriter().print("<tr><td>" + book.getId() + " "
                + "</td><td>" + book.getTitle() + " "
                + "</td><td>" + book.getPrice()
                + "</td></tr>");
    }

    private BookDto getBook(HttpServletRequest request, HttpServletResponse response) {
        int bookId = Integer.parseInt(request.getParameter("book_id"));
        BookDto book = bookDAO.getBookById(bookId);
        book.setId(bookId);
        response.setStatus(HttpServletResponse.SC_OK);
        return book;
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}

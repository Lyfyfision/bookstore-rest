package com.aston.restjdbctest.servlets.book;

import com.aston.restjdbctest.dao.BookDAO;
import com.aston.restjdbctest.utils.JDBCUtils;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DeleteBookServlet", value = "/deleteBook")
public class DeleteBookServlet extends HttpServlet {

    private transient BookDAO bookDAO;

    @Override
    public void init() {
        bookDAO = new BookDAO();
        bookDAO.setConnection(JDBCUtils.getConnection());
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        int bookId = Integer.parseInt(request.getParameter("book_id"));
        bookDAO.deleteBookById(bookId);

        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("Book has been successfully deleted");
    }
}

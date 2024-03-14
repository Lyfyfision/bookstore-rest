package com.aston.restjdbctest.servlets.book;

import com.aston.restjdbctest.dao.BookDAO;
import com.aston.restjdbctest.entities.Book;
import com.aston.restjdbctest.utils.BookMapper;
import com.aston.restjdbctest.utils.JDBCUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UpdateBookServlet", value = "/updateBook")
public class UpdateBookServlet extends HttpServlet {
    private transient BookDAO bookDao;

    @Override
    public void init() {
        bookDao = new BookDAO();
        bookDao.setConnection(JDBCUtils.getConnection());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        processRequest(req, resp);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        try {
            update(request,response);
        } catch (IOException | SQLException | ServletException e){
            e.printStackTrace();
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response)
            throws IOException, SQLException, ServletException {
        int bookId = Integer.parseInt(request.getParameter("book_id"));
        String title = request.getParameter("title");
        float price = Float.parseFloat(request.getParameter("price"));
        int authorId = Integer.parseInt(request.getParameter("author_id"));
        Book book = new Book(bookId, title, price, authorId);
        bookDao.updateBookById(bookId, BookMapper.instance.toDto(book));

        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("Book has been successfully updated)");
    }
}

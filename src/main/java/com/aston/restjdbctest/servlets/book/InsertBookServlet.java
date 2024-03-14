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

@WebServlet(name = "InsertBookServlet", value = "/insertBook")
public class InsertBookServlet extends HttpServlet {
    private transient BookDAO bookDao;

    @Override
    public void init() {
        bookDao = new BookDAO();
        bookDao.setConnection(JDBCUtils.getConnection());
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            insert(request,response);
        } catch(IOException | SQLException | ServletException e){
            e.printStackTrace();
        }
    }

    private void insert(HttpServletRequest request, HttpServletResponse response)
            throws IOException, SQLException, ServletException {
        String title = request.getParameter("title");
        float price = Float.parseFloat(request.getParameter("price"));
        int authorId = Integer.parseInt(request.getParameter("author_id"));
        Book book = new Book(0, title, price, authorId);
        bookDao.insertBook(BookMapper.instance.toDto(book));

        response.setStatus(HttpServletResponse.SC_CREATED);
        response.getWriter().println("Book has been successfully added :)");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }
}

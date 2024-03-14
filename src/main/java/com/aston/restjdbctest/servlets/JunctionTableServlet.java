package com.aston.restjdbctest.servlets;

import com.aston.restjdbctest.dao.BookDAO;
import com.aston.restjdbctest.dao.BookPublisherDao;
import com.aston.restjdbctest.utils.JDBCUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "JunctionTableServlet", value = "/connectBookToPublisher")
public class JunctionTableServlet extends HttpServlet {

    private BookPublisherDao bookPublisherDao;

    @Override
    public void init() throws ServletException {
        bookPublisherDao = new BookPublisherDao();
        bookPublisherDao.setConnection(JDBCUtils.getConnection());
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
        int bookId = Integer.parseInt(request.getParameter("book_id"));
        int publisherId = Integer.parseInt(request.getParameter("publisher_id"));
        bookPublisherDao.insertBookPublisher(bookId, publisherId);

        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("Book and publisher connection has been successfully established :)");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}

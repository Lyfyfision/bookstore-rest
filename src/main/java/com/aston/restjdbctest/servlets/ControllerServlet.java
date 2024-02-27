package com.aston.restjdbctest.servlets;

import com.aston.restjdbctest.dao.BookDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ControllerServlet extends HttpServlet {
    private BookDAO bookDao;

    @Override
    public void init() throws ServletException {
        bookDao = new BookDAO();
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insertBook":
                    insertBook(request, response);
                    break;
                case "/deleteBook":
                    deleteBook(request, response);
                    break;
                case "/editBook":
                    showEditForm(request, response);
                    break;
                case "/updateBook":
                    updateBook(request, response);
                    break;
                default:
                    listBook(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void insertBook(HttpServletRequest req, HttpServletResponse res) throws SQLException {
        String title = req.getParameter("title");
//        String
    }

    private void deleteBook(HttpServletRequest req, HttpServletResponse res) throws SQLException {

    }

    private void updateBook(HttpServletRequest req, HttpServletResponse res) {

    }

    private void listBook(HttpServletRequest req, HttpServletResponse res) {

    }

    private void showNewForm(HttpServletRequest req, HttpServletResponse res) {

    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse res) {

    }
}

package com.aston.restjdbctest.servlets.book;

import com.aston.restjdbctest.dao.BookDAO;
import com.aston.restjdbctest.dto.BookDto;
import com.aston.restjdbctest.entities.Book;
import com.aston.restjdbctest.utils.BookMapper;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "InsertServlet", value = "/insertBook")
public class InsertServlet extends HttpServlet {
    private transient BookDAO bookDao;

    @Override
    public void init() {
        bookDao = new BookDAO();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        try{
            insert(request,response);
        }catch(IOException | SQLException | ServletException e){
            e.printStackTrace();
        }
    }

    private void insert(HttpServletRequest request, HttpServletResponse response)
            throws IOException, SQLException, ServletException {
        String title = request.getParameter("title");
        float price = Float.parseFloat(request.getParameter("price"));
        int authorId = Integer.parseInt(request.getParameter("author_id"));
        int publisherId = Integer.parseInt(request.getParameter("publisher_id"));
        Book book = new Book(title, price, authorId, publisherId);
        bookDao.insertBook(BookMapper.instance.toDto(book));

        response.setStatus(HttpServletResponse.SC_CREATED);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}

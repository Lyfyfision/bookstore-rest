<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Book Store</title>
</head>
<body>
<h1><%= "Welcome mate" %>
</h1>
<br/>
<span style="font-family: verdana,serif;">
    <h3>Get a book</h3>
    <form action="${pageContext.request.contextPath}/getBook" method="get">
        Plz input BookID -> <input type="text" name="book_id">
        <input type="submit" value="Submit">
    </form>
    <h3>List all books</h3>
    <form action="${pageContext.request.contextPath}/getAllBooks" method="get">
        To get all books in our store plz click here -> <input type="submit" value="Books List">
    </form>
    <h3>Insert book</h3>
    <form action="${pageContext.request.contextPath}/insertBook" method="post">
        To insert a new Book plz fill in this form (title, price, authorID) ->
        <input type="text" name="title">
        <input type="text" name="price">
        <input type="text" name="author_id">
        <input type="submit" value="Submit">
    </form>
    <h3>Delete book</h3>
    <form action="${pageContext.request.contextPath}/deleteBook" method="post">
        To delete a Book plz type an ID here -> <input type="text" name="book_id">
        <input type="submit" value="Submit">
    </form>
    <h3>Update book</h3>
    <form action="${pageContext.request.contextPath}/updateBook" method="post">
        To update a Book plz fill in this form (bookID, title, price, authorID) ->
        <input type="text" name="book_id">
        <input type="text" name="title">
        <input type="text" name="price">
        <input type="text" name="author_id">
        <input type="submit" value="Submit">
    </form>
    <h3>Connect book and publisher</h3>
    <form action="${pageContext.request.contextPath}/connectBookToPublisher" method="post">
        To add existed book to publisher plz provide book_id and publisher_id ->
        <input type="text" name="book_id">
        <input type="text" name="publisher_id">
        <input type="submit" value="Submit">
    </form>

<%--TODO - Place a link to author.jsp (and create it)--%>
    <h4>Another actions</h4>
    <form></form>
</span>
</body>
</html>
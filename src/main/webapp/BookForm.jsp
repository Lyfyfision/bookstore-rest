<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE>
<html lang="en">
<head>
    <title>Book Store App</title>
</head>
<body>
    <h1 >Books Management</h1>
    <h2>
        <a href="/new">Add New Book</a>
        &nbsp;&nbsp;&nbsp;
        <a href="/list">List All Books</a>

    </h2>
<div >
    <c:if test="${book != null}">
    <form action="update" method="post">
        </c:if>
        <c:if test="${book == null}">
        <form action="insert" method="post">
            </c:if>
            <table>
                <caption>
                    <h2>
                        <c:if test="${book != null}">
                            Edit Book
                        </c:if>
                        <c:if test="${book == null}">
                            Add New Book
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${book != null}">
                    <input type="hidden" name="id" value="<c:out value='${book.id}' />" />
                </c:if>
                <tr>
                    <th scope="row">Title: </th>
                    <td>
                        <input type="text" name="title" size="45"
                               value="<c:out value='${book.title}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th scope="row">Author: </th>
                    <td>
                        <input type="text" name="author" size="45"
                               value="<c:out value='${book.author}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th scope="row">Price: </th>
                    <td>
                        <input type="text" name="price" size="5"
                               value="<c:out value='${book.price}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Save" />
                    </td>
                </tr>
            </table>
        </form>
</div>
</body>
</html>

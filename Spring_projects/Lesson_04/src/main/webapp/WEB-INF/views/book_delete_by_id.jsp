<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Видалення книги по ID</title>
</head>
<body>
    <button onclick="window.location.href = '/main';">Перейти на головну сторінку</button>
    <h1>Введіть ID книги для видалення</h1>

     <h2><form id = "book-form" method="post" action="delete_by_id" th:object="${bookID}">
        <label for="bookID">ID книги яку треба видалити:</label>
        <input type="number" id="bookID" name= "bookID" required><br>

        <input type="submit" value="Видалити">
    </form></h2>

    </body>
</html>
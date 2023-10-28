<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Пошук книги по ID</title>
</head>
<body>
    <button onclick="window.location.href = '/main';">Перейти на головну сторінку</button>
    <h1>Введіть ID книги яку потрібно знайти</h1>

     <h2><form id = "book-form" method="post" action="find_by_id" th:object="${bookID}">
        <label for="bookID">Пошук книги по ID:</label>
        <input type="number" id="bookID" name= "bookID" required><br>

        <input type="submit" value="Пошук">
    </form></h2>

    </body>
</html>
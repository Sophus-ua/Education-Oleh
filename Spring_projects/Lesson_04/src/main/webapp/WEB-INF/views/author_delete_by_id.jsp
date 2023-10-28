<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Видалення автора по ID</title>
</head>
<body>
    <button onclick="window.location.href = '/main';">Перейти на головну сторінку</button>
    <h1>Введіть ID автора для видалення</h1>

     <h2><form id = "author-form" method="post" action="delete_by_id" th:object="${authorID}">
        <label for="authorID">ID автора якого треба видалити:</label>
        <input type="number" id="authorID" name= "authorID" required><br>

        <input type="submit" value="Видалити">
    </form></h2>

    </body>
</html>
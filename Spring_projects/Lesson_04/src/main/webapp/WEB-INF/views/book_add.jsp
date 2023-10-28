<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Введення даних книги</title>
</head>
<body>
    <button onclick="window.location.href = '/main';">Перейти на головну сторінку</button>
    <h1>Введіть данні книги</h1>

     <h2><form id = "book-form" method="post" action="add" modelAttribute = ${book}>
        <label for="title">Назва книги:</label>
        <input type="text" id="title" name= "title" required><br>

        <input type="submit" value="Внести книгу до бібліотеки">

    </form> </h2>

</body>
</html>
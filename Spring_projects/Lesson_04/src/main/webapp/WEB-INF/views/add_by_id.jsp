<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Додавання книги автору</title>
</head>
<body>
    <button onclick="window.location.href = '/main';">Перейти на головну сторінку</button>
    <h1>Введіть ID автора і ID книги</h1>

     <h2><form id = "add-form" method="post" action="add_by_id" modelAttribute = ${idsModel}>
        <label for="authorID">ID автора:</label>
        <input type="number" id="authorID" name= "authorId" required><br>

        <label for="bookID">ID книги:</label>
        <input type="number" id="bookID" name= "bookId" required><br>

        <input type="submit" value="Додати книгу автору">

    </form> </h2>

</body>
</html>
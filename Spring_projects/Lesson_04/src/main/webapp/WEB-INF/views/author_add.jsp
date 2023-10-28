<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Введення даних автора</title>
</head>
<body>
    <button onclick="window.location.href = '/main';">Перейти на головну сторінку</button>
    <h1>Введіть данні автора</h1>

     <h2><form id = "author-form" method="post" action="add" modelAttribute = ${author}>
        <label for="firstName">Ім'я:</label>
        <input type="text" id="firstName" name= "firstName" required><br>

        <label for="lastName">Фамілія/Псевдонім:</label>
        <input type="text" id="lastName" name= "lastName" required><br>

        <input type="submit" value="Внести автора до бібліотеки">

    </form> </h2>

</body>
</html>
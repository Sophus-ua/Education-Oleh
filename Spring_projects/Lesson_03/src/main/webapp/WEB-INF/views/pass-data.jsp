<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Введення даних</title>
</head>
<body>
    <h1>Введення ім'я та пароля</h1>

     <h2><form id = "user-form" method="post" action="pass-data" modelAttribute = ${user}>
        <label for="name">Ім'я:</label>
        <input type="text" id="name" name= "name" required><br>

        <label for="password">Пароль:</label>
        <input type="password" id="password" name= "password" required><br>

        <input type="submit" value="Зареєструватися">

    </form> </h2>

    <button onclick="window.location.href = 'users-list';">Список зареєстрованних користувачів</button>
</body>
</html>
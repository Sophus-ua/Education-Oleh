<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Main</title>

    <style>
        .button {
            margin-top: 10px;
            margin-right: 15px;
        }
        .form {
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <h2>Меню бібліотеки</h2>
    <h3>${message}</h3>

     <div class="buttons">
        <div class="button">
          <button onclick="window.location.href = 'author/all';">Список авторів</button>
          <button onclick="window.location.href = 'book/all';">Список книг</button>
        </div>
        <div class="button">

        </div>
        <div class="button">
          <button onclick="window.location.href = 'author/find_by_id';">Знайти автора по ID</button>
          <button onclick="window.location.href = 'book/find_by_id';">Знайти книгу по ID</button>
        </div>
        <div class="button">

        </div>
        <div class="button">
          <button onclick="window.location.href = 'author/delete_by_id';">Видалити автора по ID</button>
          <button onclick="window.location.href = 'book/delete_by_id';">Видалити книгу по ID</button>
        </div>
        <div class="button">

        </div>
        <div class="button">
          <button onclick="window.location.href = 'author/add';">Додати автора до бібліотеки</button>
          <button onclick="window.location.href = 'book/add';">Додати книгу до бібліотеки</button>
        </div>
        <div class="button">
           <button onclick="window.location.href = 'add_by_id';">Додати автору книгу по ID</button>
        </div>
        <form id="deleteForm" method="post" action="deleteAll" class="form">
           <button type="submit">Очистити бібліотеку</button>
        </form>
        <form id="autoFillingForm" method="post" action="autoFilling" class="form">
           <button type="submit">Автозаповнення бібліотеки</button>
        </form>
     </div>
</body>

</html>
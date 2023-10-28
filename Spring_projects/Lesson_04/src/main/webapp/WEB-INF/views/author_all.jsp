<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
  <head>
    <title>Список авторів</title>
  </head>

  <body>
      <button onclick="window.location.href = '/main';">Перейти на головну сторінку</button>
     <h3>Список авторів</h3>

     <c:choose>
        <c:when test="${not empty authors}">
            <c:forEach items="${authors}" var="author" varStatus="status">
                <p><h3>Автор id ${author.id}:</h3> ${author}</p>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <p>порожній</p>
        </c:otherwise>
     </c:choose>

  </body>

</html>
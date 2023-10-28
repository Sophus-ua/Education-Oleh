<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
  <head>
    <title>Список книг</title>
  </head>

  <body>
      <button onclick="window.location.href = '/main';">Перейти на головну сторінку</button>
     <h3>Список книг</h3>

     <c:choose>
         <c:when test="${not empty books}">
             <c:forEach items="${books}" var="book" varStatus="status">
                 <p><h3>Книга id ${book.id}:</h3> ${book}</p>
             </c:forEach>
         </c:when>
         <c:otherwise>
             <p>порожній</p>
         </c:otherwise>
     </c:choose>

</html>
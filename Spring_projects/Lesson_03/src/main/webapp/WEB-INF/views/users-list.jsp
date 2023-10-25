<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- Imports --%>
  <%@page import="controllers.User"%>
  <%@page import="java.util.List"%>

<html>
  <head>
    <title>Список користувачів</title>
  </head>

  <body>
    <h2>Список користувачів</h2>
      <c:forEach items="${users}" var="user" varStatus="status">
        <p><h2>Result #${status.index + 1}</h2> ${user.name}</p>
      </c:forEach>
  </body>
</html>






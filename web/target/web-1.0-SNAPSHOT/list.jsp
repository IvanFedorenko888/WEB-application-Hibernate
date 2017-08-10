<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ivan
  Date: 01.06.17
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Список самолетов</title>
    <script src="JS/jquery-3.2.1.min.js"></script>
    <script src="JS/index.js"></script>
    <link rel="stylesheet" type="text/css" media="all" href="CSS/styles.css">
</head>
<body>
<div class="menu">
    <div class="menu_front">
    <nav>
        <ul id="menu_list">
            <li><a type="button" href="index.jsp">Главная</a></li>
            <li><a>Самолеты</a>
                <ul>
                    <li><a type="button" href="create.jsp">Добавить</a></li>
                    <li><a type="button" href="list">Список</a></li>
                </ul>
            </li>
            <li><a>О нас</a></li>
        </ul>
    </nav>
<div id="list_see">
<h3>Список самолетов:</h3>
    <ol>
        <c:forEach items="${airs}" var="air">
            <li>
                ${air.aircraft_code} ${air.model} ${air.range}
                    <a href="add?edit=${air.aircraft_code}">Редактировать</a> | <a href="remove?del=${air.aircraft_code}">Удалить</a>
            </li>
        </c:forEach>
    </ol>
</div>
    </div>
</div>
</body>
</html>

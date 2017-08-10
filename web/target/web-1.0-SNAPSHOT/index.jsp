<%--
  Created by IntelliJ IDEA.
  User: ivan
  Date: 01.06.17
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Главная страница</title>
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

<div class="main_see">
    Добро пожаловать
</div>
    </div>
</div>
</body>
</html>

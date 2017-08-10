<%--
  Created by IntelliJ IDEA.
  User: ivan
  Date: 01.06.17
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Добавление | Редактирование</title>
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


<div class="create">
<form action="add" method="post">
    <label for="aircraft_code">Введите код самолета:
        <input type="text" id="aircraft_code" value="${aircraft.aircraft_code}" name="aircraft_code" />
    </label>  <br />
    <label for="model">Введите модель самолета:
        <input type="text" id="model" value="${aircraft.model}" name="model" />
    </label>  <br />
    <label for="range">Введите дальность полета:
        <input type="text" id="range" value="${aircraft.range}" name="range" />
    </label>  <br />
    <input type="submit" value="Сохранить" />
</form>
</div>
</div>
</div>
</body>
</html>

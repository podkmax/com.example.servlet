<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<html>
<head>
    <title>Запись к врачам</title>
</head>
<body>
<h1>Список врачей</h1>
<h2>Добавить врача</h2>
<form action="" method="post" accept-charset="UTF-8">
    <div style="margin-bottom: 10px;"><label style="margin: 25px;margin-left: 0px;"> ФИО врача : </label><input type="text" name="name" id="name"/> </div>
    <div style="margin-bottom: 10px;"><label style="margin: 6px;margin-left: 0px;"> Специальность:</label><input type="text" name="position" /> </div>
    <div><input type="submit" value="Отправить"/></div>
</form>
<table bordercolor="black" border="2">
    <tr>
        <td>ФИО врача</td>
        <td>Специализация</td>
    </tr>
    <c:forEach var="doc" items="${doctors}">
    <tr>
        <td><c:out value="${doc.name}"/></td>
        <td><c:out value="${doc.position}"/></td>
    </tr>
    </c:forEach>
</table>
</body>
</html>

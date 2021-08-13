<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 李晓扬
  Date: 2021/8/7
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table  cellpadding="5" cellspacing="0" border=1">
        <tr>
            <td>id</td>
            <td>name</td>
            <td>location</td>
            <td>type</td>
        </tr>
    <c:forEach items="${pageHelp.list}" var="i">
        <tr>
            <td>${i.id}</td>
            <td>${i.name}</td>
            <td>${i.location}</td>
            <td>${i.type}</td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="4">
            <a href="getCats?pageId=${1}" >首页</a>
            <c:forEach items="${pageHelp.navigatepageNums}" var="i">
                <c:if test="${i == pageHelp.pageNum}">
                    <a>${i}</a>
                </c:if>
               <c:if test="${i != pageHelp.pageNum}">
                   <a href="getCats?pageId=${i}">${i}</a>
               </c:if>
            </c:forEach>
            <a href="getCats?pageId=${pageHelp.pages}">末页</a>
        </td>
    </tr>
</table>
</body>
</html>

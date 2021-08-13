<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: 李晓扬
  Date: 2021/7/12
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>Title</title>
</head>
<body>
    成功了
    <h1><fmt:message key="welcomeino"/></h1>
    <table>
        <tr>
            <th><fmt:message key="username"/></th>
            <th><fmt:message key="passward"/></th>
        </tr>
        <tr>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <input type="submit" value="<fmt:message key="submit"/>">
        </tr>
    </table>
</body>
</html>

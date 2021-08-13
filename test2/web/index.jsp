<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: 李晓扬
  Date: 2021/7/12
  Time: 22:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript"></script>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  $END$
  <a href="handle1">点击，最简单的一个请求</a>
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
  <a href="handle2">视频</a>
  </body>
</html>

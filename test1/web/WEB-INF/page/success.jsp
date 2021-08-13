<%--
  Created by IntelliJ IDEA.
  User: 李晓扬
  Date: 2021/7/1
  Time: 13:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>

<html>
<head>
    <title>Title</title>

</head>
<body>
成功,而且是WEB-INF/page下的<br/>
requestScope：${requestScope.username}   还有么：${requestScope.msg}<br/>
sessionScope：${sessionScope.username}<br/>
requestScope.user：${requestScope.user.username}<br/>
${requestScope.user.age}<br/>
${requestScope.user.gender}<br/>
${requestScope.user.locale}<br/>
${requestScope.user.getClass()}<br/>

</body>
</html>

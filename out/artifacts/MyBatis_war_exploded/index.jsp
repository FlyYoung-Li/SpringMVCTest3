<%--
  Created by IntelliJ IDEA.
  User: 李晓扬
  Date: 2021/8/1
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <a href="getTeacherById">获取学生的信息</a><br/>
    <form action="updateTeacher" method="post">
      id      <input type="text" name="id"><br/>
      name    <input type="text" name="name"><br/>
      age     <input type="text" name="age"><br/>
      location<input type="text" name="location"><br/>
        <input type="submit">
<%--      自己现在想做一套,这里添加,数据库就能添加,但是现在还做不到,所以只能先做数据库的--%>
    </form>
  </head>
  <body>
  $END$
  </body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: 李晓扬handle
  Date: 2021/7/1
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <a href="handle?username=456789123" >get方法 </a>

  <form action="handle?user=456" method="post">
    <input type="submit" value="新建">
  </form>
  <form action="handle" method="post">
<%--    有一个隐藏表单项,作为参数传递而已，hidden，就是隐藏--%>
    <input type="hidden" name="_method" value="put">
    <input type="submit" value="更新">

  </form><%--不隐藏，也可以，多一个输入框而已，确实，如果是put和delete，要输入什么--%>
  <form action="handle" method="post">
    <input  name="_method" value="delete">
    <input type="submit" value="删除">

  </form>

  <form action="handle" method="post">
    <table>
      <tr>
        <td> lxy</td>
        </td>
      </tr>
      <tr>
        <td>年龄</td>
        <td><input type="text" name="age" ></td>
      </tr>
      <tr>
        <td>性别</td>
        <td><input type="text" name="gender" ></td>
      </tr>
      <tr>
        <td>国家区域信息</td>
        <td><input type="text" name="locale" ></td>
      </tr><tr>

        <td><input type="submit" ></td>
      </tr>

    </table>
  </form>
  <a href="forward">forward的测试</a>
  </body>
<a href="handle5">ModelAndView的测试</a>
</html>

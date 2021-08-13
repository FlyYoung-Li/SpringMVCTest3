<%@ page import="com.atguigu.dao.DepartmentDao" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>

<%--
  Created by IntelliJ IDEA.
  User: 李晓扬
  Date: 2021/7/13
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setAttribute("ctp", request.getContextPath());%>
<html>
<head>
<%--<script type="text/javascript" src="webjars/jquery/3.5.1/jquery.min.js"></script>--%>
<%--    <script type="text/javascript">--%>
<%--        $(function () {--%>
<%--            alert("hhhh");--%>
<%--        });--%>
<%--    </script>--%>
</head>
<body>
<%--以后是不会使用这样的表单提交的，springmvc提供了更加遍历的form表单，支持表单回显--%>
   <%-- <form action="employee" method="post">
        <input type="hidden" name="id" value="123">
        LastName<input type="text" name="lastName"><br/>
        Email<input type="text" name="email"><br/>
        Gender<input type="radio" name="gender" value="1">boy
                <input type="radio" name="gender" value="0">girl<br/>
        Department<select name="department.id">
                    <c:forEach items="${departments}" var="department">
                        <option value="${department.id}">${department.departmentName}</option>
                    </c:forEach>
                </select>
        <input type="submit" value="提交">
    </form>--%>


<form:form action="employee"  method="post">
    lastName<form:input path="lastName"></form:input><fm:errors path="lastName"/>${exception.lastName}<br/>
    Email<form:input path="email"></form:input><fm:errors path="email"/><br/>${exception.email}
    Gender
            男<form:radiobutton path="gender" value="1" ></form:radiobutton>
            女<form:radiobutton path="gender" value="0" ></form:radiobutton><br/>
    Department
    <form:select
            path="department.id"
            items="${departments}"
            itemLabel="departmentName"
            itemValue="id">
    </form:select><br/>
    Date<form:input path="date"></form:input><fm:errors path="date"/>${exception.date}

    <input type="submit" value="保存">
</form:form>
<%--这里是做一下测试，发现http400的错误，不是因为method，而是因为请求返回的参数类型和bean的类型不一致--%>
<%--<form action="hello" method="post">--%>
<%--    <input type="submit"value="提交">--%>
<%--</form>--%>
</body>
</html>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: 李晓扬
  Date: 2021/7/15
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%request.setAttribute("ctp",request.getContextPath());%>
<html>
<head>

    <title>Title</title>
</head>
<body>
<%--因为前面的toEdit/id,请求路径，有两层，所以，项目中还是使用绝对路径--%>
<%--<form:form action="../edit"  method="post" modelAttribute="employee">--%>
<form:form action="${ctp}/employee"  method="put" modelAttribute="employee">
    lastName${employee.lastName}<br/>
    <input type="hidden" name="_method" value="put">
    <form:hidden path="id" ></form:hidden>
    <%--这里的隐藏域还是很重要的，因为从隐含模型中拿的employee，要有id属性，不然后面save的时候就是添加，不是更新--%>
    Email<form:input path="email"></form:input><br/>
    Gender
    男<form:radiobutton path="gender" value="1" ></form:radiobutton>
    女<form:radiobutton path="gender" value="0" ></form:radiobutton><br/>
    Department
    <form:select
            path="department.id"
            items="${departments}"
            itemLabel="departmentName"
            itemValue="id">
    </form:select>
    <input type="submit" value="保存">
</form:form>
</body>
</html>

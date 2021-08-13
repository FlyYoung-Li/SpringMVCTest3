<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<% request.setAttribute("ctp", request.getContextPath());%>



<html>
<head>
    <title>Title</title>
<script type="text/javascript" src="${ctp}/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script type="text/javascript">
        $(function (){
            //点击a标签的删除点击事件
            $(".deleteBtn").click(function (){
                //将form删除表单中的action属性，设置成当前点击对象a标签的跳转地址href
                $("#delete").attr("action",this.href);
                //将form删除表单，进行提交
                $("#delete").submit();
                //阻止a标签跳转
                return false;
            });
        });
    </script>
</head>
<body>
<h1 align="center">页面展示成功</h1>
<table align="center" border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>员工ID</th>
        <th>员工姓名</th>
        <th>员工邮箱</th>
        <th>员工性别</th>
        <th>员工部门</th>
        <th>编辑</th>
        <th>删除</th>
    </tr>
    <c:forEach items="${requestScope.employees}" var="i">
        <tr>
            <td>${i.id}</td>
            <td>${i.lastName}</td>
            <td>${i.email}</td>
            <td>${i.gender==0?"女":"男"}</td>
            <td>${i.department}</td>
            <td><a href="${ctp}/employee/${i.id}">edit</a></td>
            <td><a href="${ctp}/employee/${i.id}" class="deleteBtn">delete</a></td>

        </tr>
    </c:forEach>
<%--    思路：点击a标签，绑定单击事件，把地址给下面的删除表单，然后去执行--%>
    <form:form action="${ctp}/employee/${i.id}" method="delete" id="delete">
        <input type="hidden" name="_method" value="delete">
    </form:form><br/>
    <form action="${ctp}/quicklyAdd" method="post" >
        <input type="text" value="lxy-132@126.com-0-101" name="quickAdd">
        <input type="submit"value="快速添加">
    </form>
</table>
    <a href="${ctp}/toAdd" >添加</a>
<%--<script type="text/javascript" src="${ctp}/webjars/jquery/3.5.1/jquery.js"></script>
<script type="text/javascript">
    $(function(){
        alert("看看我能不能成功");
    });
</script>--%>
</body>
</html>

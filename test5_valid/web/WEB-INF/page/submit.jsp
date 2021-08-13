<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: 李晓扬
  Date: 2021/7/24
  Time: 13:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% pageContext.setAttribute("ctp", request.getContextPath());%><%--这是导入了jsp包之后，才可以使用的--%>


<html>
<head>
    <script type="text/javascript" src="webjars/jquery/3.5.1/jquery.min.js"></script>
    <script type="text/javascript">
        $(function () {
            console.log("123456");
            $("a#get").click(function () {
                $("div").append("看看我有没有没出现，要现有div标签，然后把我填进去<br/> ");
                $.ajax({
                    url: "${ctp}/getAEmployee",
                    type: "GET",
                    success: function (data) {
                        /*alert(data);*/
                        console.log("123");
                        alert(typeof data);
                        alert(typeof data.birth);
                        var empInf = data.name + "->" + data.email+data.age+"->"+data.birth;
                        $("div").append(data + "<br/>");
                    }
                });
                return false;
            });
        });

    </script>
</head>

<body>
<%--这里测试表单回显--%>
<form:form action="${ctp}/logging" method="post">
    员工姓名<form:input path="name"/><form:errors path="name"/><br/>
    员工年龄<form:input path="age"/><form:errors path="age"/><br/>
    员工邮箱<form:input path="email"/><form:errors path="email"/><br/>
    员工生日<form:input path="birth"/><form:errors path="birth"/><br/>
    <input type="submit" value="提交">
</form:form><br/>
<%--这里测试ajax请求--%>
下面是第二个表格，用来处理第二个请求<br/>
<form action="${ctp}/handleAjax" method="post">
    员工姓名<input type="text" name="name"><br/>
    员工年龄<input type="text" name="age"><br/>
    员工邮箱<input type="text" name="email"><br/>
    员工生日<input type="text" name="birth"><br/>
    <input type="submit" value="提交">
</form>
<br/>
<%--这里测试ajax请求回显数据--%>
<a href="12346" id="get">得到一个对象</a>
<div></div><br/>
<%--这里测试requestBody传输json字符串--%>
<form action="${ctp}/requestBodyTest" method="post" enctype="multipart/form-data">
    员工姓名<input type="text" name="name"><br/>
    员工年龄<input type="text" name="age"><br/>
    员工邮箱<input type="text" name="email"><br/>
    员工生日<input type="text" name="birth"><br/>
    上传的文件或者是图片<input type="file" name="fileName">
    <input type="submit" value="提交">
</form>
<%--这里再来测试一下，requestBody，获取json数据（并转为对象）--%>
<form action="${ctp}/requestBodyTest2" method="post" id="requestBodyTest2">
    员工姓名<input type="text" name="name"><br/>
    员工年龄<input type="text" name="age"><br/>
    员工邮箱<input type="text" name="email"><br/>
    员工生日<input type="text" name="birth"><br/>
    <input type="submit" value="提交">
</form>
<script type="text/javascript">
    // $(function (){
        $("form#requestBodyTest2").click(function(){
            var jsonObject ={
                name:"lxy",
                age:45,
                email:"123@qq.com",
                birth:"2013-12-1"
            };
            var jsonString = JSON.stringify(jsonObject);
            alert(jsonString);
            $.ajax({
                url:"${ctp}/requestBodyTest2",
                type:"POST",
                data:jsonString,
                contentType:"application/json",
                success:function (data){
                    alert(data);
                }
            });return false;//正好在ajax之后，也就是此刻异步请求执行完毕，对应的方法已经执行一次
        });//这里，表示，a标签的点击事件结束后，采取访问目标资源，这里return false，所以，不去访问目标资源
    // });
</script><br/>

使用httpEntityTest来接收请求实体
<form action="${ctp}/httpEntityTest" method="post" enctype="multipart/form-data">
    选择文件<input type="file" name="file">
    <input type="submit" value="submit">
</form><br/>
文件下载的练习
<a href="${ctp}/downloading" name="downloading">文件下载</a><br/>
文件上传的练习（有一个MultipartResolver确实更加方便了）
<form action="${ctp}/fileUpload" method="post" enctype="multipart/form-data">
    选择文件<input type="file" name="file">
    <input type="submit" value="submit">
</form>
</body>
</html>

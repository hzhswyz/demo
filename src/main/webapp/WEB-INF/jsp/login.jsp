<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/22
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  pageEncoding="utf-8" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <style>
        .error{
            color:red;
        }
    </style>
</head>
<body>
<sf:form method="post" acceptCharset="utf-8" commandName="user">
    <sf:label path="name" cssErrorClass="error">姓名: </sf:label> <sf:input path="name"/><sf:errors path="name" cssClass="error"/> <br/>
    <sf:label path="password" cssErrorClass="error">密码: </sf:label><sf:password path="password" /><sf:errors path="password" cssClass="error"/><br/>
    <input type="submit" value="login">
</sf:form>
</body>
</html>

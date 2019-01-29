<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: HZH
  Date: 2019/1/29
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<sf:form method="post" action="/email/send" acceptCharset="utf-8" commandName="emailmodel">
    <sf:label path="to" cssErrorClass="error">发送至: </sf:label> <sf:input path="to"/><sf:errors path="to" cssClass="error"/> <br/>
    <sf:label path="text" cssErrorClass="error">文本: </sf:label><sf:password path="text" /><sf:errors path="text" cssClass="error"/><br/>
    <input type="submit" value="send">
</sf:form>
</body>
</html>

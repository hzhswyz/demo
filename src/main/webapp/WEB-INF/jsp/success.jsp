<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/22
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Success
<s:message code="welcome"/>
<s:url var="ff" value="/ss/"/>
<a href="${ff}">ffff</a>
<s:url value="/home{name}" htmlEscape="true">
    <s:param name="name" value="hzh"/>
</s:url>
<s:url value="/home{name}" javaScriptEscape="true" var="zz">
    <s:param name="name" value="hzh"/>
</s:url>
<script>
    var ff = "${zz}"
</script>
<s:escapeBody htmlEscape="true">
    <html>
    <h1>hhh</h1>
    </html>
</s:escapeBody>
<s:escapeBody javaScriptEscape="true">
    <html>
    <h1>hhh</h1>
    </html>
</s:escapeBody>
</body>
</html>

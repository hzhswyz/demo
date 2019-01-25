<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<body>
<h2>Hello World!${user.name}</h2>
<security:authorize access="hasAnyRole('admin')">
Hello <security:authentication property="principal.username"/>
</security:authorize>
</body>
</body>
</html>

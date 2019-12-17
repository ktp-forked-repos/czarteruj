<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <sec:authorize access="isAnonymous()">
       <a href="/login">zaloguj</a><br>
       <a href="register">zarejestruj</a>
   </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <a href="/logout">wyloguj</a>
    </sec:authorize>
</body>
</html>

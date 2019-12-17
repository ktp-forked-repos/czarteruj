<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rejestracja</title>
</head>
<body>
    <form:form id="usersForm" action="addUser" modelAttribute="user">
        <form:input path="firstName" placeholder="Imię"/>
        <form:errors path="firstName"/>
        <form:input path="lastName" placeholder="Nazwisko"/>
        <form:errors path="lastName"/>
        <form:input path="email" placeholder="email"/>
        <form:errors path="email" />
        <form:input path="password" placeholder="hasło"/>
        <form:errors path="password"/>
        <input type="submit" value="zapisz"/>
        <input type="button" >
    </form:form>

</body>
</html>

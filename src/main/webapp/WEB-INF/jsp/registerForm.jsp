<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style><%@include file="/WEB-INF/css/registrationForm.css"%></style>
<html>
<head>
    <title>Rejestracja</title>
</head>
<body>
    <form:form id="usersForm" action="addUser" modelAttribute="user">

        <form:input path="firstName" placeholder="Imię" />
        <form:errors path="firstName" /><br/>
        <form:input path="lastName" placeholder="Nazwisko" />
        <form:errors path="lastName"/><br/>
        <form:input path="email" placeholder="email" />
        <form:errors path="email" /><br/>
        <form:input path="password" type="password" placeholder="hasło" />
        <form:errors path="password"/><br/>

        <input type="submit" class="btn" value="zapisz"/>
        <a href="index.jsp"><button>anuluj</button></a>
    </form:form>

</body>
</html>

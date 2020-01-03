<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="s"  uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style><%@include file="/WEB-INF/css/index.css"%></style>
<head>
    <title>Czarteruj</title>
</head>
<body>
<div id="container">
<div id="header">
    <div id="title-header">
        <a href="/"><s:message code="index.mainpage"/></a>

    </div>
    <div id="login-header">
        <sec:authorize access="hasRole('ANONYMOUS')">
            <a href="/login"><button class="login-button">zaloguj</button></a>
            <a href="register"><button class="login-button">zarejestruj</button></a>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <a href="/logout"><button class="login-button">wyloguj</button></a>
        </sec:authorize>

    </div>

</div>
<div id="content">

    <h1>Znajdź czarterownię na mapie</h1>

</div>

<div id="map">
</div>
</div>
<script>


    function initMap() {

        var center = {lat:52.068, lng: 19.475};


        var uluru = {lat: 52.150, lng: 21.000};
        var uluru2 = {lat: 52.000, lng: 21.500};

        var map = new google.maps.Map(
            document.getElementById('map'), {zoom: 7, center: center});

        var marker = new google.maps.Marker({position: uluru, map: map});
        var marker2 = new google.maps.Marker({position: uluru2, map: map})
    }
</script>
<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA8-lVkBYX7vSGQmsCsMlKntPuvqqn9QH8&callback=initMap">
</script>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Niki
  Date: 2017-01-29
  Time: 12:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <link type="text/css" href="${pageContext.request.contextPath}/resources/headline.css" rel="stylesheet"/>
</head>
<body>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">Home</a>

        <a class="navbar-brand" href="/collection" id="collection-button"><span
                class="glyphicon glyphicon-chevron-right"
                aria-hidden="true"></span> My Collection</a>


        <div class="collapse navbar-collapse">
            <sec:authorize access="hasRole('ROLE_ANONYMOUS')">
                <c:import url="sign-in.jsp"/>
            </sec:authorize>

            <sec:authorize access="hasAuthority('ROLE_USER')">
                <c:import url="user-panel.jsp"/>
            </sec:authorize>

        </div>
    </div>
</nav>
</body>
</html>

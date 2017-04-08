<%--
  Created by IntelliJ IDEA.
  User: Niki
  Date: 2017-01-29
  Time: 12:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <link type="text/css" href="${pageContext.request.contextPath}/resources/headline.css" rel="stylesheet"/>
</head>
<body>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <a class="navbar-brand" href="/index">Home</a>

        <a class="navbar-brand" href="/collection" id="collection-button"><span class="glyphicon glyphicon-chevron-right"
                                                                                aria-hidden="true"></span> My Collection</a>


        <div class="collapse navbar-collapse">
            <c:set var="loginUrl"><c:url value="/login"/></c:set>
            <form class="navbar-form navbar-right" action="${loginUrl}" method="post" id="log-in-form">
                <div class="form-group">
                    <label class="sr-only" for="email">Email address</label>
                    <input type="email" class="form-control" id="email" name="email" placeholder="E-mail" required>
                </div>
                <div class="form-group">
                    <label class="sr-only" for="password">Password</label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="Password"
                           required>
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button type="submit" class="btn btn-default">Sign in</button>
            </form>
        </div>
    </div>
</nav>
</body>
</html>

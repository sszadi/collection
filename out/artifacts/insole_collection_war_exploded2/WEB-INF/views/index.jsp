<%--
  Created by IntelliJ IDEA.
  User: Niki
  Date: 2017-01-10
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setBundle basename="messages"/>
<html>
<head>
    <title>Insole</title>
    <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css"/>
    <link type="text/css" href="${pageContext.request.contextPath}/resources/index.css" rel="stylesheet"/>
</head>

<body>

<div class="main-block">

    <jsp:include page="headline.jsp"/>


    <c:if test="${param.error == true}">
        <div class="alert alert-danger" role="alert">
            <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
            <span class="sr-only">Error:</span>
            <spring:message code="message.loginError">
            </spring:message>
        </div>

    </c:if>

    <c:if test="${not empty regSucc}">
        <div class="alert alert-success" role="alert">
            <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
            <span class="sr-only">Error:</span>
            <spring:message code="message.regSucc">
            </spring:message>
        </div>

    </c:if>

    <c:if test="${not empty logPlease}">
        <div class="alert alert-info" role="alert">
            <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
            <span class="sr-only">Error:</span>
            <spring:message code="message.logPlease">
            </spring:message>
        </div>

    </c:if>
    <div class=container>
        <div class="content">
            <div class="jumbotron" id=hello-div>
                <h1 class="shadow">Insole</h1>
                <p class="shadow">Create your own sneakers collection and make it bigger in one place!</p>
                <p><a class="btn btn-primary btn-lg" href="/register" role="button">Sign up</a></p>
            </div>


            <div class="menu">
                <jsp:include page="menu.jsp"/>
            </div>

            <jsp:include page="thumbnails.jsp"/>
        </div>
    </div>
</div>

</body>
</html>

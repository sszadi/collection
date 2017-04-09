<%--
  Created by IntelliJ IDEA.
  User: Niki
  Date: 2017-01-10
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Insole</title>
    <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link type="text/css" href="${pageContext.request.contextPath}/resources/index.css" rel="stylesheet"/>
</head>

<body>

<div class="main-block">

    <jsp:include page="headline.jsp"/>

    <div class=content>
        <div class="container">
            <div class="jumbotron" id=hello-div>
                <h1 class="shadow">Insole</h1>
                <p class="shadow">Create your own sneakers collection and make it bigger in one place!</p>
                <p><a class="btn btn-primary btn-lg" href="/register" role="button">Sign up</a></p>
            </div>
        </div>


        <div class="menu">
            <jsp:include page="menu.jsp"/>
        </div>

        <div class="thumbnails">
            <jsp:include page="thumbnails.jsp"/>
        </div>

    </div>
</div>

</body>
</html>

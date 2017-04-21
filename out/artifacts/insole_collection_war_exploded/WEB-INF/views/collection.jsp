<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Insole</title>
    <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link type="text/css" href="${pageContext.request.contextPath}/resources/index.css" rel="stylesheet"/>
    <link type="text/css" href="${pageContext.request.contextPath}/resources/add.css" rel="stylesheet"/>
</head>
<body>
<div class="main-block">

    <jsp:include page="headline.jsp"/>

    <c:if test="${param.addError == true}">
    <div class="alert alert-danger" role="alert">
        <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
        <span class="sr-only">Error:</span>
        <spring:message code="message.addError">
        </spring:message>
    </div>

    </c:if>

    <c:if test="${param.addSucc == true}">
    <div class="alert alert-success" role="alert">
        <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
        <span class="sr-only">Error:</span>
        <spring:message code="message.addSucc">
        </spring:message>
    </div>

    </c:if>

    <div class="container">
        <div class="jumbotron" id="image">
        </div>

        <div class=content>
            <a href="/add" type="button" class="btn btn-default">Add sneakers</a>
            <div class="menu">
                <jsp:include page="menu.jsp"/>
            </div>
        </div>
    </div>

</body>
</html>

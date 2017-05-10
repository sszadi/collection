<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Insole</title>
    <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link type="text/css" href="${pageContext.request.contextPath}/resources/index.css" rel="stylesheet"/>
    <link type="text/css" href="${pageContext.request.contextPath}/resources/add.css" rel="stylesheet"/>
    <link type="text/css" href="${pageContext.request.contextPath}/resources/collection.css" rel="stylesheet"/>

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


    <c:if test="${not empty delSucc}">
    <div class="alert alert-success" role="alert">
        <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
        <span class="sr-only">Error:</span>
        <spring:message code="message.delSucc">
        </spring:message>
    </div>

    </c:if>

    <div class="container">
        <div class="jumbotron" id="image">
        </div>

        <div class=content>

            <div class=" menu">
                <jsp:include page="menu.jsp"/>
            </div>


            <div id="nav-container">

                <h4>My Collection</h4>

                <a href="/list" type="button" class="btn btn-default">My WTB list</a>

                <a href="/add/${sneakers.id}" type="button" class="btn btn-default">Add sneakers</a>
            </div>

            <c:forEach items="${collectionList}" var="sneakers" varStatus="loop">
                <c:if test="${loop.index % 3 == 0}">
                    <c:set var="index" value="${loop.index}"/>
                    <div class="row" id="collection">
                </c:if>
                <div class="col-xs-6 col-md-4" id="thumbnail-div">
                    <a href="/sneakers/id/${sneakers.id}" class="thumbnail snk-image">
                        <img src="http://localhost:9999/images/${sneakers.filename}">
                        <h5>${sneakers.brand.name}</h5>
                        <p class="paragraph">${sneakers.size}</p>
                    </a>
                </div>
                <c:if test="${loop.index != index and loop.index % 3 == 2}">
                    </div>
                </c:if>
            </c:forEach>


        </div>

    </div>

</body>
</html>

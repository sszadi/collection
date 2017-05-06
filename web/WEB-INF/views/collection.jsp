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

    <div class="container">
        <div class="jumbotron" id="image">
        </div>

        <div class=content>

            <div class=" menu">
                <jsp:include page="menu.jsp"/>
            </div>


            <div id="nav-container">

                <h4>My Collection</h4>

                <a href="..." type="button" class="btn btn-default">My WTB list</a>

                <a href="/add" type="button" class="btn btn-default">Add sneakers</a>
            </div>

            <div class="row" id="collection">
                <c:forEach items="${collectionList}" var="sneakers">
                    <div class="col-xs-6 col-md-4" id="thumbnail-div">
                        <a href="..." class="thumbnail">
                            <img src="..." alt="...">
                            <h5>${sneakers.brand.name}</h5>
                            <p class="paragraph">${sneakers.size}</p>
                        </a>
                    </div>
                </c:forEach>
            </div>

        </div>

    </div>

</body>
</html>

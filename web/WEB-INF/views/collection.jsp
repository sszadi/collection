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

    <c:if test="${param.delSucc == true}">
    <div class="alert alert-success" role="alert">
        <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
        <span class="sr-only">Error:</span>
        <spring:message code="message.delSucc">
        </spring:message>
    </div>
    </c:if>

    <c:if test="${param.editError == true}">
    <div class="alert alert-danger" role="alert">
        <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
        <span class="sr-only">Error:</span>
        <spring:message code="message.editError">
        </spring:message>
    </div>
    </c:if>

    <c:if test="${param.editSucc == true}">
    <div class="alert alert-success" role="alert">
        <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
        <span class="sr-only">Error:</span>
        <spring:message code="message.editSucc">
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

            <c:if test="${empty collectionList.content}">
                <div class="alert alert-info" role="alert" id="empty">Your collection is empty! Add sneakers.</div>
            </c:if>

            <c:import url="thumbnails.jsp"/>


            <p id="collection-worth">Your collection is worth: ${worth} USD.</p>

            <div id="pagination">
                <nav aria-label="">
                    <ul class="pager">
                        <c:choose>

                            <c:when test="${collectionList.first and collectionList.last}">
                                <li class="disabled"><a>Previous</a></li>
                                <li class="disabled"><a>Next</a></li>
                            </c:when>
                            <c:when test="${collectionList.first}">
                                <li class="disabled"><a>Previous</a></li>
                                <li class="active"><a href="/collection/show?page=${collectionList.number+1}">Next</a></li>
                            </c:when>
                            <c:when test="${collectionList.last}">
                                <li class="active"><a href="/collection/show?page=${collectionList.number-1}">Previous</a>
                                </li>
                                <li class="disabled"><a>Next</a></li>
                            </c:when>
                            <c:otherwise>
                                <li class="active"><a href="/collection/show?page=${collectionList.number-1}">Previous</a>
                                </li>
                                <li class="active"><a href="/collection/show?page=${collectionList.number+1}">Next</a></li>
                            </c:otherwise>
                        </c:choose>
                    </ul>
                </nav>
            </div>

        </div>

    </div>

</body>
</html>

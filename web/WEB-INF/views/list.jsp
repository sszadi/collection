<%--
  Created by IntelliJ IDEA.
  User: Niki
  Date: 2017-02-12
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<html>
<head>
    <title>Insole</title>
    <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link type="text/css" href="${pageContext.request.contextPath}/resources/index.css" rel="stylesheet"/>
    <link type="text/css" href="${pageContext.request.contextPath}/resources/list.css" rel="stylesheet"/>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css"/>
    <script src="${pageContext.request.contextPath}/resources/scripts/search.js"></script>

</head>
<body>
<div class="main-block">

    <jsp:include page="headline.jsp"/>

    <c:if test="${param.listError == true}">
        <div class="alert alert-danger" role="alert">
            <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
            <span class="sr-only">Error:</span>
            <spring:message code="message.listError">
            </spring:message>
        </div>

    </c:if>

    <c:if test="${param.listSucc == true}">
        <div class="alert alert-success" role="alert">
            <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
            <span class="sr-only">Error:</span>
            <spring:message code="message.listSucc">
            </spring:message>
        </div>

    </c:if>

    <div class="container">
        <div class="jumbotron" id="image">
        </div>


        <div class=content>


            <div class="menu">
                <jsp:include page="menu.jsp"/>
            </div>

            <div class="list-div">
                <h4>Your WTB list.</h4>
                <form class="form-horizontal" method="post" action="/list/add">
                    <div class="input-group">
                        <input type="text" id="inputSearch" class="form-control" name="name"
                               placeholder="Add to your WTB list...">

                        <span class="input-group-btn">
                        <button class="btn btn-default" type="submit">Submit</button>
                    </span>
                    </div>
                </form>
            </div>

            <div class="panel panel-info list-div">

                <div class="list-group">
                    <c:forEach items="${buyList}" var="sneakers">
                        <a href="#" class="list-group-item">${sneakers.name}</a>
                    </c:forEach>
                </div>

            </div>


        </div>

    </div>


</div>


</body>
</html>

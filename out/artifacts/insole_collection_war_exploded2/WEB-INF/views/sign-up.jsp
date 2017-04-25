<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Insole</title>

    <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link type="text/css" href="${pageContext.request.contextPath}/resources/index.css" rel="stylesheet"/>
    <link type="text/css" href="${pageContext.request.contextPath}/resources/sign-up.css" rel="stylesheet"/>

</head>
<body>

<div class="main-block">

    <jsp:include page="headline.jsp"/>

    <c:if test="${not empty regError}">
        <div class="alert alert-danger" role="alert">
            <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
            <span class="sr-only">Error:</span>
            <spring:message code="message.regError">
            </spring:message>
        </div>

    </c:if>\
    <c:if test="${not empty passwordError}">
        <div class="alert alert-danger" role="alert">
            <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
            <span class="sr-only">Error:</span>
            <spring:message code="message.passwordError">
            </spring:message>
        </div>

    </c:if>

    <div class="content">

        <div class="container">
            <div class="jumbotron" id="image">
            </div>

            <div class="jumbotron" id=sign-up-div>
                <p>Sign up for Insole!</p>

                <form class="form-horizontal" th:object="${user}" role="form" action="/register" method="post">
                    <div class="form-group">
                        <label for="inputEmail" class="col-sm-2 control-label">Email</label>
                        <div class="col-sm-10">
                            <input type="email" name="email" class="form-control" id="inputEmail"
                                   placeholder="Email" required>
                        </div>


                        <label for="inputNick" class="col-sm-2 control-label">Nick</label>
                        <div class="col-sm-10">
                            <input name="username" class="form-control"
                                   id="inputNick"
                                   placeholder="Username" required>
                        </div>

                        <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
                        <div class="col-sm-10">
                            <input type="password" name="password" class="form-control"
                                   id="inputPassword3"
                                   placeholder="Password" required>
                        </div>

                        <label for="repeatPassword" class="col-sm-2 control-label"></label>
                        <div class="col-sm-10">
                            <input type="password" name="matchingPassword"
                                   class="form-control"
                                   id="repeatPassword"
                                   placeholder="Enter password again" required>

                        </div>
                        <button type="submit" class="btn btn-default" id="submit-button">Submit</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <div class="menu">
        <jsp:include page="menu.jsp"/>
    </div>

    <div class="thumbnails">
        <jsp:include page="thumbnails.jsp"/>
    </div>
</div>
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: Niki
  Date: 2017-05-14
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insole</title>
    <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link type="text/css" href="${pageContext.request.contextPath}/resources/index.css" rel="stylesheet"/>
    <link type="text/css" href="${pageContext.request.contextPath}/resources/profile.css" rel="stylesheet"/>

</head>
<body>

<div class="main-block">

    <jsp:include page="headline.jsp"/>

    <div class="container">
        <div class="jumbotron" id="image">
        </div>
        <div class="content">

            <div class="menu">
                <jsp:include page="menu.jsp"/>
            </div>


            <div id="user-panel">
                <div class="panel-body" id="user-info">
                    <div class="row">
                        <table class="table table-user-information">
                            <tbody>
                            <tr>
                                <td>Email:</td>
                                <td><sec:authentication property="principal.username"/></td>
                            </tr>
                            <tr>
                                <td>Username:</td>
                                <td>${user.username}</td>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="row" id="rating">
                    <div class="col-xs-12 col-md-6">
                        <div class="well well-sm" id="rating-cont">
                            <div class="row">
                                <div class="col-xs-12 col-md-6 text-center">
                                    <h1 class="rating-num">
                                        4.0</h1>
                                    <div class="rating">
                                        <span class="glyphicon glyphicon-star"></span><span
                                            class="glyphicon glyphicon-star">
                            </span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star">
                            </span><span class="glyphicon glyphicon-star-empty"></span>
                                    </div>
                                    <div>
                                        <span class="glyphicon glyphicon-user"></span>1,050,008 total
                                    </div>
                                </div>
                                <div class="col-xs-12 col-md-6">
                                    <div class="row rating-desc">
                                        <div class="col-xs-3 col-md-3 text-right">
                                            <span class="glyphicon glyphicon-star"></span>5
                                        </div>
                                        <div class="col-xs-8 col-md-9">
                                            <div class="progress progress-striped">
                                                <div class="progress-bar progress-bar-success" role="progressbar"
                                                     aria-valuenow="20"
                                                     aria-valuemin="0" aria-valuemax="100" style="width: 80%">
                                                    <span class="sr-only">80%</span>
                                                </div>
                                            </div>
                                        </div>
                                        <!-- end 5 -->
                                        <div class="col-xs-3 col-md-3 text-right">
                                            <span class="glyphicon glyphicon-star"></span>4
                                        </div>
                                        <div class="col-xs-8 col-md-9">
                                            <div class="progress">
                                                <div class="progress-bar progress-bar-success" role="progressbar"
                                                     aria-valuenow="20"
                                                     aria-valuemin="0" aria-valuemax="100" style="width: 60%">
                                                    <span class="sr-only">60%</span>
                                                </div>
                                            </div>
                                        </div>
                                        <!-- end 4 -->
                                        <div class="col-xs-3 col-md-3 text-right">
                                            <span class="glyphicon glyphicon-star"></span>3
                                        </div>
                                        <div class="col-xs-8 col-md-9">
                                            <div class="progress">
                                                <div class="progress-bar progress-bar-info" role="progressbar"
                                                     aria-valuenow="20"
                                                     aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                                                    <span class="sr-only">40%</span>
                                                </div>
                                            </div>
                                        </div>
                                        <!-- end 3 -->
                                        <div class="col-xs-3 col-md-3 text-right">
                                            <span class="glyphicon glyphicon-star"></span>2
                                        </div>
                                        <div class="col-xs-8 col-md-9">
                                            <div class="progress">
                                                <div class="progress-bar progress-bar-warning" role="progressbar"
                                                     aria-valuenow="20"
                                                     aria-valuemin="0" aria-valuemax="100" style="width: 20%">
                                                    <span class="sr-only">20%</span>
                                                </div>
                                            </div>
                                        </div>
                                        <!-- end 2 -->
                                        <div class="col-xs-3 col-md-3 text-right">
                                            <span class="glyphicon glyphicon-star"></span>1
                                        </div>
                                        <div class="col-xs-8 col-md-9">
                                            <div class="progress">
                                                <div class="progress-bar progress-bar-danger" role="progressbar"
                                                     aria-valuenow="80"
                                                     aria-valuemin="0" aria-valuemax="100" style="width: 15%">
                                                    <span class="sr-only">15%</span>
                                                </div>
                                            </div>
                                        </div>
                                        <!-- end 1 -->
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>


            </div>
        </div>
    </div>
</div>
</body>
</html>

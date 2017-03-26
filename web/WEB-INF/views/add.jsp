<%--
  Created by IntelliJ IDEA.
  User: Niki
  Date: 2017-02-12
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Insole</title>
    <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link type="text/css" href="${pageContext.request.contextPath}/resources/index.css" rel="stylesheet" />
    <link type="text/css" href="${pageContext.request.contextPath}/resources/add.css" rel="stylesheet" />
</head>
<body>
<div class="main-block">

    <jsp:include page="headline.jsp"/>

    <div class="container">
        <div class="jumbotron" id="image">
        </div>

        <div class=content>

            <div class="panel panel-info" id="sell-div">
                <h3>Add sneakers to your collection.</h3>
                <form:form class="form-horizontal" role="form" action="/form" method="post" enctype="multipart/form-data">
                    <div class="form-group">
                        <form:label path="model">Model</form:label>
                        <form:select path= "model" class="form-control" id="modelSelect">
                           <option value="1">Asics</option>
                        </form:select>
                        <c:if test="${pageContext.request.method=='POST'}"><form:errors path="model" /></c:if>
                        <form:label path="size">Size</form:label>
                        <form:select path="size" class="form-control" id="sizeSelect">
                            <option value="1">US 5</option>
                        </form:select>
                        <c:if test="${pageContext.request.method=='POST'}"><form:errors path="size" /></c:if>
                        <div id="input-image-div">
                            <form:label path="file">Image input</form:label>
                            <form:input type="file" id="file" path="file"/>
                        </div>
                        <c:if test="${pageContext.request.method=='POST'}"><form:errors path="file" /></c:if><br>
                        <button type="submit" class="btn btn-default">Submit</button>
                    </div>
                </form:form>
            </div>

            <div class="menu">
                <jsp:include page="menu.jsp"/>
            </div>

        </div>
    </div>

</body>
</html>

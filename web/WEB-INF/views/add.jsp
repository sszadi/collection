<%--
  Created by IntelliJ IDEA.
  User: Niki
  Date: 2017-02-12
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html xmlns:th="http://www.thymeleaf.org">
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

    <div class="container">
        <div class="jumbotron" id="image">
        </div>

        <div class=content>

            <div class="panel panel-info" id="sell-div">
                <h3>Add sneakers to your collection.</h3>
                <!--/*@thymesVar id="sneaker" type="com.io2.model.Sneaker"*/-->
                <form enctype="multipart/form-data" method="post" th:object="${sneaker}" class="form-horizontal">
                    <div class="form-group">
                        <label for="modelSelect">Model</label>
                        <select class="form-control" id="modelSelect" th:field="*{brand}" name="brand" required>
                            <c:forEach items="${brands}" var="brand" varStatus="loop">
                                <option value="${brand.id}">${brand.name}</option>
                            </c:forEach>
                        </select>
                        </br>
                        <label for="sizeSelect">Size</label>
                        <!--/*@thymesVar id="sneaker" type="com.io2.model.Sneaker"*/-->
                        <select multiple required name="size" th:object="${sneaker}" th:field="*{size}"
                                class="form-control" id="sizeSelect">
                            <c:forEach items="${sizes}" var="size" varStatus="loop">
                                <option value="${size.key}">${size.value}</option>
                            </c:forEach>
                        </select>
                        </br>
                        <div class="input-group">
                            <span class="input-group-addon">$</span>
                            <input type="number" th:field="*{price}" name="price" class="form-control"
                                   aria-label="Amount (to the nearest dollar)" required>
                            <span class="input-group-addon">.00</span>
                        </div>
                        <div id="input-image-div">
                            <label for="file">Image input</label>
                            <input multiple type="file" id="file" name="file">
                        </div>
                        </br>
                        <button type="submit" class="btn btn-default">Submit</button>
                    </div>

                </form>

            </div>

            <div class="menu">
                <jsp:include page="menu.jsp"/>
            </div>

        </div>

    </div>


</div>

</body>
</html>

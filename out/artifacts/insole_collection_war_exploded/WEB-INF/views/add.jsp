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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css"/>
    <script src="${pageContext.request.contextPath}/resources/scripts/preview-image.js"></script>
    <script src="${pageContext.request.contextPath}/resources/scripts/edit.js"></script>
    <script src="${pageContext.request.contextPath}/resources/scripts/search.js"></script>

</head>
<body>
<div class="main-block">

    <jsp:include page="headline.jsp"/>

    <div class="container">
        <div class="jumbotron" id="image">
        </div>

        <div class=content>

            <div class="menu">
                <jsp:include page="menu.jsp"/>
            </div>

            <div class="panel panel-info" id="add-div">
                <h3>Add sneakers to your collection.</h3>
                <!--/*@thymesVar id="sneaker" type="com.io2.model.Sneaker"*/-->
                <form enctype="multipart/form-data" method="post" th:object="${sneaker}"
                      class="form-horizontal">
                    <div class="form-group" id="form-div">
                        <label for="inputSearch">Model</label>
                        <div class="input-group">
                            <input type="text" id="inputSearch" class="form-control" name="name"
                                   placeholder="Add to your WTB list...">

                            <span class="input-group-btn">
                        <button class="btn btn-default" type="submit">Submit</button>
                    </span>
                        </div>
                        <form:errors path="model" cssClass="error"/>
                        </br>
                        <label for="sizeSelect">Size</label>
                        <!--/*@thymesVar id="sneaker" type="com.io2.model.Sneaker"*/-->
                        <select multiple required="required" name="size" th:object="${sneaker}"
                                th:field="*{size}"
                                class="form-control" id="sizeSelect">
                            <c:forEach items="${sizes}" var="size" varStatus="loop">
                                <option value="${size.key}">${size.value}</option>
                            </c:forEach>
                        </select>
                        <form:errors path="size" cssClass="error"/>
                        </br>
                        <label for="priceSelect">Price</label>
                        <div class="input-group">
                            <span class="input-group-addon">$</span>
                            <input type="number" th:field="*{price}" min="1" name="price"
                                   class="form-control"
                                   id="priceSelect"
                                   aria-label="Amount (to the nearest dollar)" required="required"
                                   value="${sneakers.price}">
                            <form:errors path="price" cssClass="error"/>

                            <span class="input-group-addon">.00</span>

                        </div>
                    </div>

                    <div id="input-image-div">
                        <img src="http://localhost:9999/images/${sneakers.filename}" id="snk-image"
                             class="thumbnail img-responsive">

                        <input type="file" id="file-input" name="file">

                        </br>

                        <input type="hidden" value="${sneakers.id}" name="id"/>

                        <button type="submit" id="submit-btn" class="btn btn-default">Submit</button>
                    </div>
                </form>

            </div>


        </div>
    </div>
</div>

<c:if test="${not empty sneakers}">
    <script>
        var brand = '${sneakers.brand.id}';
        var size = '${sneakers.size}';
        edit(brand, size);
    </script>
</c:if>

</body>
</html>

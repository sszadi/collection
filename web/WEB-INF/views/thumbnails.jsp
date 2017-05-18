<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Title</title>
    <link type="text/css" href="${pageContext.request.contextPath}/resources/thumbnails.css" rel="stylesheet"/>
</head>
<body>

<c:forEach items="${collectionList.content}" var="sneakers" varStatus="loop">
    <c:if test="${loop.index % 3 == 0}">
        <c:set var="index" value="${loop.index}"/>
        <div class="row collection">
    </c:if>
    <div class="col-xs-6 col-md-4" id="thumbnail-div">
        <a href="/sneakers/id/${sneakers.id}" class="thumbnail snk-image">
            <img src="http://localhost:9999/images/${sneakers.filename}">
            <h5>${sneakers.brand.name}</h5>
            <p class="paragraph">${sneakers.price} USD</p>
        </a>
    </div>
    <c:if test="${loop.index != index and loop.index % 3 == 2}">
        </div>
    </c:if>
</c:forEach>

</body>
</html>

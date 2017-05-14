<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<c:forEach items="${collectionList}" var="sneakers" varStatus="loop">
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

<%--<nav aria-label="">--%>
    <%--<ul class="pager">--%>
        <%--<li><a href="/thumbnails/?=page=1">Previous</a></li>--%>
        <%--<li><a href="#">Next</a></li>--%>
    <%--</ul>--%>
<%--</nav>--%>
</body>
</html>

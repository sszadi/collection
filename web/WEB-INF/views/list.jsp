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
<html>
<html>
<head>
    <title>Insole</title>
    <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link type="text/css" href="${pageContext.request.contextPath}/resources/index.css" rel="stylesheet"/>
    <link type="text/css" href="${pageContext.request.contextPath}/resources/list.css" rel="stylesheet"/>
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"> </script>
    <script type="text/javascript" src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"> </script>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
    <script src="${pageContext.request.contextPath}/resources/scripts/search.js"></script>

</head>
<body>
<div class="main-block">

    <jsp:include page="headline.jsp"/>

    <div class="container">
        <div class="jumbotron" id="image">
        </div>

        <div class=content>

            <div class="list-div">
                <h4>Your WTB list.</h4>
                <div class="input-group">
                    <input type="text" id="input-search" class="form-control" placeholder="Add to your WTB list...">

                    <span class="input-group-btn">
                        <button class="btn btn-default" type="button">Submit</button>
                    </span>

                </div>
                <%--<div id="hints">--%>
                <%--<ul class="listbox" role="listbox">--%>
                <%--<li role="presentation">123</li>--%>
                <%--</ul>--%>
                <%--</div>--%>
            </div>

            <div class="panel panel-info list-div">

                <div class="list-group">
                    <a href="#" class="list-group-item">Dapibus ac facilisis in</a>
                    <a href="#" class="list-group-item">Morbi leo risus</a>
                    <a href="#" class="list-group-item">Porta ac consectetur ac</a>
                    <a href="#" class="list-group-item">Vestibulum at eros</a>
                </div>

            </div>

            <div class="menu">
                <jsp:include page="menu.jsp"/>
            </div>

        </div>

    </div>


</div>



</body>
</html>

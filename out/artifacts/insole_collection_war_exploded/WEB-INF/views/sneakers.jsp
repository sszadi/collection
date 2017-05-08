<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Insole</title>
    <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link type="text/css" href="${pageContext.request.contextPath}/resources/index.css" rel="stylesheet"/>
    <link type="text/css" href="${pageContext.request.contextPath}/resources/sneakers.css" rel="stylesheet"/>
    <link type="text/css" href="${pageContext.request.contextPath}/resources/collection.css" rel="stylesheet"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
            integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
            crossorigin="anonymous"></script>


</head>
<body>
<div class="main-block">

    <jsp:include page="headline.jsp"/>

    <div class="container">
        <div class="jumbotron" id="image">
        </div>

        <div class=content>

            <div class=" menu">
                <jsp:include page="menu.jsp"/>
            </div>

            <div class="panel panel-info" id="sneakers-div">
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-3 col-lg-3 " align="center">
                            <img src="http://localhost:9999/images/${sneakers.filename}"
                                 class="thumbnail img-responsive snk-image"></div>
                        <div class=" col-md-9 col-lg-9 ">
                            <table class="table table-user-information">
                                <tbody>
                                <tr>
                                    <td>Name:</td>
                                    <td>${sneakers.brand.name}</td>
                                </tr>
                                <tr>
                                    <td>Size:</td>
                                    <td>US ${sneakers.size}</td>
                                </tr>
                                <tr>
                                    <td>Price</td>
                                    <td>${sneakers.price} $</td>
                                </tr>
                                </tbody>
                            </table>

                        </div>
                    </div>

                    <span class="pull-right">
                            <a href="edit.html" data-original-title="Edit this user" data-toggle="tooltip" type="button"
                               class="btn btn-sm btn-info"><i class="glyphicon glyphicon-edit"></i></a>
                          <a type="button" data-toggle="modal" data-target="#myModal" class="btn btn-sm btn-danger"><i
                                  class="glyphicon glyphicon-remove"></i></a>

                    </span>

                    <div id="myModal" class="modal fade" tabindex="-1" role="dialog">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                            aria-hidden="true">&times;</span></button>
                                    <h4 class="modal-title">Are you sure?</h4>
                                </div>
                                <div class="modal-body">
                                    <p>Are you sure you want to delete these sneakers from your collection?</p>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">No</button>
                                    <a type="button" href="/sneakers/delete/id/${sneakers.id}" class="btn btn-primary">Yes</a>
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

<%--
  Created by IntelliJ IDEA.
  User: Niki
  Date: 2017-04-08
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>

<body>
<form class="navbar-form navbar-right" action="login" method="post"
      id="log-in-form">
    <div class="form-group">
        <label class="sr-only" for="email">Email address</label>
        <input type="email" class="form-control" id="email" name="email" placeholder="E-mail" required>
    </div>
    <div class="form-group">
        <label class="sr-only" for="password">Password</label>
        <input type="password" class="form-control" id="password" name="password" placeholder="Password"
               required>
    </div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <button type="submit" class="btn btn-default">Sign in</button>
</form>
</body>
</html>

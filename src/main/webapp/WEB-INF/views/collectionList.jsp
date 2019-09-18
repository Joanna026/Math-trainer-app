<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: joanna
  Date: 9/17/19
  Time: 1:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>DwaxDwa</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.5/css/bulma.min.css">
    <script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>
</head>
<body>

<%------HEADER------%>

<nav class="navbar is-dark" role="navigation" aria-label="main navigation">
    <div class="navbar-brand">
        <img src="/DwaxDwa-logo.png" alt="DwaxDwa" style="height: 80px">
    </div>

    <div id="navbarExampleTransparentExample" class="navbar-menu">
        <div class="navbar-end">
            <div class="navbar-item">
                <p class="control">
                    <a class="button is-danger is-medium" id="log-out">Wyloguj się</a>
                </p>
            </div>
        </div>
    </div>
</nav>


<%------BODY------%>

<section class="hero is-fullheight has-background-warning">
    <div class="hero-body">
        <div class="columns is-centered has-text-primary has-text-weight-semibold">
            <p style="font-size: 80px">
                Zbiory zadań
            </p>
        </div>

        <c:forEach items="${collections}" var="collection">

            <div class="box" style="height: 80%">
                <article class="media">
                    <div class="media-content">
                        <div class="content">
                            <p style="text-align: center">
                                <strong>${collection.name}</strong>
                            </p>
                        </div>
                        <nav class="level is-mobile">
                            <div class="level-left">
                                <form action="/student/collections" method="post">
                                    <input  type="submit" class="level-item button is-info"
                                            value ="Dodaj"/>
                                    <input type="hidden" name="collectionId" value="${collection.id}">
                                </form>
                            </div>
                        </nav>
                    </div>
                </article>
            </div>
        </c:forEach>

    </div>
</section>

<%------FOOTER------%>

<section class="has-background-warning" style="height: 30px">
    <div class="columns is-mobile is-centered has-background-warning">
        <a href="https://bulma.io" style="margin: 15px">
            <img src="/made-with-bulma.png" alt="Made with Bulma" width="194" height="36">
        </a>
    </div>
</section>
</body>
</html>

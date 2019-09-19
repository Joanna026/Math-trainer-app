<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: joanna
  Date: 9/19/19
  Time: 12:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <div class="navbar-menu">
        <div class="navbar-start">
            <a class="navbar-item has-text-danger" style="font-size: 30px; margin-left: 10%" href="/student/collections">
                Zbiory zadań
            </a>
        </div>
    </div>

    <div  class="navbar-menu">
        <div class="navbar-end">
            <div class="navbar-item">
                <p class="control">
                    <a href="/logout" class="button is-danger is-size-4 is-medium" >Wyloguj się</a>
                </p>
            </div>
        </div>
    </div>
</nav>


<%------BODY------%>

<section class="hero is-fullheight has-background-warning">
    <div class="hero-body">

        <c:forEach items="${collections}" var="collection">
            <div class="box" style="height: 80%">
                <article class="media">
                    <div class="media-content">
                        <div class="content">
                            <p style="text-align: center; font-size: larger">
                                <strong>${collection.collectionName}</strong>
                            </p>
                            <p>
                                ${collection.finishedAt}
                            </p>
                        </div>
                        <nav class="level is-mobile">
                            <div class="level-left">
                                <a class="level-item button is-info"
                                   href="/student/exercise?index=0&collectionId=${collection.collectionId}"
                                   style="margin-left: 30px; margin-right: 30px">Powtórz</a>
                            </div>
                        </nav>
                    </div>
                </article>
            </div>
        </c:forEach>

    </div>
</section>

<%------FOOTER------%>
<%@include file="footer.jsp"%>

</body>
</html>
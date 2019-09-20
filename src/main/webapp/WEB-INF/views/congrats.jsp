<%--
  Created by IntelliJ IDEA.
  User: joanna
  Date: 9/18/19
  Time: 10:02 AM
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
    <div class="navbar-menu">
        <div class="navbar-start">
            <a class="navbar-item has-text-danger" style="font-size: 30px; margin-left: 10%" href="/student/collections">
                Zbiory zadań
            </a>
            <a class="navbar-item has-text-info" style="font-size: 30px; margin-left: 10%" href="/student/learnt/all">
                Zaliczone testy
            </a>
            <a class="navbar-item has-text-primary" style="font-size: 30px; margin-left: 10%" href="/student/exercise/add">
                Dodaj zadanie
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
        <div class="container is-centered">
            <div class="columns is-centered has-text-primary has-text-weight-semibold">
                <p style="font-size: 150px">
                    Brawo!!!
                </p>
            </div>
        </div>
    </div>
</section>

<%------FOOTER------%>

<%@include file="footer.jsp"%>
</body>
</html>

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: joanna
  Date: 9/24/19
  Time: 5:43 PM
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

<nav class="navbar is-dark" role="navigation" aria-label="main navigation">
    <div class="navbar-brand">
        <a href="/home">
            <img src="/DwaxDwa-logo.png" alt="DwaxDwa" style="height: 80px">
        </a>
    </div>
    <div class="navbar-menu">
        <div class="navbar-start">

            <%------- STUDENT PANEL -------%>

            <sec:authorize access="hasRole('STUDENT')">
                <a class="navbar-item has-text-primary" style="font-size: 30px; margin-left: 10%"
                   href="/all/collections">
                    Zbiory zadań
                </a>
            </sec:authorize>

            <sec:authorize access="hasRole('STUDENT')">
                <a class="navbar-item has-text-primary" style="font-size: 30px; margin-left: 10%"
                   href="/student/learnt/all">
                    Zaliczone testy
                </a>
            </sec:authorize>


            <%------- ADMIN PANEL -------%>

            <sec:authorize access="hasRole('ADMIN')">
                <a class="navbar-item has-text-primary" style="font-size: 30px; margin-left: 10%"
                   href="/admin/exercise/add">
                    Dodaj zadanie
                </a>
            </sec:authorize>
        </div>
    </div>


    <div class="navbar-menu">
        <div class="navbar-end">
            <div class="navbar-item has-tekst-info" style="font-size: 30px; margin-right: 5px">
                <sec:authorize access="hasRole('ADMIN')"> Admin </sec:authorize>
                <sec:authorize access="hasRole('STUDENT')"> ${name} </sec:authorize>

            </div>
            <sec:authorize access="isAuthenticated()">
                <div class="navbar-item">
                    <p class="control">
                        <a href="/logout" class="button is-danger is-size-4 is-medium">Wyloguj się</a>
                    </p>
                </div>
            </sec:authorize>
            <sec:authorize access="isAnonymous()">
                <div class="navbar-item">
                    <p class="control">
                        <a href="/login" class="button is-danger is-size-4 is-medium">Zaloguj się</a>
                    </p>
                </div>
            </sec:authorize>
        </div>
    </div>
</nav>

</body>
</html>

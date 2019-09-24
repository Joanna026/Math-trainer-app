<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: joanna
  Date: 9/23/19
  Time: 9:19 AM
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
        <a href="/student/home">
            <img src="/DwaxDwa-logo.png" alt="DwaxDwa" style="height: 80px">
        </a>
    </div>
    <div class="navbar-menu">
        <div class="navbar-start">
            <a class="navbar-item has-text-primary" style="font-size: 30px; margin-left: 10%"
               href="/admin/exercise/add">
                Dodaj zadanie
            </a>
        </div>
    </div>


    <div class="navbar-menu">
        <div class="navbar-end">
            <div class="navbar-item has-tekst-info" style="font-size: 30px; margin-right: 5px">
                Admin
            </div>
            <div class="navbar-item">
                <p class="control">
                    <a href="/logout" class="button is-danger is-size-4 is-medium">Wyloguj się</a>
                </p>
            </div>
        </div>
    </div>
</nav>


<%------BODY------%>

<nav class="navbar has-background-warning" style="height: 200px">
    <p class="navbar-item has-text-centered has-text-dark is-size-2" style="font-weight: bold; margin-left: 10%">
        Klasy
    </p>
</nav>

<div class="has-background-warning" id="group-list" style="height: 1000px">

    <c:forEach items="${groups}" var="group">

        <article class="message is-dark" style="margin-right: 10%; margin-left: 10%">
            <div class="message-header">
                <p style="font-size: large">${group.name}</p>
                <button class="button is-dark is-small">
                    <i class="fas fa-angle-down" aria-hidden="true"></i>
                </button>
            </div>
            <div class="message-body">
                <aside class="menu">
                    <c:forEach items="${group.studentList}" var="student">
                        <div class="menu-list">
                            <a><strong class="name" style="text-underline: none">${student.name}</strong></a>
                               <div class="single-student">
                                    <c:forEach items="${student.learntCollections}" var="collection">
                                        <li style="text-underline: gray">${collection.collectionName}  ${collection.finishedAt}</li>
                                    </c:forEach>
                                </div>
                    </c:forEach>
                </aside>
            </div>
        </article>

    </c:forEach>

</div>

<%------FOOTER------%>

<%@include file="footer.jsp" %>

<%------JS SCRIPT------%>

<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="/groupList.js"></script>

</body>
</html>

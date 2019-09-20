<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%--
  Created by IntelliJ IDEA.
  User: joanna
  Date: 9/17/19
  Time: 4:30 PM
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
            <a class="navbar-item has-text-success" style="font-size: 30px; margin-left: 10%" href="/student/learnt/all">
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

<nav class="navbar has-background-warning" style="height: 200px">
    <p class="navbar-item has-text-centered has-text-dark is-size-2" style="font-weight: bold; margin-left: 45px">
        Moje zbiory zadań
    </p>
</nav>


        <div class="columns is-one-quarter is-multiline is-mobile has-background-warning" style="height: 1000px">


            <c:forEach items="${collections}" var="collection">

                <div class="box" style="height: 200px; margin-left: 30px; margin-right: 30px; margin-top: 30px">
                    <article class="media">
                        <div class="media-content">
                            <div class="content">
                                <p style="text-align: center; font-size: larger">
                                    <strong>${collection.name}</strong>
                                </p>
                            </div>
                            <nav class="level is-mobile">
                                <div class="level-item" style="margin-top: 60px">
                                    <form action="/student/home?collectionId=${collection.id}" method="post">
                                        <input  type="submit" class="button has-background-grey-lighter has-text-grey-darker"
                                                value ="Usuń"/>
                                    </form>
                                    <a class="button is-info"
                                       href='/student/exercise?index=0&collectionId=${collection.id}'
                                       style="margin-left: 30px; margin-right: 30px">Start</a>
                                </div>
                            </nav>
                        </div>
                    </article>
                </div>

            </c:forEach>
        </div>


<%------FOOTER------%>

<%@include file="footer.jsp"%>
</body>
</html>

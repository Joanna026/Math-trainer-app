<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: joanna
  Date: 9/17/19
  Time: 2:06 PM
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
    <style>
        input[type=number]::-webkit-inner-spin-button,
        input[type=number]::-webkit-outer-spin-button {
            -webkit-appearance: none;
            margin: 0;
            text-align: center;
        }
    </style>
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
            <div class="navbar-item has-tekst-info" style="font-size: 30px; margin-right: 5px">
                ${name}
            </div>
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
            <div class="columns is-centered has-text-info has-text-weight-semibold">
                <p style="font-size: 150px">
                    ${exercise.content}
                </p>
            </div>
            <div class="columns is-mobile is-centered">

                    <div>
                        <form action="${pageContext.request.contextPath}/student/exercise?index=${index}&collectionId=${collectionId}"
                              method="post" class="" id="exercise-solve">
                            <div class="field">
                                <p class="control has-icons-right">
                            <input class="input is-info is-large has-text-centered"
                                   style="font-size: 120px; width: 60%; height: 70%; margin-top: 6%; margin-left: 20%; text-align: center"
                                   type="text" name="answer" placeholder="wynik" autofocus="autofocus" id="user-answer">
<%--                                    <span class="icon is-large is-right has-text-success" style="margin-top: 10%">--%>
<%--                                        <i class="fas fa-check fa-3x"></i>--%>
<%--                                    </span>--%>
                                </p>
                            </div>
                            <input type="hidden" name="correctAnswer" value="${exercise.correctAnswer}" id="correct-answer"/>
                        </form>
                    </div>
            </div>
            <div class="column is-mobile">
               <p>Pozostało powtórzeń:</p>
                <p class="has-text-weight-bold is-size-2 has-text-danger">${results[index]}</p>
            </div>
        </div>
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


<%------JS SCRIPT------%>

<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="/groupList.js"></script>

</body>
</html>

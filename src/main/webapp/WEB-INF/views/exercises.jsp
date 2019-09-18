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
        <div class="container is-centered">
            <div class="columns is-centered has-text-primary has-text-weight-semibold">
                <p style="font-size: 150px">
                    ${exercise.content}
                </p>
            </div>
            <div class="columns is-mobile is-centered">
                <div class="field">
                    <div class="control has-icons-right" style="display: inline-block">
                        <form action="${pageContext.request.contextPath}/student/exercise?index=${index}&collectionId=${collectionId}"
                              method="post">
                            <input class="input is-primary is-large has-text-centered"
                                   style="font-size: 120px; width: 60%; height: 70%; margin-top: 6%; margin-left: 20%; text-align: center"
                                   type="text" name="answer" placeholder="wynik" autofocus="autofocus"/>
                            <input type="hidden" name="correctAnswer" value="${exercise.correctAnswer}"/>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>


<%--<div>--%>
<%--    <form action="${pageContext.request.contextPath}/student/exercise?index=${index}&collectionId=${collectionId}"  method="post">--%>
<%--        <input name ="answer" type="text"/><br/>--%>
<%--&lt;%&ndash;        <input type="hidden" name="collectionId" value="${collectionId}"/>&ndash;%&gt;--%>
<%--&lt;%&ndash;        <input type="hidden" name="index" value="${index}"/>&ndash;%&gt;--%>
<%--        <input type="hidden" name="correctAnswer" value="${exercise.correctAnswer}"/>--%>
<%--        <input type="submit" value="ok"/>--%>
<%--    </form>--%>
<%--</div>--%>

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

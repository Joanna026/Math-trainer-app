<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: joanna
  Date: 9/19/19
  Time: 8:24 PM
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
        <img src="/DwaxDwa-logo.png" alt="DwaxDwa" style="height: 80px">
    </div>
    <div class="navbar-menu">
        <div class="navbar-start">
            <a class="navbar-item has-text-danger" style="font-size: 30px; margin-left: 10%"
               href="/student/collections">
                Zbiory zadań
            </a>
            <a class="navbar-item has-text-success" style="font-size: 30px; margin-left: 10%"
               href="/student/learnt/all">
                Nauczone
            </a>
        </div>
    </div>

    <div class="navbar-menu">
        <div class="navbar-end">
            <div class="navbar-item">
                <p class="control">
                    <a href="/logout" class="button is-danger is-size-4 is-medium">Wyloguj się</a>
                </p>
            </div>
        </div>
    </div>
</nav>


<%------BODY------%>

<section class="hero is-fullheight has-background-warning">
    <div class="hero-body">
        <div class="container">
            <div class="columns is-centered">
                <article class="card is-rounded">
                    <div class="card-content" style="margin: 15px">
                        <h1 class="title">
                            <img src="/DwaxDwa-logo.png"
                                 alt="DwaxDwa" width="200">
                        </h1>
                        <form:form method="post" modelAttribute="collectionDto">
                        <div class="field">
                            <p class="control" style="margin-bottom: 20px">
                                <form:input path="name" class="input is-medium is-danger" type="text"
                                            placeholder="Nazwa"/>
                            </p>
                        </div>
                        <div class="field">
                            <div class="select is-multiple" style="margin-bottom: 20px">
                                <select multiple size="4" name="exerciseId">
                                    <c:forEach items="${exercisesList}" var="exercise">
                                        <option value="${exercise.id}">${exercise.content}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="buttons is-centered">
                            <p class="control" style="margin-bottom: 10px">
                                <button class="button is-info is-medium is-centered">
                                    Dodaj
                                </button>
                            </p>
                        </div>
                    </div>
                    </form:form>
                </article>
            </div>
        </div>
    </div>
</section>


<%------FOOTER------%>

<%@include file="footer.jsp" %>
</body>
</html>
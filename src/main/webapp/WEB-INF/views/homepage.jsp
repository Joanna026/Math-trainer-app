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

<%@include file="header.jsp" %>

<%------BODY------%>

<%------- STUDENT PAGE -------%>

<sec:authorize access="hasRole('STUDENT')">
    <nav class="navbar has-background-warning" style="height: 200px">
        <p class="navbar-item has-text-centered has-text-dark is-size-2" style="font-weight: bold; margin-left: 45px">
            Moje zbiory zadań
        </p>
    </nav>

    <div class="columns is-one-quarter is-multiline is-mobile has-background-warning" style="height: 1000px">

        <c:forEach items="${collections}" var="collection">

            <div class="box"
                 style="height: 200px; width: 170px; margin-left: 30px; margin-right: 30px; margin-top: 30px">
                <article class="media">
                    <div class="media-content">
                        <div class="content">
                            <p style="text-align: center; font-size: larger">
                                <strong>${collection.name}</strong>
                            </p>
                        </div>
                        <nav class="level is-mobile">
                            <div class="level-item" style="margin-top: 60px">
                                <div class="buttons is-centered">
                                    <form action="/student/home?collectionId=${collection.id}" method="post">
                                        <input type="submit"
                                               class="button has-background-grey-lighter has-text-grey-darker"
                                               value="Usuń"/>
                                    </form>
                                    <a class="button is-info"
                                       href='/student/exercise?index=0&collectionId=${collection.id}'
                                       style="margin-left: 5px">Start</a>
                                </div>
                            </div>
                        </nav>
                    </div>
                </article>
            </div>
        </c:forEach>
    </div>
</sec:authorize>


<%------- ADMIN PAGE -------%>

<sec:authorize access="hasRole('ADMIN')">
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
                                    <li style="text-underline: gray">${collection.collectionName} ${collection.finishedAt}</li>
                                </c:forEach>
                            </div>
                            </c:forEach>
                    </aside>
                </div>
            </article>

        </c:forEach>

    </div>
</sec:authorize>

<%------FOOTER------%>

<%@include file="footer.jsp" %>

<%------JS SCRIPT------%>

<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="/DwaxDwa-events.js"></script>

</body>
</html>

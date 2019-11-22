<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><spring:message code="app.title"/></title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.5/css/bulma.min.css">
    <script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>
</head>
<body>

<%------HEADER------%>

<%@include file="header.jsp" %>

<%------BODY------%>

<nav class="navbar has-background-warning" style="height: 200px">
    <p class="navbar-item has-text-centered has-text-dark is-size-2" style="font-weight: bold; margin-left: 45px">
        <spring:message code="my.collections.message"/>
    </p>
</nav>

<div class="columns is-one-quarter is-multiline is-mobile has-background-warning" style="height: 1000px">

    <c:forEach items="${collections}" var="collection">

        <div class="box" style="height: 200px; width: 170px; margin-left: 30px; margin-right: 30px; margin-top: 30px">
            <article class="media">
                <div class="media-content">
                    <div class="content">
                        <p style="text-align: center">
                            <strong>${collection.name}</strong>
                        </p>
                    </div>
                    <nav class="level is-mobile">
                        <div class="level-item" style="margin-top: 60px">
                            <form action="/admin/set" method="post">
                                <div class="buttons is-centered">
                                    <input type="submit" class="level-item button is-info"
                                           value="<spring:message code="set.message"/>"/>
                                    <input type="hidden" name="collectionId" value="${collection.id}">
                                    <input type="hidden" name="groupId" value="${groupId}">
                                </div>
                            </form>
                        </div>
                    </nav>
                </div>
            </article>
        </div>
    </c:forEach>
</div>

<%------FOOTER------%>

<%@include file="footer.jsp" %>
</body>
</html>

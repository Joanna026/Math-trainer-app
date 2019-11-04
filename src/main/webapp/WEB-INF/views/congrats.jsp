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
    <title><spring:message code="app.title"/></title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.5/css/bulma.min.css">
    <script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>
</head>
<body>

<%------HEADER------%>

<%@include file="header.jsp" %>


<%------BODY------%>

<section class="hero is-fullheight has-background-warning">
    <div class="hero-body">
        <div class="container is-centered">
            <div class="columns is-centered has-text-info has-text-weight-semibold">
                <p style="font-size: 150px">
                    <spring:message code="congrats.message"/>
                </p>
            </div>
        </div>
    </div>
</section>

<%------FOOTER------%>

<%@include file="footer.jsp"%>
</body>
</html>

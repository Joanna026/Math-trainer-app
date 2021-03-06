<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: joanna
  Date: 9/19/19
  Time: 5:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" type="image/x-icon" href="/title-icon.png" />
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
        <div class="container">
            <div class="columns is-centered">
                <article class="card is-rounded">
                    <div class="card-content" style="margin: 15px">
                        <h1 class="title">
                            <img src="/DwaxDwa-logo.png"
                                 alt="DwaxDwa" width="200">
                        </h1>
                        <form:form method="post" modelAttribute="exerciseDTO">
                        <div class="field">
                            <p class="control" style="margin-bottom: 20px">
                                <spring:message code="title.placeholder" var="titlePlaceholder"/>
                                <form:input path="title" class="input is-medium is-danger" type="text"
                                            placeholder="${titlePlaceholder}"/>
                            </p>
                        </div>
                        <div class="field">
                            <p class="control" style="margin-bottom: 20px">
                                <spring:message code="content.placeholder" var="contentPlaceholder"/>
                                <form:input path="content" class="input is-medium is-success" type="text"
                                            placeholder="${contentPlaceholder}"/>
                            </p>
                        </div>
                        <div class="field">
                            <p class="control" style="margin-bottom: 20px">
                                <spring:message code="open.message"/> <form:checkbox path="type" value="true"/>
                                <spring:message code="close.message"/> <form:checkbox path="type" value="false"/>
                            </p>
                        </div>
                        <div class="field">
                            <p class="control" style="margin-bottom: 20px">
                                <spring:message code="correct.placeholder" var="correctPlaceholder"/>
                                <form:input path="correctAnswer" class="input is-medium is-info" type="text"
                                            placeholder="${correctPlaceholder}"/>
                            </p>
                        </div>
                        <div class="field">
                            <p class="control" style="margin-bottom: 20px">
                                <spring:message code="repetitions.placeholder" var="repetitionsPlaceholder"/>
                                <form:input path="repetitionNumber" class="input is-medium is-primary" type="number"
                                            placeholder="${repetitionsPlaceholder}"/>
                            </p>
                        </div>
                        <div class="buttons is-centered">
                            <p class="control" style="margin-bottom: 10px">
                                <button class="button is-info is-medium is-centered">
                                    <spring:message code="add.message"/>
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

<%@include file="footer.jsp"%>
</body>
</html>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: joanna
  Date: 9/17/19
  Time: 12:33 PM
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
        <div class="navbar-end">
            <div class="navbar-item">
                <p class="control">
                    <a href="/login" class="button is-success is-size-4 is-medium">Zaloguj się</a>
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
                        <form:form method="post" modelAttribute="user">
                        <div class="field">
                            <p class="control has-icons-left" style="margin-bottom: 20px">
                                <form:input path="username" class="input is-medium is-danger" type="text"
                                            placeholder="Login"/>
                                <span class="icon is-small is-left">
    <i class="fas fa-user"></i>
    </span>
                            </p>
                        </div>
                        <div class="field">
                            <p class="control has-icons-left" style="margin-bottom: 20px">
                                <form:input path="name" class="input is-medium is-danger" type="text" id="name"
                                            placeholder="Imię"/>
                                <span class="icon is-small is-left">
    <i class="fas fa-user"></i>
    </span>
                            </p>
                        </div>
<%--                        <div class="field">--%>
<%--                            <p class="control has-icons-left" style="margin-bottom: 20px">--%>
<%--                                <form:input path="group" class="input is-medium is-info" type="text" id="class"--%>
<%--                                            placeholder="Klasa"/>--%>
<%--                                <span class="icon is-small is-left">--%>
<%--    <i class="fas fa-home"></i>--%>
<%--    </span>--%>
<%--                            </p>--%>
<%--                        </div>--%>
                        <div class="field">
                            <p class="control has-icons-left" style="margin-bottom: 20px">
                                <form:input path="email" class="input is-medium is-primary" type="email" id="email"
                                            placeholder="Email"/>
                                <span class="icon is-small is-left">
        <i class="fas fa-envelope"></i>
        </span>
                            </p>
                        </div>
                        <div class="field">
                            <p class="control has-icons-left" style="margin-bottom: 20px">
                                <form:password path="password" class="input is-medium is-danger"
                                               placeholder="Hasło"/>
                                <span class="icon is-small is-left">
    <i class="fas fa-lock"></i>
    </span>
                            </p>
                        </div>
<%--                        <div class="field">--%>
<%--                            <p class="control has-icons-left" style="margin-bottom: 20px">--%>
<%--                                <form:password path="passwordRepeat" class="input is-medium is-success" type="password"--%>
<%--                                               id="password-repeat"--%>
<%--                                               placeholder="Powtórz hasło"/>--%>
<%--                                <span class="icon is-small is-left">--%>
<%--    <i class="fas fa-lock"></i>--%>
<%--    </span>--%>
<%--                            </p>--%>
<%--                        </div>--%>
                        <div class="buttons has-addons is-centered">
                            <p class="control" style="margin-bottom: 10px">
                                <button class="button is-info is-medium has-addons is-centered">
                                    <i class="fa fa-user" style="margin-right: 5px"></i>
                                    Załóż konto
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

<section class="has-background-warning" style="height: 30px">
    <div class="columns is-mobile is-centered has-background-warning">
        <a href="https://bulma.io" style="margin: 15px">
            <img src="/made-with-bulma.png" alt="Made with Bulma" width="194" height="36">
        </a>
    </div>
</section>


</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: joanna
  Date: 9/15/19
  Time: 10:05 AM
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
        <img src="/DwaxDwa-logo.png" alt="DwaxDwa" style="height: 80px">
    </div>
    <div  class="navbar-menu">
        <div class="navbar-end">
            <div class="navbar-item">
                <p class="control">
                    <a href="/user/add" class="button is-danger is-size-4 is-medium">Załóż konto</a>
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
                        <form name='f' action="login" method='POST'>
                            <div class="field">
                                <p class="control has-icons-left" style="margin-bottom: 20px">
                                    <input class="input is-medium is-primary" type="text" name='username'
                                           placeholder="Login">
                                    <span class="icon is-small is-left">
                                <i class="fa fa-user"></i>
                            </span>
                                </p>
                            </div>
                            <div class="field">
                                <p class="control has-icons-left" style="margin-bottom: 20px">
                                    <input class="input is-medium is-danger" type="password" name='password'
                                           placeholder="Hasło">
                                    <span class="icon is-small is-left">
                                <i class="fas fa-lock"></i>
                            </span>
                                </p>
                            </div>
                            <p class="control" style="margin-bottom: 10px">
                            <div class="buttons is-centered">
                                <button type="submit" class="button is-info is-medium is-centered"
                                        id="log-in">
                                    Zaloguj
                                </button>
                            </div>
                        </form>
                    </div>
                </article>
            </div>
        </div>
    </div>
</section>

<%------FOOTER------%>
<%@include file="footer.jsp"%>

</body>
</html>
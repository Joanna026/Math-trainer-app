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
    <title>Math Coach</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.5/css/bulma.min.css">
    <script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>
</head>
<body>

<%------HEADER------%>

<nav class="navbar is-dark" role="navigation" aria-label="main navigation">
    <div class="navbar-brand">
        <img src="/DwaxDwa-logo.png" alt="DwaxDwa" style="height: 80px">

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
                                <i class="fas fa-envelope"></i>
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
                            <div class="buttons has-addons is-centered">
                                <button type="submit" class="button is-info is-medium has-addons is-centered"
                                        id="log-in">
                                    <i class="fa fa-user" style="margin-right: 5px"></i>
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

<section class="has-background-warning" style="height: 30px">
    <div class="columns is-mobile is-centered has-background-warning">
        <a href="https://bulma.io" style="margin: 15px">
            <img src="/made-with-bulma.png" alt="Made with Bulma" width="194" height="36">
        </a>
    </div>
</section>

</body>
</html>
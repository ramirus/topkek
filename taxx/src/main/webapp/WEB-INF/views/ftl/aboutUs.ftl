<#ftl encoding="UTF-8">
<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta http-equiv="Content-type" content="text/html;charset=UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <base href="/">
    <link href="<@spring.url '/static/css/bootstrap.min.css'/>" type="text/css" rel="stylesheet">
    <link href="<@spring.url '/static/css/aboutus.css'/>" type="text/css" rel="stylesheet">
    <title>About us</title>
</head>
<body background="https://www.tomswallpapers.com/pic/201503/1366x768/tomswallpapers.com-18974.jpg">
<nav class="navbar navbar-inverse navbar-static-top">
    <div class="container">
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-left">
                <li><a href="">Главная</a></li>
                <li><a href="/taxx_war/rating">Отзывы</a></li>
                <li class="active"><a href="/taxx_war/aboutUs">О нас</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <#if loged??>
                    <li><a href="/taxx_war/profile">Профиль</a></li>
                    <li><a href="/logout">Выход</a></li>
                </#if>
                <li><a href="/taxx_war/login">Вход</a></li>
                <li><a href="/taxx_war/signUp">Регистрация водителя</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="text-center">
    <div id="fh5co-main">
        <div class="fh5co-tab-wrap">
            <div class="fh5co-tab-content active" data-content="1">
                <div class="fh5co-content-inner text-center">
                    <div class="row row-bottom-padded-sm">
                        <div class="col-md-12">
                            <figure>
                                Фото разработчика
                            </figure>
                            <h1>Имя</h1>
                            <p>Краткая информация о разработчике</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" rel="script"
        type="text/javascript"></script>
<script src="/static/js/bootstrap.min.js" rel="script" type="text/javascript"></script>
</body>
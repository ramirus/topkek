<#ftl>
<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <base href="/">
    <link href="<@spring.url '/static/css/bootstrap.min.css'/>" type="text/css" rel="stylesheet">
    <link href="<@spring.url '/static/css/aboutus.css'/>" type="text/css" rel="stylesheet">
    <title>Profile</title>
    <style>
        body {
            font-family: "Source Sans Pro", Arial, sans-serif;
            font-weight: 300;
            font-size: 20px;
            line-height: 1.5;
        }
    </style>
</head>
<body background="https://www.tomswallpapers.com/pic/201503/1366x768/tomswallpapers.com-18974.jpg" onload="getData()">
<nav class="navbar navbar-inverse navbar-static-top">
    <div class="container">
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-left">
                <li><a onclick="location.href='/main'">Главная</a></li>
                <li class="active"><a onclick="location.href='/rating'">Отзывы</a></li>
                <li><a onclick="location.href='/aboutUs'">О нас</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a class="active" onclick="location.href='/profile'">Профиль</a></li>
                <li><a onclick="location.href='/logout'">Выход</a></li>
                <li><a onclick="location.href='/login'">Вход</a></li>
                <li><a onclick="location.href='/signUp'">Регистрация водителя</a></li>
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
                            <figure>Фото водителя</figure>
                            <figure>Phone number:"${driver.phoneNumber}"</figure>
                            <h1>"${driver.firstName}"</h1>
                            <h1>"${driver.lastName}"</h1>
                            <p>Ваш заработок за сегодня:"${sum}"</p>";
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="/static/js/bootstrap.min.js" rel="script" type="text/javascript"></script>
</body>
</html>
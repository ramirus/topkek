<#ftl encoding="UTF-8">
<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <base href="/">
    <link type="text/css" href="<@spring.url '/static/css/bootstrap.min.css'/>" rel="stylesheet">
    <link type="text/css" href="<@spring.url '/static/css/res.css'/>" rel="stylesheet">
    <link type="text/css" href="<@spring.url '/static/css/style.css'/>" rel="stylesheet">
    <title>Comments</title>
    <style>
        #commentForm {
            height: 24%;
            width: 50%;
            border: 2px solid #ccc;
            border-radius: 5px;
            background-color: #eee;
            margin-left: 25%;
            display: table;
        }

        .cont {
            border: 2px solid #ccc;
            background-color: #eee;
            border-radius: 5px;
            width: 50%;
            left: 25%;
            padding: 16px;
            margin: 16px 25%;
        }

        .cont::after {
            content: "";
            clear: both;
            display: table;
        }

        .cont span {
            font-size: 20px;
            margin-right: 15px;
        }

        body {
            font-family: "Source Sans Pro", Arial, sans-serif;
            font-weight: 300;
            font-size: 20px;
            line-height: 1.5;
        }
    </style>
</head>
<body background="https://www.tomswallpapers.com/pic/201503/1366x768/tomswallpapers.com-18974.jpg">
<nav class="navbar navbar-inverse navbar-static-top">
    <div class="container">
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-left">
                <li><a href="">Главная</a></li>
                <li class="active"><a href="/taxx_war/rating">Отзывы</a></li>
                <li><a href="/taxx_war/aboutUs">О нас</a></li>
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
<div>
    <form method="post" id="commentForm">
        <label>Ваш номер телефона:</label>
        <br>
        <input type="text" name="phone" placeholder="Телефон" required>
        <br>
        <label>Отзыв:</label>
        <br>
        <textarea name="comment" placeholder="Отзыв" required></textarea>
        <br>
        <label>Оценка поездки:</label>
        <div>
            <input type="radio" name="ratingCount" value="1">
            <label>1</label>
            <input type="radio" name="ratingCount" value="2">
            <label>2</label>
            <input type="radio" name="ratingCount" value="3">
            <label>3</label>
            <input type="radio" name="ratingCount" value="4">
            <label>4</label>
            <input type="radio" name="ratingCount" value="5">
            <label>5</label>
        </div>
        <br>
        <input type="submit" class="btn-primary" value="Оставить отзыв"/>
    </form>
</div>
<div class="cont">
    <#if comments??>
        <#list comments as comment>
            <p><span>Номер телефона:${comment.clientphone}</span></p>
            <p>Комментарий:${comment.comment}</p>
            <p>Оценка:${comment.ratingcount}</p>
        </#list>
    </#if>
</div>
</body>
</html>
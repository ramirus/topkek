<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/res.css">
    <link rel="stylesheet" href="css/style.css">
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
<body background="https://www.tomswallpapers.com/pic/201503/1366x768/tomswallpapers.com-18974.jpg"
      onload="getAllRatC()">
<nav class="navbar navbar-inverse navbar-static-top">
    <div class="container">
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-left">
                <li><a onclick="location.href='/main'">Главная</a></li>
                <li class="active"><a onclick="location.href='/rating'">Отзывы</a></li>
                <li><a onclick="location.href='/aboutUs'">О нас</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a onclick="location.href='/signIn'">Вход</a></li>
                <li><a onclick="location.href='/regDriver'">Регистрация водителя</a></li>
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
<div id="comments">
</div>
</body>
<script>
    function getAllRatC() {
        var data = JSON.parse('${json}');
        console.log(data);
        if (data.length !==0) {
            let content = '<div class="cont">';
            for (let i = 0; i < data.length; i++) {
                content += '<p><span>Phone number:' + data[i].clientPhone + '</span>Comment:' + data[i].comment + '</p><p>Rating:' + data[i].ratingCount + '</p>';
            }
            content += '</div>';
            let elem = document.getElementById("comments");
            elem.innerHTML = content;
        }
    }
</script>
</html>
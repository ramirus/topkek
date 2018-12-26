<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/aboutus.css" rel="stylesheet">
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
                <li><a onclick="location.href='/rating'">Отзывы</a></li>
                <li><a onclick="location.href='/aboutUs'">О нас</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="active"><a onclick="location.href='/profile'">Профиль</a></li>
                <li><a onclick="location.href='/'">Выход</a></li>
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
                            <div id="here">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script>
    function getData() {
        console.log('${json}');
        let data = JSON.parse('${json}');
        console.log(data);
        let content= "<figure>А еще здесь можно было бы добавить аву, но зачем?</figure><figure>Phone number:"+data[2]+ "</figure><h1>"+data[0]+' '+data[1]+"</h1><p>Ваш заработок за сегодня:"+data[3]+"</p>";
        let el=document.getElementById('here');
        el.innerHTML=content;
    }
</script>
</body>
</html>
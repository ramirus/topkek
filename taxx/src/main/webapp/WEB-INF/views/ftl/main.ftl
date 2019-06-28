<#ftl encoding="UTF-8">
<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-type" content="text/html;charset=UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <base href="/">
    <link href="<@spring.url '/static/css/bootstrap.min.css'/>" type="text/css" rel="stylesheet">
    <link href="<@spring.url  '/static/css/bootstrap.css'/> " type="text/css" rel="stylesheet">
    <title>Main titale</title>
    <script src="https://api-maps.yandex.ru/2.1/?lang=ru_RU&amp;apikey=0b64ce1c-2962-4ec5-9ef0-80b10a60b27c"
            type="text/javascript"></script>
    <script rel="script" src="https://yandex.st/jquery/2.2.3/jquery.min.js" type="text/javascript"></script>
    <style>
        #map {
            height: 400px;
            width: 750px;
        }

        body {
            font-family: "Source Sans Pro", Arial, sans-serif;
            font-weight: 300;
            font-size: 20px;
            line-height: 1.5;
        }

        #order {
            width: 750px;
            height: 80%;
            margin-left: 25%;
            background-color: whitesmoke;
        }
    </style>
</head>
<body background="https://www.tomswallpapers.com/pic/201503/1366x768/tomswallpapers.com-18974.jpg">
<nav class="navbar navbar-inverse navbar-static-top">
    <div class="container">
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-left">
                <li class="active"><a href="">Главная</a></li>
                <li><a href="/taxx_war/rating">Отзывы</a></li>
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
    <form method="post" accept-charset="UTF-8" id="order">
        <div id="map"></div>
        <label>Ваш номер телефона:</label>
        <input type="text" name="phone" placeholder="Телефон" id="phone" required>
        <br>
        <label>Комментарий для водителя</label>
        <textarea name="comment" placeholder="Комментарий" id="comment"></textarea>
        <input id="start" name="start" type="hidden"/>
        <input id="end" name="end" type="hidden"/>
        <input id="pr" name="price" type="hidden">
        <input type="submit" class="btn-primary" value="Заказать такси" id="sub"/>
    </form>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" rel="script"
        type="text/javascript"></script>
<script src="/static/js/bootstrap.min.js" rel="script" type="text/javascript"></script>
<script src="/static/js/bootstrap.js" rel="script" type="text/javascript"></script>
<script>
    ymaps.ready(function () {
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(function (position) {
                var latitude;
                var longitude;
                var loc;
                var DELIVERY_TARIFF = 20,
                    MINIMUM_COST = 110;
                latitude = '' + position.coords.latitude;
                longitude = '' + position.coords.longitude;
                loc = latitude + ',' + longitude;
                ymaps.ready(function () {
                    var myMap = new ymaps.Map('map', {
                        center: [latitude, longitude],
                        zoom: 11,
                        controls: ['routePanelControl', 'zoomControl']
                    });
                    var control = myMap.controls.get('routePanelControl');
                    control.options.set({
                        maxWidth: '240px',
                        float: 'right'
                    });
                    control.routePanel.state.set({
                        type: 'masstransit',
                        fromEnabled: false,
                        from: loc,
                        toEnabled: true
                    });
                    control.routePanel.options.set({
                        allowSwitch: false,
                        reverseGeocoding: true,
                        types: {auto: true}
                    });

                    function calculate(routeLength) {
                        return Math.max(routeLength * DELIVERY_TARIFF, MINIMUM_COST);
                    }

                    control.routePanel.getRouteAsync().then(function (route) {
                        route.model.setParams({results: 1}, true);
                        route.model.events.add('requestsuccess', function () {
                            var activeRoute = route.getActiveRoute();
                            if (activeRoute) {
                                document.getElementById('start').value = document.getElementsByClassName('ymaps-2-1-73-route-panel-input__input')[0].value;
                                document.getElementById('end').value = document.getElementsByClassName('ymaps-2-1-73-route-panel-input__input')[1].value;
                                console.log(document.getElementById('start').value + " " + document.getElementById('end').value);
                                var length = route.getActiveRoute().properties.get("distance"),
                                    price = calculate(Math.round(length.value / 1000)),
                                    balloonContentLayout = ymaps.templateLayoutFactory.createClass(
                                        '<span>Расстояние: ' + length.text + '.</span><br/>' +
                                        '<span style="font-weight: bold; font-style: italic" id="pricer">Стоимость поездки: ' + price + ' р.</span>');
                                document.getElementById("pr").value = price;
                                route.options.set('routeBalloonContentLayout', balloonContentLayout);
                                activeRoute.balloon.open();
                            }
                        });
                    });
                });
            });
        } else {
            alert("Geolocation API не поддерживается в вашем браузере");
        }
    });
    document.getElementById('sub').onclick = function () {
        console.log("пока все ок");
        var price = document.getElementById("pricer").innerText.split(' ')[2],
            phone = document.getElementById('phone').value,
            comment = document.getElementById('comment').value,
            startPoint = document.getElementById('start').value,
            endPoint = document.getElementById('end').value;
        if (phone !== null && comment !== null && (startPoint !== null || startPoint !== undefined) && (endPoint !== null || endPoint !== undefined) && price !== null) {
            alert("Машина уже в пути" + "Цена:" + price);
        }
    };
</script>
</body>
</html>
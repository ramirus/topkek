<#ftl>
<#import "/spring.ftl" as spring/>
<!DOCTYPE HTML>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <base href="/">
    <link rel="stylesheet" type="text/css" href="<@spring.url '/static/css/reset.css'/>"/>
    <link rel="stylesheet" type="text/css" href="<@spring.url '/static/css/animate.css'/>">
    <link rel="stylesheet" type="text/css" href="<@spring.url '/static/css/styles.css'/>">
     <style>
        #regCont {
            position: relative;
            width: 340px;
            height: 580px;
            top: 25%;
            left: 50%;
            margin-top: -140px;
            margin-left: -170px;
            background: #fff;
            border-radius: 3px;
            border: 1px solid #ccc;
            box-shadow: 0 1px 2px rgba(0, 0, 0, .1);
            -webkit-animation-name: bounceIn;
            -webkit-animation-fill-mode: both;
            -webkit-animation-duration: 1s;
            -webkit-animation-iteration-count: 1;
            -webkit-animation-timing-function: linear;
            -moz-animation-name: bounceIn;
            -moz-animation-fill-mode: both;
            -moz-animation-duration: 1s;
            -moz-animation-iteration-count: 1;
            -moz-animation-timing-function: linear;
            animation-name: bounceIn;
            animation-fill-mode: both;
            animation-duration: 1s;
            animation-iteration-count: 1;
            animation-timing-function: linear;
        }
        body {
            font-family: "Source Sans Pro", Arial, sans-serif;
            font-weight: 300;
            font-size: 20px;
            line-height: 1.5;
        }
    </style>
    <title>Registration</title>
</head>
<body>
<div id="regCont">
    <form method="post">
        <label for="firstname">First name:</label>
        <input type="name" id="firstname" name="firstname" required>
        <label for="lastname">Last name:</label>
        <input type="name" id="lastname" name="lastname" required>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>
        <label for="phone">Phone number:</label>
        <input type="tel" id="phone" name="phone" required>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
        <label>Do you have a car?</label>
        <p><label>
                <input type="radio" name="haveCar" value="no" required>
            </label>No</p>
        <p><label>
                <input type="radio" name="haveCar" value="yes" required>
            </label>Yes</p>
        <div id="lower">
            <input type="submit" formmethod="post" value="Sign Up">
            <input type="submit" onclick="location.href='/main'" value="Main page">
        </div>
    </form>
</div>
</body>
</html>

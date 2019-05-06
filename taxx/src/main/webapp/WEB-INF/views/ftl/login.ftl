<#ftl>
<#import "/spring.ftl" as spring/>
<!DOCTYPE HTML>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <base href="/">
    <link rel="stylesheet" type="text/css" href="<@spring.url '/static/css/reset.css'/>"/>
    <link rel="stylesheet" type="text/css" href="<@spring.url '/static/css/animate.css'/>">
    <link rel="stylesheet" type="text/css" href="<@spring.url '/static/css/styles.css'/>">
    <title>Login</title>
</head>
<body>
<div id="container">
    <form method="post">
        <#if error??>
            <h1>Email or password not correct</h1>
        </#if>
        <label for="email">Email</label>
        <input type="name" name="email" id="email"/>
        <br/>
        <label for="password">Password</label>
        <input type="password" name="password" id="password"/>
        <input type="submit" name="submit" value="Enter"/>
    </form>
</div>
</body>
</html>
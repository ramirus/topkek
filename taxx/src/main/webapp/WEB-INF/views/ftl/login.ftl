<#import "/spring.ftl" as spring/>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="<@spring.url'/static/css/reset.css'/>">
    <link rel="stylesheet" href="<@spring.url'/static/css/animate.css'/>">
    <link rel="stylesheet" href="<@spring.url'/static/css/styles.css'/>">
    <title>Login</title>
</head>
<body>
<div id="container">
    <form action="/profile" method="post">
        <label for="email">Email</label>
        <input type="text" name="email" id="email"/>
        <br/>
        <label for="password">Password</label>
        <input type="password" name="password" id="password"/>
        <input type="submit" name="submit"/>
    </form>
</div>
</body>
</html>
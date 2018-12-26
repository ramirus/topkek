<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/animate.css">
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
<div id="container">
    <form method="post">
        <label for="email">Email:</label>
        <input type="name" id="email" name="email" required>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
        <div id="lower">
            <input type="submit" formmethod="post" value="Sign In">
            <input type="submit" onclick="location.href='/main'" value="Главная">
        </div>
    </form>
</div>
</body>
</html>

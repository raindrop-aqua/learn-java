<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ja">
<head>
    <title>はじめての Servlet と JSP</title>
</head>
<body>
<form action="/hint1" method="get">
    <p>名前を入力してください</p>
    <input type="text" name="myName" id="myName" value="${myName}">
    <input type="submit" value="入力">
    <div>${result}</div>
</form>
</body>
</html>

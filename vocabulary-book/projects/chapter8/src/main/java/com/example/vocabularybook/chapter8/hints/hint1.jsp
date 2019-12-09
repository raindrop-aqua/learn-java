<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ja">
<head>
    <title>翻訳</title>
</head>
<body>
<h1>翻訳</h1>
<form action="/hint1" method="get">
    <p>単語を入力してください</p>
    <input type="text" name="word" id="word" value="${word}">
    <input type="submit" value="翻訳">
    <div>${result}</div>
</form>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ja">
<head>
    <title>翻訳</title>
</head>
<body>
<h1>翻訳</h1>

<form action="/translate" method="get">
    <p>単語を入力してください</p>
    <input type="text" name="word" id="word" value="${word}">
    <input type="submit" value="翻訳">

    <div id="result">${result}</div>
</form>
<a href="management.jsp">単語の登録・削除</a>
</body>
</html>

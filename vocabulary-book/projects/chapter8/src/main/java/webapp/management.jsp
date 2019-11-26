<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ja">
<head>
    <title>単語の登録・削除</title>
</head>
<body>
<h1>単語の登録・削除</h1>
<form action="/add" method="post">
    <h2>登録</h2>
    <p>単語と翻訳国を入力して、登録ボタンを押してください。</p>
    <input type="text" name="word1" id="word1" value="${word1}">
    <input type="text" name="word2" id="word2" value="${word2}">
    <input type="submit" value="登録">
</form>

<form action="/delete" method="post">
    <h2>削除</h2>
    <p>削除したい単語を入力して、削除ボタンを押してください。</p>
    <input type="text" name="word" id="word" value="${word}">
    <input type="submit" value="削除">
</form>
<div>${result}</div>

<a href="index.jsp">単語の翻訳</a>
</body>
</html>

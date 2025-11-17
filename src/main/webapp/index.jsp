<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
</head>
<body>
<h2>ログイン</h2>
<form action="Login" method="post">
  ログインID：<input type="text" name="id"><br>
  パスワード：<input type="password" name="pass"><br>
  <input type="submit" value="ログイン">
</form>
<% String errorMsg = (String) request.getAttribute("errorMsg"); %>
<% if (errorMsg != null) { %>
  <p style="color:red;"><%= errorMsg %></p>
<% } %>


<hr>

<h3>新規登録はこちら</h3>
<a href="RegisterUser">新規登録</a>
<!-- またはボタン形式 -->
<!--
<form action="RegisterUser" method="get">
  <input type="submit" value="新規登録">
</form>
-->
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%
User registerUser = (User) session.getAttribute("registerUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録確認</title>
</head>
<body>
<p>下記のユーザーを登録します</p>
<p>
名前：<%= registerUser.getNameSei() + " " + registerUser.getNameMei() %><br>
名前(カナ)：<%= registerUser.getNameSeiKana() + " " + registerUser.getNameMeiKana() %><br>
性別：<%= registerUser.getGender() %><br>
メール：<%= registerUser.getEmail() %><br>
電話番号：<%= registerUser.getMobile() %><br>
郵便番号：<%= registerUser.getPost() %><br>
住所：<%= registerUser.getPref() + " " + registerUser.getAddress() %><br>
</p>

<a href="index.jsp">戻る</a>
<a href="RegisterUser?action=done">登録</a>

</body>
</html>

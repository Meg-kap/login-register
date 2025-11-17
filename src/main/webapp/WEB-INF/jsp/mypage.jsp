<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="model.User" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>マイページ</title>
</head>
<body>
<%
  User loginUser = (User) session.getAttribute("loginUser");
%>
<p>ようこそ、<%= loginUser.getName() %>さん！</p>
</body>
</html>

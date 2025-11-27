<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%
    User loginUser = (User) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>マイページ</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<%@ include file="common/header.jsp" %>
<main>
<h1>マイページ</h1>

<p>ようこそ、<%= loginUser.getNameSei() + " " + loginUser.getNameMei() %> さん</p>

<div class="form-actions">
	<a class="btn" href="EditUser">登録情報の確認・編集</a>
</div>

<div class="form-actions">
	<a class="btn" href="<%= request.getContextPath() %>/index.jsp">戻る</a>
</div>

</main>
<%@ include file="common/footer.jsp" %>
</body>
</html>


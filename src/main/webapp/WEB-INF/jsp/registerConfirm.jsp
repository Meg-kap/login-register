<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%
User registerUser = (User) session.getAttribute("registerUser");
%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>ユーザー登録確認</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<%@ include file="common/header.jsp" %>
<main>
<h1>ユーザー登録確認</h1>

<div class="confirm-card">
	<p>下記のユーザーを登録します</p>

	<div class="confirm-row">
		<span class="label">名前：</span>
		<span class="value"><%= registerUser.getNameSei() + " " + registerUser.getNameMei() %></span>
	</div>

	<div class="confirm-row">
		<span class="label">名前(カナ)：</span>
		<span class="value"><%= registerUser.getNameSeiKana() + " " + registerUser.getNameMeiKana() %></span>
	</div>

	<div class="confirm-row">
		<span class="label">性別：</span>
		<span class="value"><%= registerUser.getGender() %></span>
	</div>

	<div class="confirm-row">
		<span class="label">メール：</span>
		<span class="value"><%= registerUser.getEmail() %></span>
	</div>
	
	<div class="confirm-row">
		<span class="label">電話番号：</span>
		<span class="value">
			<%
			String mobile = registerUser.getMobile();
			String formattedMobile = mobile;
			
				if (mobile != null && mobile.length() == 11) {
					formattedMobile = mobile.substring(0, 3) + "-" +
									  mobile.substring(3, 7) + "-" +
									  mobile.substring(7);
				}
			%>
			<%= formattedMobile %>
		</span>
	</div>

	<div class="confirm-row">
		<span class="label">郵便番号：</span>
		<span class="value"><%= registerUser.getPost() %></span>
	</div>

	<div class="confirm-row">
		<span class="label">住所：</span>
		<span class="value"><%= registerUser.getPref() + " " + registerUser.getAddress() %></span>
	</div>

	<div class="form-actions">
		<a class="btn btn-submit" href="RegisterUser?action=done">登録</a>
		<a class="btn" href="index.jsp">戻る</a>
	</div>
</div>
</main>
<%@ include file="common/footer.jsp" %>
</body>
</html>

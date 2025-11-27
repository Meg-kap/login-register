<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>ログイン</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>
<%@ include file="WEB-INF/jsp/common/header.jsp" %>

<main>
<div class="form-container">
	<h1 class="form-title">ログイン</h1>
	<form action="Login" method="post" class="form-wrap">
		<div class="form-row">
			<label for="id">ログインID</label>
			 <input type="text" id="id" name="id" required>
		</div>

		<div class="form-row">
			<label for="pass">パスワード</label>
			<input type="password" id="pass" name="pass" required>
		</div>

		<div class="form-actions">
			<input type="submit" value="ログイン" class="btn-primary">
		</div>

	</form>

	<% if (request.getAttribute("errorMsg") != null) { %>
	<p class="error-msg"><%= request.getAttribute("errorMsg") %></p>
	<% } %>

	<div class="additional-links">
		<p>アカウントをお持ちでない方はこちら👇</p>
		<a href="RegisterUser" class="btn-secondary">新規登録</a>
	</div>

</div>
</main>
<%@ include file="WEB-INF/jsp/common/footer.jsp" %>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%
User editUser = (User) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>登録情報編集</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<%@ include file="common/header.jsp" %>
<main>
<h1>登録情報編集</h1>

<form action="UpdateUser" method="post">
	<div class="form-row">
		<label>姓</label>
		<input type="text" name="name_sei" value="<%= editUser.getNameSei() %>" required>
		<label>名</label>
		<input type="text" name="name_mei" value="<%= editUser.getNameMei() %>" required>
	</div>

	<div class="form-row">
		<label>姓(カナ)</label>
		<input type="text" name="name_sei_kana" value="<%= editUser.getNameSeiKana() %>" required>
		<label>名(カナ)</label>
		<input type="text" name="name_mei_kana" value="<%= editUser.getNameMeiKana() %>" required>
	</div>

	<div class="form-row">
		<label>性別</label>
		<select name="gender" required>
			<option value="男性" <%= "男性".equals(editUser.getGender()) ? "selected" : "" %>>男性</option>
			<option value="女性" <%= "女性".equals(editUser.getGender()) ? "selected" : "" %>>女性</option>
			<option value="未回答" <%= "未回答".equals(editUser.getGender()) ? "selected" : "" %>>未回答</option>
		</select>

	<div class="form-row">
		<label>メール</label>
		<input type="email" name="email" value="<%= editUser.getEmail() %>" required>
	</div>

	</div>	<div class="form-row">
		<label>電話番号</label>
		<input type="text" name="mobile1" value="<%= editUser.getMobile().substring(0,3) %>" required  maxlength="3" style="width:60px;">
		<input type="text" name="mobile2" value="<%= editUser.getMobile().substring(3,7) %>" required  maxlength="4" style="width:70px;">
		<input type="text" name="mobile3" value="<%= editUser.getMobile().substring(7) %>" required  maxlength="4" style="width:70px;">
	</div>

	<div class="form-row">
		<label>郵便番号</label>
		<input type="text" id="post" name="post" value="<%= editUser.getPost() %>" maxlength="7">
	</div>

	<div class="form-row">
		<label>都道府県</label>
		<input type="text" id="pref" name="pref" value="<%= editUser.getPref() %>">
	</div>

	<div class="form-row">
		<label>住所</label>
		<input type="text" id="address" name="address" value="<%= editUser.getAddress() %>">
	</div>

	 <div class="form-actions">
		<input type="submit" value="更新">
		<a class="btn" href="mypage.jsp">戻る</a>
	 </div>
 <br>
</form>

<% String updateMsg = (String) request.getAttribute("updateMsg"); %>
<% if (updateMsg != null) { %>
    <p style="color:red; font-weight:bold;"><%= updateMsg %></p>
<% } %>

</main>
<%@ include file="common/footer.jsp" %>
</body>

<script>
document.getElementById("post").addEventListener("keyup", function() {
	const zipcode = this.value.replace(/[^0-9]/g, ""); // 数字以外除外

	if (zipcode.length === 7) {
		fetch("https://zipcloud.ibsnet.co.jp/api/search?zipcode=" + zipcode)
			.then(response => response.json())
			.then(data => {
				if (data.results) {
					const result = data.results[0];
					document.getElementById("pref").value = result.address1;
					document.getElementById("address").value = result.address2 + result.address3;
				} else {
					alert("該当する住所が見つかりません");
				}
			})
			.catch(err => console.log(err));
	}
});
</script>

</html>

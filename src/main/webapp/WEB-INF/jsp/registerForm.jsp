<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>ユーザー登録</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<%@ include file="common/header.jsp" %>
<main>
<h1>ユーザー登録</h1>

<form action="RegisterUser" method="post">
	<div class="form-row">
		<label>姓</label>
		<input type="text" name="name_sei" required>
		<label>名</label>
		<input type="text" name="name_mei" required>
	</div>

	<div class="form-row">
		<label>姓(カナ)</label>
		<input type="text" name="name_sei_kana" required>
		<label>名(カナ)</label>
		<input type="text" name="name_mei_kana" required>
	</div>

	<div class="form-row">
		<label>性別</label>
		<select name="gender" required>
			<option value="男性">男性</option>
			<option value="女性">女性</option>
			<option value="未回答">未回答</option>
		</select>
	
		<div class="form-row">
			<label>メール</label>
			<input type="email" name="email" required>
		</div>
	</div>	
	
		<div class="form-row">
			<label>電話番号</label>
			<input type="text" name="mobile1" maxlength="3" style="width:60px;">
			-
			<input type="text" name="mobile2" maxlength="4" style="width:70px;">
			-
			<input type="text" name="mobile3" maxlength="4" style="width:70px;">
		</div>

	<div class="form-row">
		<label>郵便番号</label>
		<input type="text" id="post" name="post" maxlength="7" placeholder="例: 1600022">
	</div>

	<div class="form-row">
		<label>都道府県</label>
		<input type="text" id="pref" name="pref">
	</div>

	<div class="form-row">
		<label>住所</label>
		<input type="text" id="address" name="address">
	</div>

	<div class="form-row">
		<label>パスワード</label>
		<input type="password" name="password" required>
	</div>

	<div class="form-actions">
		<input type="submit" value="確認">
		<a class="btn" href="index.jsp">戻る</a>
	</div>
</form>


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

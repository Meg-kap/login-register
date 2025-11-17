<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>ユーザー登録</title>
<!-- CSSを別シートで読み込み -->
<link rel="stylesheet" href="css/style.css">
</head>
<body>
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
  </div>
  <div class="form-row">
    <label>メール</label>
    <input type="email" name="email" required>
  </div>
  <div class="form-row">
    <label>電話番号</label>
    <input type="tel" name="mobile">
  </div>
  <div class="form-row">
    <label>郵便番号</label>
    <input type="text" name="post">
  </div>
  <div class="form-row">
    <label>都道府県</label>
    <input type="text" name="pref">
  </div>
  <div class="form-row">
    <label>住所</label>
    <input type="text" name="address">
  </div>
  <div class="form-row">
    <label>パスワード</label>
    <input type="password" name="password" required>
  </div>
  <div class="form-actions">
    <input type="submit" value="確認">
  </div>
</form>
</body>
</html>



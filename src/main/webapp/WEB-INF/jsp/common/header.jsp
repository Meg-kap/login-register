<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ page import="model.User" %>

<%
	User headerLoginUser = null;

	// ★ session が null かチェックしてから処理
	HttpSession s = request.getSession(false);
	if (s != null) {
		Object obj = s.getAttribute("loginUser");
		if (obj instanceof User) {
			headerLoginUser = (User) obj;
		}
	}
%>

<header class="header-container">
<div class="header-left">
	<h1 class="logo">
		<a href="<%= request.getContextPath() %>/index.jsp" style="color:inherit; text-decoration:none;">ECサイト</a>
	</h1>
</div>

<nav class="header-nav">
	<a href="<%= request.getContextPath() %>/index.jsp">ホーム</a>
	<a href="#">カート</a>

	<% if (headerLoginUser != null) { %>

		<a href="<%= request.getContextPath() %>/Mypage">マイページ</a>
		<a href="<%= request.getContextPath() %>/Logout"
			onclick="return confirm('本当にログアウトしますか？');">ログアウト</a>
		<span> / <strong><%= headerLoginUser.getName() %></strong> さん</span>

	<% } else { %>

		<a href="<%= request.getContextPath() %>/login.jsp">ログイン</a>

	<% } %>
</nav>
</header>

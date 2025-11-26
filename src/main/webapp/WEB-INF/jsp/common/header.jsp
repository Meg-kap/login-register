<%@ page contentType="text/html; charset=UTF-8" %>
<header>
    <h1>ECサイト</h1>

    <nav>
        <a href="index.jsp" style="color:white; margin:10px;">ホーム</a>
        <a href="<%= request.getContextPath() %>/Mypage" style="color:white; margin:10px;">マイページ</a>
        <a href="Logout" style="color:white; margin:10px;">ログアウト</a>
    </nav>
</header>
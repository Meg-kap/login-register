package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.LoginLogic;
import model.User;

@WebServlet("/Login")
public class Login extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    String id = request.getParameter("id");
    String pass = request.getParameter("pass");

    // DB照合ロジック呼び出し
    LoginLogic loginLogic = new LoginLogic();
    User loginUser = loginLogic.execute(id, pass);

    if (loginUser != null) {
      // ログイン成功 → セッションに保存してマイページへ
      HttpSession session = request.getSession();
      session.setAttribute("loginUser", loginUser);
      RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/mypage.jsp");
      dispatcher.forward(request, response);
    } else {
      // ログイン失敗 → エラーメッセージ表示
      request.setAttribute("errorMsg", "ログインIDまたはパスワードが違います");
      RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
      dispatcher.forward(request, response);
    }
  }
}

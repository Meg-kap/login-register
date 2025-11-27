package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.User;

@WebServlet("/Mypage")
public class Mypage extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		User loginUser = (session != null) ? (User) session.getAttribute("loginUser") : null;
		
		if (loginUser != null) {
			// ログイン済 → mypage.jspへ
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
			dispatcher.forward(request, response);
		} else {
			// 未ログイン → ログインページへ
			response.sendRedirect("index.jsp");
		}
	 }
}

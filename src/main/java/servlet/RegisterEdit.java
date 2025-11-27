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

@WebServlet("/RegisterEdit")
public class RegisterEdit extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");
		
		if (loginUser == null) {
			response.sendRedirect("login.jsp");
			return;
		}
		
		// JSP にユーザー情報を渡す
		request.setAttribute("editUser", loginUser);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/registerEdit.jsp");
		dispatcher.forward(request, response);
	}
}

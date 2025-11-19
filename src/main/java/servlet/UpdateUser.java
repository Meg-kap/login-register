package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.RegisterUserLogic;
import model.User;

@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	
    	HttpSession session = request.getSession();
    	User loginUser = (User) session.getAttribute("loginUser");
    	
    	if (loginUser == null) {
    		response.sendRedirect("index.jsp");
    		return; 			
    	}
    	
    	// リクエストパラメータ取得
    	String nameSei = request.getParameter("name_sei");
    	String nameMei = request.getParameter("name_mei");
    	String nameSeiKana = request.getParameter("name_sei_kana");
    	String nameMeiKana = request.getParameter("name_mei_kana");
    	String gender = request.getParameter("gender");
    	String email = request.getParameter("email");
    	String mobile = request.getParameter("mobile1") + request.getParameter("mobile2") + request.getParameter("mobile3");
    	String post = request.getParameter("post");
    	String pref = request.getParameter("pref");
    	String address = request.getParameter("address");
    	
    	// Userインスタンス更新
    	loginUser.setNameSei(nameSei);
    	loginUser.setNameMei(nameMei);
    	loginUser.setNameSeiKana(nameSeiKana);
    	loginUser.setNameMeiKana(nameMeiKana);
    	loginUser.setGender(gender);
    	loginUser.setEmail(email);
    	loginUser.setMobile(mobile);
    	loginUser.setPost(post);
    	loginUser.setPref(pref);
    	loginUser.setAddress(address);
    	
    	// DB更新
    	RegisterUserLogic logic = new RegisterUserLogic();
    	boolean success = logic.update(loginUser);
    	
    	// セッションに更新
    	session.setAttribute("loginUser", loginUser);
    	
    	// 更新結果をリクエストにセット
    	request.setAttribute("updateMsg", success ? "更新されました。" : "更新に失敗しました。");
    	
    	// 編集画面にフォワード
    	RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/editUser.jsp");
    	dispatcher.forward(request, response);
    	
	}
}

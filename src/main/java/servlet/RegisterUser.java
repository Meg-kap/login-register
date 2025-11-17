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


@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
				//フォワード先
				String forwardPath = null;
				
				//リクエストパラメータから取得
				String action = request.getParameter("action");
				
				//「登録の開始」をリクエストされた時の処理
				if (action == null) {
					//フォワード先の設定
					forwardPath = "WEB-INF/jsp/registerForm.jsp";
				}
				//登録確認画面から「登録実行」をリクエストされたときの処理
				else if (action.equals("done")) {
					//セッションスコープに保存された登録ユーザーを取得
					HttpSession session = request.getSession();
					User registerUser = (User)session.getAttribute("registerUser");
					
					//登録処理の呼び出し
					RegisterUserLogic logic = new RegisterUserLogic();
					logic.excute(registerUser);
					
					//不要となったセッションスコープ内のインスタンスを削除
					session.removeAttribute("registerUser");
					
					//登録後のフォワード先を設定
					forwardPath = "WEB-INF/jsp/registerDone.jsp";
				}
				
				//設定されたフォワード先にフォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
				dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");

	    // リクエストパラメータの取得
	    String nameSei = request.getParameter("name_sei");
	    String nameMei = request.getParameter("name_mei");
	    String nameSeiKana = request.getParameter("name_sei_kana");
	    String nameMeiKana = request.getParameter("name_mei_kana");
	    String gender = request.getParameter("gender");
	    String email = request.getParameter("email");
	    String mobile = request.getParameter("mobile");
	    String post = request.getParameter("post");
	    String pref = request.getParameter("pref");
	    String address = request.getParameter("address");
	    String password = request.getParameter("password");

	    // ユーザー情報をセット（Userクラスは全項目を持つように定義）
	    User registerUser = new User(
	        nameSei, nameMei, nameSeiKana, nameMeiKana,
	        gender, email, mobile, post, pref, address, password
	    );

	    // セッションスコープに保存
	    HttpSession session = request.getSession();
	    session.setAttribute("registerUser", registerUser);

	    // 確認画面へフォワード
	    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/registerConfirm.jsp");
	    dispatcher.forward(request, response);
	}

}

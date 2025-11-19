package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.PasswordUtil;

public class LoginLogic {
	public User execute(String email, String pass) {
		Connection conn = null;
		try {
			Class.forName("org.h2.Driver");
			String url = "jdbc:h2:tcp://localhost/~/desktop/H2/ec";
			String userName = "sa";
			String password = "";
			conn = DriverManager.getConnection(url, userName, password);
			
			// ★入力パスワードをハッシュ化
			String hashedInput = PasswordUtil.hash(pass);
			
			String sql = "SELECT * FROM ec_users WHERE email = ? AND password = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, hashedInput);
			
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				User user = new User();
				user.setEmail(rs.getString("email"));
				user.setNameSei(rs.getString("name_sei"));
				user.setNameMei(rs.getString("name_mei"));
				user.setNameSeiKana(rs.getString("name_sei_kana"));
				user.setNameMeiKana(rs.getString("name_mei_kana"));
				user.setGender(rs.getString("gender"));
				user.setMobile(rs.getString("mobile"));
				user.setPost(rs.getString("post"));
				user.setPref(rs.getString("pref"));
				user.setAddress(rs.getString("address"));
				return user;
			}
			
			return null;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try { if (conn != null) conn.close(); } catch (Exception e) {}
		}
	}
}

package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import util.PasswordUtil;

//新規ユーザー登録
public class RegisterUserLogic {
	public boolean excute(User user) {
		Connection conn = null;
		try {
			Class.forName("org.h2.Driver");
			String url = "jdbc:h2:tcp://localhost/~/desktop/H2/ec";
			String userName = "sa";
			String password = "";
			conn = DriverManager.getConnection(url, userName, password);
			
			String sql = "INSERT INTO ec_users (" 
					+ "name_sei, name_mei, name_sei_kana, name_mei_kana, "
					+ "gender, email, mobile, post, pref, address, password"
					+ ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, user.getNameSei());
			pstmt.setString(2, user.getNameMei());
			pstmt.setString(3, user.getNameSeiKana());
			pstmt.setString(4, user.getNameMeiKana());
			pstmt.setString(5, user.getGender());
			pstmt.setString(6, user.getEmail());
			pstmt.setString(7, user.getMobile());
			pstmt.setString(8, user.getPost());
			pstmt.setString(9, user.getPref());
			pstmt.setString(10, user.getAddress());
			
			// ★パスワードをハッシュ化して保存
			String hashedPass = PasswordUtil.hash(user.getPassword());
			pstmt.setString(11, hashedPass);
			
			int result = pstmt.executeUpdate();
			return result == 1;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try { if (conn != null) conn.close(); } catch (Exception e) {}
		}
	}
	
	//ユーザー情報の更新
	public boolean update(User user) {
		String url = "jdbc:h2:tcp://localhost/~/desktop/H2/ec";
		String userName = "sa";
		String password = "";
		
		try (Connection conn = DriverManager.getConnection(url, userName, password)) {
			String sql = "UPDATE ec_users SET name_sei=?, name_mei=?, name_sei_kana=?, name_mei_kana=?, gender=?, email=?, mobile=?, post=?, pref=?, address=? WHERE email=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getNameSei());
			pstmt.setString(2, user.getNameMei());
			pstmt.setString(3, user.getNameSeiKana());
			pstmt.setString(4, user.getNameMeiKana());
			pstmt.setString(5, user.getGender());
			pstmt.setString(6, user.getEmail());
			pstmt.setString(7, user.getMobile());
			pstmt.setString(8, user.getPost());
			pstmt.setString(9, user.getPref());
			pstmt.setString(10, user.getAddress());
			pstmt.setString(11, user.getEmail());
			
			return pstmt.executeUpdate() == 1;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}

package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginLogic {

    //ログイン
    public User execute(String email, String pass) {
        Connection conn = null;
        try {
            Class.forName("org.h2.Driver");
            String url = "jdbc:h2:tcp://localhost/~/desktop/H2/ec";
            String userName = "sa";
            String password = "";

            conn = DriverManager.getConnection(url, userName, password);

            String sql = "SELECT * FROM ecusers WHERE EMAIL = ? AND PASSWORD = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.setString(2, pass);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                User user = new User();
                user.setNameSei(rs.getString("NAME_SEI"));
                user.setNameMei(rs.getString("NAME_MEI"));
                user.setNameSeiKana(rs.getString("NAME_SEI_KANA"));
                user.setNameMeiKana(rs.getString("NAME_MEI_KANA"));
                user.setGender(rs.getString("GENDER"));
                user.setEmail(rs.getString("EMAIL"));
                user.setMobile(rs.getString("MOBILE"));
                user.setPost(rs.getString("POST"));
                user.setPref(rs.getString("PREF"));
                user.setAddress(rs.getString("ADDRESS"));
                user.setPassword(rs.getString("PASSWORD"));
                return user;
            } else {
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        } finally {
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
    }
}

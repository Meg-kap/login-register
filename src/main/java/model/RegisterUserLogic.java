package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

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
                    + "NAME_SEI, NAME_MEI, NAME_SEI_KANA, NAME_MEI_KANA, "
                    + "GENDER, EMAIL, MOBILE, POST, PREF, ADDRESS, PASSWORD"
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
            pstmt.setString(11, user.getPassword());

            int result = pstmt.executeUpdate();
            System.out.println("Insert result = " + result);

            return result == 1;

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        } finally {
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
    }
}

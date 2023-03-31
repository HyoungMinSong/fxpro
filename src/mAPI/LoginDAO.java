package mAPI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {
	private Connection con;
	
	public LoginDAO() {
		String user = "douzone";
		String password = "oracle";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String loginProc(String entryid) {
		String sql = "SELECT member_id FROM buy WHERE member_id=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		String id = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, entryid);
			rs = ps.executeQuery();
			if(rs.next()) {
				id = rs.getString("member_id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	public void loginSuccess(String id) {
		String sql = "UPDATE javafx SET login_check='Y' WHERE id=?";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String loginCheck(String id) {
		String sql = "SELECT login_check FROM javafx WHERE id=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		String loginCheck = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				loginCheck = rs.getString("login_check");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return loginCheck;
	}
}

package ex5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class LoginDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	public LoginDAO() {
		try {
		Class.forName("oracle.jdbc.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","douzone","oracle");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public boolean loginProc(String tId, String pId) {
		// TODO Auto-generated method stub
		try {
		ps = con.prepareStatement("select * from java_fx where id = ? and pw = ?");
		ps.setString(1, tId);
		ps.setString(2, pId);
		rs = ps.executeQuery();
		if(rs.next()) {
			return true;
		}}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return false;
		
	}
	
	public void loginSuccess(String id) {
		String sql = "UPDATE java_fx SET login_check='Y' WHERE id=?";
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
		String sql = "SELECT login_check FROM java_fx WHERE id=?";
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

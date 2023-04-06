package adminBlackList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class apiLoginDAO {
	private Connection con;
	
	public apiLoginDAO() {
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
		String sql = "SELECT member_id FROM member WHERE member_id=?";
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
}

package adminBlackList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class selectTotalDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public selectTotalDAO() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "douzone";
		String password = "oracle";

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<selectTotalDTO> selectAll() {
		String sql = "SELECT * FROM member WHERE blacklist = 'Y'";
		ArrayList<selectTotalDTO> totals = new ArrayList<>();
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				selectTotalDTO total = new selectTotalDTO();
				total.setMemberId(rs.getString("member_id"));
				total.setMemberTime(rs.getInt("member_time"));
				total.setLockerTime(rs.getInt("locker_time"));
				total.setLimitTime(rs.getDate("limit_time"));
				total.setBlackList(rs.getString("blacklist"));
				
				totals.add(total);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totals;
		
	}
	
	public void blackListInsert(String dbId) {
		PreparedStatement ps = null;
		String sql = "update member set blacklist = 'Y' where member_id = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dbId);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		
		
	}

	public void blackListDelete(String dbId) {
		PreparedStatement ps = null;
		String sql = "update member set blacklist = 'N' where member_id = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dbId);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}
	
	
}

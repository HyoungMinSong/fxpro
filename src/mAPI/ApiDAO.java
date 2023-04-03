package mAPI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ApiDAO {
	private Connection con;
	
	public ApiDAO() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "douzone";
		String password = "oracle";
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void apiProc(apiDTO api) {
		PreparedStatement ps = null;
		String sql = "SELECT nvl(max(num), 0)+1 as max_num FROM buy";
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				api.setNum(rs.getInt(1));//rs.getInt("max_num");
			}else {
				api.setNum(0);
			}
			sql = "INSERT INTO buy VALUES(?, ?, ?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, api.getNum());
			ps.setString(2, api.getBuyname());
			ps.setDate(3, api.getEntrydate());
			ps.setInt(4, api.getPrice());
			ps.setString(5, api.getBuyby());
			ps.setString(6, api.getMemberId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	
}

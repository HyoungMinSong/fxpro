package adminBuy;

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
		String sql = "SELECT * FROM buy ORDER BY buy_id ASC";
		ArrayList<selectTotalDTO> totals = new ArrayList<>();
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				selectTotalDTO total = new selectTotalDTO();
				total.setNum(rs.getInt("buy_id"));
				total.setEntrydate(rs.getString("buy_date"));
				total.setBuyby(rs.getString("buy_by"));
				total.setMemberId(rs.getString("member_id"));
				total.setTicketid(rs.getString("ticket_id"));
				
				totals.add(total);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totals;
		
	}
	
	
}

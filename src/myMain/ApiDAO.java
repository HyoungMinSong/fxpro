package myMain;

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
	
	public void buyInsert(apiDTO api) {
		PreparedStatement ps = null;
		String sql = "SELECT nvl(max(buy_id), 0)+1 as max_num FROM buy";
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				api.setNum(rs.getInt(1));//rs.getInt("max_num");
			}else {
				api.setNum(0);
			}
			sql = "INSERT INTO buy (buy_id, ticket_id, buy_by, member_id) VALUES(?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, api.getNum());
			ps.setString(2, api.getTicketid());
			ps.setString(3, api.getBuyby());
			ps.setString(4, api.getMemberId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void memberInsert(apiDTO api) {
		PreparedStatement ps = null;
		String sql = "INSERT INTO member (member_id, member_time) VALUES(?, ?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, api.getMemberId());
			ps.setInt(2, api.getMemberTime());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void memberTimeInsert(apiDTO api) {
		PreparedStatement ps = null;
		String sql = "INSERT INTO member (member_id, member_time) VALUES(?, ?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, api.getMemberId());
			ps.setInt(2, api.getMemberTime());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ApiTicketDTO getTicket(String ticketId) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
		ps = con.prepareStatement("select * from ticket_table where ticket_id = ?");
		ps.setString(1, ticketId);
		rs = ps.executeQuery();
		if(rs.next()) {
			ApiTicketDTO dto = new ApiTicketDTO();
			dto.setId(rs.getString(1));
			dto.setName(rs.getString(2));
			dto.setValue(rs.getInt(3));
			dto.setPrice(rs.getInt(4));
			return dto;
		}}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	public void memberTimeUD(apiDTO api) {
		PreparedStatement ps = null;
		String sql = "SELECT member_time FROM MEMBER WHERE member_id=?";
		ResultSet rs = null;
		int time=api.getMemberTime();
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, api.getMemberId());
			rs=ps.executeQuery();
			if(rs.next()) {
				time+=rs.getInt("member_time");
				api.setMemberTime(time);
			}
			sql = "UPDATE member SET member_time = ? WHERE member_id = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, api.getMemberTime());
			ps.setString(2, api.getMemberId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
		

}

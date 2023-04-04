package myMain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	public LoginDAO() {
		try {
		Class.forName("oracle.jdbc.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","douzone","oracle");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public LoginDTO seatLoginCheck(String id) {
		// TODO Auto-generated method stub
		System.out.println("dao테스트");
		try {
		ps = con.prepareStatement("select member_id, member_time from member where member_id = ?");
		ps.setString(1, id);
		rs = ps.executeQuery();
		if(rs.next()) {
			LoginDTO dto = new LoginDTO();
			dto.setId(rs.getString(1));
			dto.setRemainTime(rs.getInt(2));
			return dto;
		}}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean seatUseCheck(String id) {
		String sql ="SELECT * FROM seat WHERE member_id = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				return false ;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
}









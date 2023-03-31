package myMain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class PayDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	public PayDAO() {
		try {
		Class.forName("oracle.jdbc.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","douzone","oracle");
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



//	public ArrayList<PayTodayDTO> getTicket() {
//		// TODO Auto-generated method stub
//		try {
//		ps = con.prepareStatement("select * from ticket_table where ticket_id like 'D%'");
//		rs = ps.executeQuery();
//		ArrayList<PayTodayDTO> list = new ArrayList<>();
//		while(rs.next()) {
//			PayTodayDTO dto = new PayTodayDTO();
//			dto.setId(rs.getString(1));
//			dto.setName(rs.getString(2));
//			dto.setValue(rs.getInt(3));
//			dto.setPrice(rs.getInt(4));
//			list.add(dto);
//		}
//		return list;
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		
//		return null;
//	}


}

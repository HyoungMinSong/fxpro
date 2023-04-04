package seatView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class seatViewDAO {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public seatViewDAO() {
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
	
	public ArrayList<seatViewDTO> selectUseSeat() {//사용중인 좌석정보를 가져오기.
		String sql = "SELECT seat_num, seat_use, seat.member_id,member_time FROM seat,member WHERE seat_use=?";  //
		ArrayList<seatViewDTO> dataList = new ArrayList<>();
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, "Y");
			rs = ps.executeQuery();
			
			while(rs.next()) { //회원 id , 회원이 사용하는 좌석 번호, 잔여시간
				seatViewDTO data = new seatViewDTO();
				data.setMember_id(rs.getString("member_id"));
				data.setSeat_num(rs.getString("seat_num"));
				data.setMember_time(rs.getString("member_time"));
				dataList.add(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataList;
	}//selectUseSeat();

	
	public String checkSeatUse(String selectSeat) {
		String sql = "select * from seat where seat_num=?";
		String YN = "YN처음값"; //  DB에서 Y/N을 받아올 변수
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, selectSeat);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				YN=rs.getString("seat_use");
			}else {
				System.out.println("데이터가 없습니다.");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return YN;
		
	}

	public String getMember_time(String member_id) {
		String sql = "SELECT member_time from member WHERE member_id = ?";
		String member_time="";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, member_id);
			rs  = ps.executeQuery();
			if(rs.next()) {
				member_time = rs.getString("member_time");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return member_time;
	}
	
	
}

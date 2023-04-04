package myMain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class seatMoveDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	public seatMoveDAO(){
		String url = "jdbc:oracle:thin:@localhost:1522:xe";
		String username = "douzone";
		String password = "oracle";

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<seatViewDTO> selectUseSeat() {
		 String sql = "SELECT seat_num, seat_use,seat.member_id, member.member_time FROM seat join member on member.member_id = seat.member_id WHERE seat_use=?";  //
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
	public String checkSeatUse(String seatInfoData) {
		 String sql = "select * from seat where seat_num=?";
	      String YN = "YN처음값"; //  DB에서 Y/N을 받아올 변수
	      try {
	         ps = con.prepareStatement(sql);
	         ps.setString(1, seatInfoData);
	         rs = ps.executeQuery();
	         
	         if(rs.next()) {
	            YN=rs.getString("seat_use");
	         }else {
	            YN="N";
	         }
	         
	         
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	      return YN;
		
	}
	public void updateSeat(String member_id, String seatInfoData) {
		//UPDATE test SET name='user1', pw='user1' WHERE id='admin';
		String sql= "Update seat SET seat_num=? WHERE member_id = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, seatInfoData);
			ps.setString(2, member_id);
			ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

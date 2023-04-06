package adminSeat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import myMain.seatViewDTO;

public class adminSeatDAO {
	
	private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

	public adminSeatDAO() {
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

	public String findMemberData(String seat) {
		
		String sql ="select member_id from seat where seat_num = ?";
		String member_id="no";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, seat);
			rs = ps.executeQuery();
			if(rs.next()) { //member_id를 가져왔음.
				member_id = rs.getString("member_id");
				return member_id;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member_id;
		
	}

	public String findRemainTime(String member_id) {
		String sql = "SELECT member_time FROM member WHERE member_id = ?";
		String member_time="";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, member_id);
			rs= ps.executeQuery();
			if(rs.next()) {
				member_time =rs.getString(1);
				return member_time;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member_time;

	}//findRemainTime

	public String findEnterTime(String member_id) {
		String sql = "select access_time from access_table Where member_id=? and access_type='입실'";
		String access_time =""; 
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, member_id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				access_time = rs.getString(1);
				return access_time;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return access_time;
	}

	public int selectMemberTime(String member_id) {
		String sql = "select member_time from member Where member_id =?";
		int time = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, member_id);
			rs = ps.executeQuery();
			if(rs.next()) {
				time = rs.getInt("member_time");
				return time;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return time;
		
	}

	public void memberTimeUD(int time,String member_id) {
		// TODO Auto-generated method stub
		String sql = "UPDATE member SET member_time = ? WHERE member_id = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, time);
			ps.setString(2, member_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public adminSeatDTO seatCheck(String member_id) {
		String sql = "select * from seat where member_id = ?";
		adminSeatDTO result = new adminSeatDTO();
		try {
			ps= con.prepareStatement(sql);
			ps.setString(1, member_id);
			rs = ps.executeQuery();
			if(rs.next()) {
				result.setEnter_time(rs.getString("enter_time"));
				result.setMember_id(rs.getString("member_id"));
				result.setSeat_num(rs.getString("seat_num"));
				return result;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	public void updateSeat1(String member_id, String seat1) {
		//UPDATE test SET name='user1', pw='user1' WHERE id='admin';
		String sql ="Update seat SET seat_num=? WHERE member_id=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,seat1);
			ps.setString(2, member_id);
			ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public boolean seat1Check(String seat1) {
		String sql = "SELECT * FROM seat where seat_num = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, seat1);
			ps.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	

}




















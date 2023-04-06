package myMain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CommonDAO {
	  private Connection con;
	  private PreparedStatement ps;
	  private ResultSet rs;
	   
	public CommonDAO() {
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


	public void deleteSeat(String member_id) {
		String sql = "delete from seat WHERE member_id = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, member_id);
			ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	public void deleteLocker(String member_id) {
		String sql = "delete from locker WHERE member_id = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, member_id);
			ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}


	public String selectMemberSeat(String member_id) {
		String sql = "select * from seat WHERE member_id = ?";
		String seat_Num="";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, member_id);
			rs = ps.executeQuery();
			if(rs.next()) {
				seat_Num = rs.getString("seat_Num");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return seat_Num;
	}


	public boolean checkUser(String member_id) {
		String sql = "select * from seat WHERE member_id = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, member_id);
			rs =ps.executeQuery();
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

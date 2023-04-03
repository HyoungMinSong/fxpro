package myMain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class LockerDAO {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public LockerDAO() {
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
	
	public ArrayList<LockerDTO> selectUseLocker() { //사용중인 사물함 정보를 가져오기.
		//SELECT seat_num, seat_use,seat.member_id, member.member_time FROM 
		//seat join member on member.member_id = seat.member_id WHERE seat_use=?
		String sql = "SELECT * FROM locker join member on locker.member_id = member.member_id WHERE locker_use=?";	
		ArrayList<LockerDTO> dataList = new ArrayList<>();

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, "Y");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				LockerDTO data = new LockerDTO();
				data.setMember_id(rs.getString("member_id"));
				data.setLocker_num(rs.getString("locker_num"));
				data.setLocker_time(rs.getString("locker_time"));
				
				dataList.add(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataList;
	}
		
	}



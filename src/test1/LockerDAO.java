package test1;

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
	
	public ArrayList<LockerDTO> selectUseLocker() { //사용중인 사물함 정보를 가져오기.
		String sql = "SELECT * FROM locker WHERE locker_use=?";		
		
		
		ArrayList<LockerDTO> dataList = new ArrayList<>();

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, "Y");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				LockerDTO data = new LockerDTO();
				data.setMember_id(rs.getString("member_id"));
				data.setLocker_num(rs.getString("locker_num"));
				dataList.add(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataList;
	}
		
	}



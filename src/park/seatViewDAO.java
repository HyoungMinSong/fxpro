package park;

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
	
	public ArrayList<seatViewDTO> selectUseSeat() {//사용중인 좌석정보를 가져오기.
		String sql = "SELECT * FROM seat WHERE seat_use=?";
		
		ArrayList<seatViewDTO> dataList = new ArrayList<>();
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, "Y");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				seatViewDTO data = new seatViewDTO();
				data.setMember_id(rs.getString("member_id"));
				data.setSeat_num(rs.getString("seat_num"));
				dataList.add(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataList;
	}//selectUseSeat();
	
	
}

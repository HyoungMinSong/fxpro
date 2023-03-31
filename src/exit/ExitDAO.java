package exit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ExitDAO {
		private Connection con;
		private PreparedStatement ps = null;
		
		public ExitDAO() {
			String user = "douzone";
			String password = "oracle";
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				con = DriverManager.getConnection(url, user, password);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public String seatUse(String id) {
			String sql = "SELECT seat_use FROM seat WHERE member_id=?";
			PreparedStatement ps = null;
			ResultSet rs = null;
			String seatUse = null;
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, id);
				rs = ps.executeQuery();
				if(rs.next()) {
					seatUse = rs.getString("seat_use");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return seatUse;
			
		}

		public void exitCheck(String id) {
			String sql = "Delete from seat WHERE member_id = ?";
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1,  id);
				ps.executeUpdate(); //executeQuery();
	
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
		}
	}



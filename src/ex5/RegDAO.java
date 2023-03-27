package ex5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;

public class RegDAO {
		Connection con;
		PreparedStatement ps;
		ResultSet rs;
		int result;
		public RegDAO() {
			try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","douzone","oracle");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}


		public boolean checkId(String id) {
			// TODO Auto-generated method stub
			try {
			ps = con.prepareStatement("select * from java_fx where id = ?");
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			
			return false;
		}

		public boolean regProc(RegDto dto) {
			// TODO Auto-generated method stub
			System.out.println(dto.getId()+dto.getPw()+dto.getName());
			System.out.println(dto.getSex());
			System.out.println(Arrays.deepToString(dto.getHobby().toArray()));
			System.out.println(dto.getAgeGroup());
			try {
			ps=con.prepareStatement("insert into java_fx values(?,?,?,?,?,?)");
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPw());
			ps.setString(3, dto.getName());
			ps.setString(4, dto.getSex());
			ps.setString(5, Arrays.deepToString(dto.getHobby().toArray()));
//			ps.setString(5, "123");
			ps.setString(6, dto.getAgeGroup());
			result = ps.executeUpdate();
			}catch (Exception e) {
				e.printStackTrace();
			}
			if (result!=0) {
				return true;
			} 
			return false;
			}

		}


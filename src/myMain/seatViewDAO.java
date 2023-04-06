package myMain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

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
            YN="N";
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

   public void InsertSeatData(String member_id, String seatInfoData) {
      //seat.member_id,member_time
      String sql = "INSERT into seat values(?,'Y',?,default)";
      try {
         ps = con.prepareStatement(sql);
         ps.setString(1, seatInfoData);
         ps.setString(2, member_id);
         //ps.setString(3, member_time);
         ps.executeQuery();
         
         System.out.println("입력완료");
         
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
   public String selectEnter_timeInSeatTable(String member_id) {
      String sql = "SELECT enter_time FROM seat WHERE member_id = ?";
      String enter_Time ="";
      try {
         ps = con.prepareStatement(sql);
         ps.setString(1, member_id);
         rs=  ps.executeQuery();
         if(rs.next()) {
            enter_Time = rs.getString("enter_time");
         }
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      return enter_Time;
      
   }
   public int selectMemberTimeInMemberTable(String member_id) {
      String sql = "SELECT member_time from member WHERE member_id = ?";
      int member_Time =0;
      try {
         ps = con.prepareStatement(sql);
         ps.setString(1, member_id);
         rs = ps.executeQuery();
         
         if(rs.next()) {
            member_Time = rs.getInt("member_Time");
         }
      
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      System.out.println("member_Time  : ? "+member_Time);
      return member_Time;
   }

   public void Update_limit_time(String member_id) {
      java.sql.Date Limit_Time =null;
      String enter_time = selectEnter_timeInSeatTable(member_id); //현재시간
      int member_Time = selectMemberTimeInMemberTable(member_id); //잔여시간
      CommonService cser = new CommonService();
      Limit_Time = cser.getLimit_Time(enter_time , member_Time);
      String memberTime = ""; //member 테이블에서 가져온 잔여시간.
      
      String sql = "UPDATE member SET LIMIT_Time=? WHERE member_id =?";
      try {
         ps = con.prepareStatement(sql);
         ps.setDate(1, Limit_Time);
         ps.setString(2, member_id);
         ps.executeQuery();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
   }

	public void Update_limit_time2(String member_id, java.sql.Date date1) {
		String sql = "UPDATE member SET LIMIT_Time=? WHERE member_id =?";
		try {
			ps = con.prepareStatement(sql);
			ps.setDate(1, date1);
			ps.setString(2, member_id);
			ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

   public String getLimit_TimeForSpread(String member_id) {
      String sql = "SELECT limit_time FROM member WHERE member_id = ?";
      String limit_Time="";
      try {
         ps = con.prepareStatement(sql);
         ps.setString(1, member_id);
         rs = ps.executeQuery();
         if(rs.next()) {
            limit_Time = rs.getString("limit_Time");
         }
         
         
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      return limit_Time;
   }

public void InsertIntoAccessTable(String member_id) {
   String sql = "insert into access_table values(seq_access.nextVAL,'입실',CURRENT_TIMESTAMP,?)";
   try {
      ps = con.prepareStatement(sql);
      ps.setString(1, member_id);
      ps.executeQuery();
   } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
   }
   
   
}

   
   
   
}
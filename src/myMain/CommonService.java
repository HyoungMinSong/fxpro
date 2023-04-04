package myMain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class CommonService {
   public CommonService() {
      
   }

   public static void msg(String contentText) {
      Alert alert = new Alert(AlertType.INFORMATION);
      alert.setHeaderText("알림");
      alert.setContentText(contentText);
      alert.show();
   }
   public java.sql.Date getLimit_Time(String enter_Time, int member_Time) { //최대 이용 가능 시간을 구하는 로직
       //enter_Time (23/03/31 13:14) / member_Time 100 // // member Time 을 일 , 시간 ,분으로 나눔.
      SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      Date date = null;
      try {
         date = transFormat.parse(enter_Time);
      } catch (ParseException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      int min = 0; int hour = 0; int day = 0; 
      
      if(member_Time>60) { 
         min=member_Time%60; 
         hour = member_Time/60;
         
         if(hour>24) { 
            day = hour/24; hour= hour%24; 
            } 
         }else { 
            min = member_Time; 
      }
      System.out.println("hour : "+ hour +"  min :"+ min +"  day :" +day);
      

      Calendar cal1 = Calendar.getInstance();
      cal1.setTime(date); // 시간 설정
      //cal1.add(Calendar.YEAR, 2); // 년 연산
      //cal1.add(Calendar.MONTH, 4); // 월 연산
      cal1.add(Calendar.DATE, day); // 일 연산
      cal1.add(Calendar.HOUR_OF_DAY , hour); // 시간 연산
      cal1.add(Calendar.MINUTE, min); // 분 연산
      java.sql.Date date1 =  new java.sql.Date(cal1.getTimeInMillis());
      /*
       * SimpleDateFormat transFormatToSql = new
       * SimpleDateFormat("yy-MM-dd HH:mm:ss"); transFormatToSql.format(date1);
       */
      
      System.out.println("커먼 서비스 연산시간 : " + date1); //Fri Mar 31 16:40:07 KST 2023
      return date1;
      
   } //최대 이용 가능 시간을 구하는 로직
   
   public CommonDTO before5Min(String member_id) {//최대이용시간 5분전인걸 구하는 로직.
      //member 테이블에서 limit time을 가져와서 , 현재시간 vs limittime 비교.
      seatViewDAO dao = new seatViewDAO();
      String limit_Time = dao.getLimit_TimeForSpread(member_id); //저장되어 있는 최대이용시간을 불러옴.
      System.out.println("limit Time(before5Min)  :" + limit_Time);
      SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      Date limit_time1 = null;
      Date now = new Date();
         try {
            limit_time1 = transFormat.parse(limit_Time);
         } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
         
      long diffMin = (limit_time1.getTime() - now.getTime()) / 60000;
      CommonDTO cmDTO = new CommonDTO();
      if(diffMin<5&&diffMin>=0){
    	 cmDTO.setColor("0");
         return cmDTO; //빨간색
      }else if(diffMin<0) {//DB 삭제 , 회색(기본색으로 설정)
    	  CommonDAO cmDAO = new CommonDAO();
    	  String seat_Num = cmDAO.selectMemberSeat(member_id);
    	  cmDTO.setSeat_Num(seat_Num);
    	  cmDTO.setColor("-1");
    	  cmDAO.deleteSeat(member_id);
    	  return cmDTO;
      }else if(diffMin>0)
    	  cmDTO.setColor("2"); //넉넉한 시간.
      return cmDTO;
   }
}



















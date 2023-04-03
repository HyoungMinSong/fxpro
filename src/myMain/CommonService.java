package myMain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class CommonService {

	public static void msg(String contentText) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText("알림");
		alert.setContentText(contentText);
		alert.show();
	}


	public java.sql.Date getLimit_Time(String enter_Time, int member_Time) {
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
		
		System.out.println("연산시간 : " + date1); //Fri Mar 31 16:40:07 KST 2023
		return date1;
		
	}
}

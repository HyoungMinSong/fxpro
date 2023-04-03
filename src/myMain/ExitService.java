package myMain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExitService {
	private ExitDAO dao;
	public ExitService() {
		ExitDAO dao = new ExitDAO();
		this.dao = dao;
	}
	

		public void exitCheck(String a) {
		
				dao.exitCheck(a);
				
		}


		public String seatUse(String member_id) {
		
			return dao.seatUse(member_id);
		}


		public long getTime(String member_id) {
			// TODO Auto-generated method stub
			System.out.println("체크체크");
			String dateTime = dao.getTime(member_id);
			Date dateNow = new Date();
			long min = 0;
			try {
				Date format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateTime);
				min = (dateNow.getTime() -format1.getTime() ) / 60000;
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("데이트타임");
			System.out.println(dateTime);
			System.out.println("현재시간");
			System.out.println(dateNow);
			System.out.println("뺀 시간");
			System.out.println(min);
			
			return min;
}


		public int updateMember(long min, String member_id) {
			// TODO Auto-generated method stub
			return dao.updateMember(min,member_id);
		}


		public String memberCheck(String member_id) {
			// TODO Auto-generated method stub
			return dao.memberCheck(member_id);
		}
		}

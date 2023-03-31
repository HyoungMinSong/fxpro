package myMain;

import java.util.ArrayList;

public class payService {
	private PayDAO dao;
	
	public payService() {
		dao = new PayDAO();
	}
	public void payProc(payDTO pay) {

		// 정보 출력
		System.out.println("아이디 : " + pay.getMemberId());
		System.out.println("시간 : " + pay.getMemberTime());
		System.out.println("금액 : " + pay.getPrice());
		System.out.println("결제방법 : " + pay.getBuyby());
		

		// 회원 가입

		
	}
	public void choice(payDTO pay) {
		CommonService.msg("상품을 선택해주세요.");
	}
	public ArrayList<PayTodayDTO> getTicket() {
		// TODO Auto-generated method stub
		return dao.getTicket();
	}
	
	
	
}

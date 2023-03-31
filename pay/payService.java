package pay;

import pay.CommonService;

public class payService {
	public void payProc(payDTO pay) {

		// 정보 출력
		System.out.println("아이디 : " + pay.getMemberId());
		System.out.println("시간 : " + pay.getMemberTime());
		System.out.println("금액 : " + pay.getPrice());
		System.out.println("결제방법 : " + pay.getBuyby());
		
		// 아이디 검증
		if(pay.getMemberId().length()!=11){
			CommonService.msg("휴대폰번호를 입력하세요.");
			return;
		}
		
		// 회원 가입

		
	}
	public void choice(payDTO pay) {
		CommonService.msg("상품을 선택해주세요.");
	}
}

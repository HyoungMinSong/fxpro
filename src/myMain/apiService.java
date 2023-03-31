package myMain;

public class apiService {
	public void apiProc(apiDTO api) {
		
		// 정보 출력
		System.out.println("입장시간 : " + api.getEntrydate());
		System.out.println("아이디 : " + api.getMemberId());
		System.out.println("시간 : " + api.getMemberTime());
		System.out.println("금액 : " + api.getPrice());
		System.out.println("입력금액 : " + api.getEntryprice());
		System.out.println("결제방식 : " + api.getBuyby());
		
//		금액 확인
		if(api.getPrice()>api.getEntryprice()) {
			CommonService.msg("금액이 부족합니다.");
			return;
		}
		
		// 아이디 중복 검증
		apiLoginDAO loginDao = new apiLoginDAO();
		String dbId=loginDao.loginProc(api.getMemberId());
		if(dbId != null) {
			//회원가입 및 정보 등록
			ApiDAO apiDao = new ApiDAO();
			apiDao.apiProc(api);
			
		}else {
			//정보 등록
			
		}
		
	}
	
}

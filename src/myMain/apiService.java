package myMain;

public class apiService {
	private ApiDAO dao;
	
	public apiService() {
		dao = new ApiDAO();
	}
	
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
		System.out.println(dbId);
		System.out.println(api.getMemberTime());
		if(dbId == null ) {
			//회원가입 및 정보 등록
			System.out.println("아이디 없음");
			ApiDAO apiDao = new ApiDAO();
			apiDao.buyInsert(api);
			apiDao.memberInsert(api);
		}else {
			//정보 등록
			System.out.println("아이디 있음");
			ApiDAO apiDao = new ApiDAO();
			apiDao.buyInsert(api);
			apiDao.memberTimeUD(api);
		}
		System.out.println(api.getMemberTime());
		
	}
	
	public void lApiProc(LapiDTO api) {
		
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
		System.out.println(dbId);
		System.out.println(api.getMemberTime());
		if(dbId == null ) {
			//회원가입 및 정보 등록
			System.out.println("아이디 없음");
			LApiDAO apiDao = new LApiDAO();
			apiDao.buyInsert(api);
			apiDao.memberInsert(api);
			apiDao.insertLocker(api);
		}else {
			//정보 등록
			System.out.println("아이디 있음");
			LApiDAO apiDao = new LApiDAO();
			apiDao.buyInsert(api);
			apiDao.memberTimeUD(api);
		}
		System.out.println(api.getMemberTime());
		
	}
	
	public ApiTicketDTO ticketDAO(String ticketId) {
		// TODO Auto-generated method stub
		return dao.getTicket(ticketId);
	}
	
	public void lApiProc2(LapiDTO api) {
		
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
		api.getMemberId();
		System.out.println(api.getMemberTime());
		//정보 등록
		System.out.println("아이디 있음");
		LApiDAO apiDao = new LApiDAO();
		apiDao.buyInsert(api);
		apiDao.memberTimeUD2(api);
		
		
	}
	
}

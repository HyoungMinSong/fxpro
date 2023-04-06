package lockerExtend;



public class LpayService2 {
	private LpayDAO2 dao;
	
	
	public LpayService2() {
		dao = new LpayDAO2();
	}

	public int seatCheckById(String checkId) {
		// TODO Auto-generated method stub
		return dao.seatCheckById(checkId);
	}

}

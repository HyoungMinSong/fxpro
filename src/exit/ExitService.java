package exit;



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
	
		}

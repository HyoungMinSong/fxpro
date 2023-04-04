package myMain;

public class seatMoveDTO {
	//SELECT seat_num, seat_use, seat.member_id,member_time FROM seat,member WHERE seat_use=
	private String seat_num;
	private String seat_use;
	private String member_id;
	private String member_time;
	
	public String getMember_time() {
		return member_time;
	}
	public void setMember_time(String member_time) {
		this.member_time = member_time;
	}
	public String getSeat_num() {
		return seat_num;
	}
	public void setSeat_num(String seat_num) {
		this.seat_num = seat_num;
	}
	public String getSeat_use() {
		return seat_use;
	}
	public void setSeat_use(String seat_use) {
		this.seat_use = seat_use;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
}

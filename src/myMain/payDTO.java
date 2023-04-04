package myMain;

public class payDTO {
	private String memberId;
	private int memberTime;
	private int price;
	private String buyby;
	
	public String getBuyby() {
		return buyby;
	}
	public void setBuyby(String buyby) {
		this.buyby = buyby;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getMemberTime() {
		return memberTime;
	}
	public void setMemberTime(int memberTime) {
		this.memberTime = memberTime;
	}
	
	
}

	
	
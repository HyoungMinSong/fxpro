package adminBlackList;

import java.sql.Date;

public class selectTotalDTO {
	private int num; // 구매번호
	private String entrydate; // 구매일자
	private String memberId;// 핸드폰번호
	private int entryprice; // 입력 금액
	private int memberTime;// 구매시간
	private int lockerTime;// 구매시간
	private Date limitTime;
	private String blackList;
	
	public String getBlackList() {
		return blackList;
	}
	public void setBlackList(String blackList) {
		this.blackList = blackList;
	}
	public Date getLimitTime() {
		return limitTime;
	}
	public void setLimitTime(Date limitTime) {
		this.limitTime = limitTime;
	}
	public int getLockerTime() {
		return lockerTime;
	}
	public void setLockerTime(int lockerTime) {
		this.lockerTime = lockerTime;
	}
	private int price;// 결재 금액
	private String buyby; // 결제종류
	private String buyname; //상품명
	private String ticketid; // 이용권일련번호
	
	public String getTicketid() {
		return ticketid;
	}
	public void setTicketid(String ticketid) {
		this.ticketid = ticketid;
	}
	public String getBuyname() {
		return buyname;
	}
	public void setBuyname(String buyname) {
		this.buyname = buyname;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getPrice() {
		return price;
	}
	public String getBuyby() {
		return buyby;
	}
	public void setBuyby(String buyby) {
		this.buyby = buyby;
	}
	
	
	public int getEntryprice() {
		return entryprice;
	}
	public void setEntryprice(int entryprice) {
		this.entryprice = entryprice;
	}
	public String getEntrydate() {
		return entrydate;
	}
	public void setEntrydate(String entrydate) {
		this.entrydate = entrydate;
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

	
	
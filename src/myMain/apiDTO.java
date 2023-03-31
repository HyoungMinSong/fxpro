package myMain;

import java.sql.Date;

public class apiDTO {
	private int num; // 구매번호
	private Date entrydate; // 구매일자
	private String memberId;// 핸드폰번호
	private int entryprice; // 입력 금액
	private String memberTime;// 구매시간
	private int price;// 결재 금액
	private String buyby; // 결제종류
	private String buyname; //상품명
	
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


	public Date getEntrydate() {
		return entrydate;
	}
	public void setEntrydate(Date entrydate) {
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
	public String getMemberTime() {
		return memberTime;
	}
	public void setMemberTime(String memberTime) {
		this.memberTime = memberTime;
	}

	
	
}

	
	
package myMain;

import java.net.URL;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;

public class mAPIController implements Initializable {
	@FXML
	Label entryDate;
	@FXML
	Label entryTime;
	@FXML
	Label productName;
	@FXML
	Label payment;
	@FXML
	Label exitTime;
	@FXML
	TextField entryPrice;
	private payDTO paydto;
	private apiService service;
	private String hp;
	private String cardOrHyoun;
	public ApiTicketDTO apd;
	
	
	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getCardOrHyoun() {
		return cardOrHyoun;
	}

	public void setCardOrHyoun(String cardOrHyoun) {
		this.cardOrHyoun = cardOrHyoun;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		paydto = new payDTO();
		service = new apiService();
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat formatter= new SimpleDateFormat("MM.dd");
		entryDate.setText(formatter.format(date));
		SimpleDateFormat formatter2= new SimpleDateFormat("HH:mm");
		entryTime.setText(formatter2.format(date));
		
		
	}

	public void dataProc(String ticketId, String hp, String cardOrHyoun) {
		System.out.println("확인");
		apd = service.ticketDAO(ticketId);
		System.out.println(apd.getId());
		System.out.println(apd.getName());
		System.out.println(apd.getPrice());
		System.out.println(apd.getValue());
		productName.setText(apd.getName());
		payment.setText(apd.getPrice()+"원");
		setHp(hp);
		setCardOrHyoun(cardOrHyoun);
		
	}

	//  확인 버튼
	public void check() {
		Date date = new Date(System.currentTimeMillis());
//		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//		String a = formatter.format(new Date(System.currentTimeMillis()));
//		date = formatter.parse(a);
		apiDTO api = new apiDTO();
		if(entryPrice.getText().equals("")) {
			CommonService.msg("금액을 입력해주세요.");
			return;
		}
		if(apd.getPrice()> Integer.parseInt(entryPrice.getText())) {
			CommonService.msg("금액이 부족합니다.");
			return;
		}
		
		api.setBuyname(productName.getText());
		api.setEntrydate(date);
		api.setMemberId(getHp());
		api.setMemberTime(apd.getValue());
		api.setPrice(apd.getPrice());
		api.setEntryprice(Integer.parseInt(entryPrice.getText()));
		api.setBuyby(getCardOrHyoun());
		api.setTicketid(apd.getId());
//		
		service.apiProc(api);
		CommonService.msg("결제 되었습니다.");
		System.out.println("메인 화면으로 이동");
	}
	
	// 취소 버튼
	public void cancle() {
		System.out.println("pay화면으로 이동");
	}

}

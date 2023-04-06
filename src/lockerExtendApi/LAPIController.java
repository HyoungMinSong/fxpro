package lockerExtendApi;

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
import myMain.ApiTicketDTO;
import myMain.CommonService;
import myMain.LapiDTO;
import myMain.Opener;
import myMain.apiService;

public class LAPIController implements Initializable {
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
	@FXML
	Label lockerInt;
	private apiService service;
	private String hp;
	private String cardOrHyoun;
	public ApiTicketDTO apd;
	private Opener opener;
	private int lockerNum; 
	
	
	
	public int getLockerNum() {
		return lockerNum;
	}

	public void setLockerNum(int lockerNum) {
		this.lockerNum = lockerNum;
	}

	public void setOpener(Opener opener) {
		this.opener = opener;
	}

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
		service = new apiService();
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat formatter= new SimpleDateFormat("MM.dd");
		entryDate.setText(formatter.format(date));
		SimpleDateFormat formatter2= new SimpleDateFormat("HH:mm");
		entryTime.setText(formatter2.format(date));
		
		
		
		
	}

	public void dataProc(String ticketId, String hp, String cardOrHyoun,int lockerNum) {
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
		lockerInt.setText(Integer.toString(lockerNum));
		setLockerNum(lockerNum);
		
	}

	//  확인 버튼
	public void check() {
		Date date = new Date(System.currentTimeMillis());
//		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//		String a = formatter.format(new Date(System.currentTimeMillis()));
//		date = formatter.parse(a);
		LapiDTO api = new LapiDTO();
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
		api.setLockerNum(getLockerNum());
//		
		service.lApiProc2(api);
		
		CommonService.msg("결제 되었습니다.");
		opener.homeChangeOpen();
		System.out.println("메인 화면으로 이동");
	}
	
	// 취소 버튼
	public void cancle() {
		System.out.println("pay화면으로 이동");
		opener.homeChangeOpen();
	}

}

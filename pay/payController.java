package pay;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;

public class payController implements Initializable {
	@FXML
	ToggleButton button1;
	@FXML
	ToggleButton button2;
	@FXML
	ToggleButton button3;
	@FXML
	ToggleButton button4;
	@FXML
	ToggleButton button5;
	@FXML
	ToggleButton button6;
	@FXML
	TextField memberId;

	private payService service;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		service = new payService();
		memberId.setText("010");
		memberId.textProperty().addListener((a, before, after) -> {
			String result = idLengthCheck(after);
			memberId.setText(result);
		});

	}

	// 아이디 길이 "010"빼고 8자리
	public String idLengthCheck(String userId) {
		if (userId.length() > 11) {
			return userId.substring(0, 11);
		}
		return userId;

	}

	//  현금결제 버튼
	public void payProc() {
		payDTO pay = new payDTO();

		pay.setMemberId(memberId.getText());
		//시간 = 분단위
		if (button1.isSelected()) {
			pay.setMemberTime(120);
			pay.setPrice(4000);
		} else if (button2.isSelected()) {
			pay.setMemberTime(180);
			pay.setPrice(6000);
		} else if (button3.isSelected()) {
			pay.setMemberTime(240);
			pay.setPrice(7000);
		} else if (button4.isSelected()) {
			pay.setMemberTime(360);
			pay.setPrice(9000);
		} else if (button5.isSelected()) {
			pay.setMemberTime(540);
			pay.setPrice(11000);
		} else if (button6.isSelected()) {
			pay.setMemberTime(720);
			pay.setPrice(12000);
		}else {
			service.choice(pay);
			return;
		}
		pay.setBuyby("cash");

		service.payProc(pay);
		System.out.println("현금 결제창 이동");
	}
	
	// 카드결제 버튼
	public void cardProc() {
		payDTO pay = new payDTO();

		pay.setMemberId(memberId.getText());

		if (button1.isSelected()) {
			pay.setMemberTime(120);
			pay.setPrice(4000);
		} else if (button2.isSelected()) {
			pay.setMemberTime(180);
			pay.setPrice(6000);
		} else if (button3.isSelected()) {
			pay.setMemberTime(240);
			pay.setPrice(7000);
		} else if (button4.isSelected()) {
			pay.setMemberTime(360);
			pay.setPrice(9000);
		} else if (button5.isSelected()) {
			pay.setMemberTime(540);
			pay.setPrice(11000);
		} else if (button6.isSelected()) {
			pay.setMemberTime(720);
			pay.setPrice(12000);
		}else{
			service.choice(pay);
			return;
		}
		pay.setBuyby("card");
		
		service.payProc(pay);
		System.out.println("카드 결제창 이동");
	}

	// 회원 화면에서 취소 버튼
	public void payCancelProc() {
		System.out.println("이전화면으로");
	}

}

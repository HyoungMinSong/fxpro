package myMain;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import myMain.CommonService;
import myMain.Opener;

public class WpayController implements Initializable {
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
	ToggleButton button7;
	@FXML
	TextField memberId;

	private Opener opener;
	
	public void setOpener(Opener opener) {
		this.opener = opener;
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
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

	// 현금결제 버튼
	   public void payProc() {
	      // 아이디 검증
	      if (memberId.getText().length() != 11) {
	         CommonService.msg("휴대폰번호를 입력하세요.");
	         return;
	      }

	      // 시간 = 분단위
	      if (button1.isSelected()) {
	         opener.mApiOpen("W1", memberId.getText(), "cash");
	      } else if (button2.isSelected()) {
	         opener.mApiOpen("W2", memberId.getText(), "cash");
	      } else if (button3.isSelected()) {
	         opener.mApiOpen("W4", memberId.getText(), "cash");
	      } else if (button4.isSelected()) {
	         opener.mApiOpen("W30", memberId.getText(), "cash");
	      } else if (button5.isSelected()) {
	         opener.mApiOpen("W50", memberId.getText(), "cash");
	      } else if (button6.isSelected()) {
	         opener.mApiOpen("W100", memberId.getText(), "cash");
	      } else if (button7.isSelected()) {
		     opener.mApiOpen("W200", memberId.getText(), "cash");
		  } else {
	         CommonService.msg("상품을 선택해주세요.");
	         return;
	      }

	      System.out.println("현금 결제창 이동");
	   }

	   // 카드결제 버튼
	   public void cardProc() {
	      // 아이디 검증
	      if (memberId.getText().length() != 11) {
	         CommonService.msg("휴대폰번호를 입력하세요.");
	         return;
	      }

	      // 시간 = 분단위
	      if (button1.isSelected()) {
	         opener.mApiOpen("W1", memberId.getText(), "card");
	      } else if (button2.isSelected()) {
	         opener.mApiOpen("W2", memberId.getText(), "card");
	      } else if (button3.isSelected()) {
	         opener.mApiOpen("W4", memberId.getText(), "card");
	      } else if (button4.isSelected()) {
	         opener.mApiOpen("W30", memberId.getText(), "card");
	      } else if (button5.isSelected()) {
	         opener.mApiOpen("W50", memberId.getText(), "card");
	      } else if (button6.isSelected()) {
	         opener.mApiOpen("W100", memberId.getText(), "card");
	      } else if (button7.isSelected()) {
			 opener.mApiOpen("W200", memberId.getText(), "cash");
	      } else {
	         CommonService.msg("상품을 선택해주세요.");
	         return;
	      }

	      System.out.println("카드 결제창 이동");
	   }

	// 회원 화면에서 취소 버튼
	public void payCancelProc() {
		opener.homeChangeOpen();
	}

}

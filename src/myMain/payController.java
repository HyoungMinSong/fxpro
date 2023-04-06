package myMain;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
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
	private Parent payView;

	public void setPayView(Parent payView) {
		this.payView = payView;
	}

	private payService service;
	private Opener opener;
	

	public void setOpener(Opener opener) {
		this.opener = opener;
	}

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

	// 현금결제 버튼
	public void payBtnSelected(ActionEvent e) {
		
		for(int i= 1 ; i<7;i++) {
			String btnName = "#button"+i;
			ToggleButton btn = (ToggleButton) payView.lookup(btnName);
			btn.setStyle("-fx-background-color:#585858");
		}
		
		seatViewService svSer = new seatViewService();
		String btn = svSer.idExtract(e);
		//Button btn2 = (Button) adminSeat.lookup(useSeat);
		//transparent
		ToggleButton btn1 = (ToggleButton) payView.lookup(btn);
		if(btn1.isSelected()) {
			btn1.setStyle("-fx-background-color:#9999FF");
		}
		
	}
	   public void payProc() {
	      // 아이디 검증
	      if (memberId.getText().length() != 11) {
	         CommonService.msg("휴대폰번호를 입력하세요.");
	         return;
	      }

	      // 시간 = 분단위
	      if (button1.isSelected()) {
	         opener.mApiOpen("D2", memberId.getText(), "cash");
	      } else if (button2.isSelected()) {
	         opener.mApiOpen("D3", memberId.getText(), "cash");
	      } else if (button3.isSelected()) {
	         opener.mApiOpen("D4", memberId.getText(), "cash");
	      } else if (button4.isSelected()) {
	         opener.mApiOpen("D6", memberId.getText(), "cash");
	      } else if (button5.isSelected()) {
	         opener.mApiOpen("D9", memberId.getText(), "cash");
	      } else if (button6.isSelected()) {
	         opener.mApiOpen("D12", memberId.getText(), "cash");
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
	         opener.mApiOpen("D2", memberId.getText(), "card");
	      } else if (button2.isSelected()) {
	         opener.mApiOpen("D3", memberId.getText(), "card");
	      } else if (button3.isSelected()) {
	         opener.mApiOpen("D4", memberId.getText(), "card");
	      } else if (button4.isSelected()) {
	         opener.mApiOpen("D6", memberId.getText(), "card");
	      } else if (button5.isSelected()) {
	         opener.mApiOpen("D9", memberId.getText(), "card");
	      } else if (button6.isSelected()) {
	         opener.mApiOpen("D12", memberId.getText(), "card");
	      } else {
	         CommonService.msg("상품을 선택해주세요.");
	         return;
	      }

	      System.out.println("카드 결제창 이동");
	   }
	
	
//	public void dtoTest(ArrayList<PayTodayDTO> list) {
//		for(PayTodayDTO dto : list) {
//			System.out.println(dto.getId());
//			System.out.println(dto.getName());
//			System.out.println(dto.getPrice());
//			System.out.println(dto.getValue());
//		}
//	}

	// 회원 화면에서 취소 버튼
	public void payCancelProc() {
		opener.homeChangeOpen();
	}

	public void setLoader() {
		// TODO Auto-generated method stub
		
	}


}

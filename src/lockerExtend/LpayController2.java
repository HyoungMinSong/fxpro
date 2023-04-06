package lockerExtend;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import myMain.CommonService;
import myMain.Opener;
import myMain.seatViewService;

public class LpayController2 implements Initializable {
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
	private LpayService2 service;
	private Parent payView;

	
	
	public void setPayView(Parent payView) {
		this.payView = payView;
	}
	public void setOpener(Opener opener) {
		this.opener = opener;
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		memberId.textProperty().addListener((a, before, after) -> {
			String result = idLengthCheck(after);
			memberId.setText(result);
		});
		service = new LpayService2();
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
	    	  String selectedId =memberId.getText();
	    	  int lockerNum = seatCheck(selectedId);
	    	  if(lockerNum != 0 ) {
	    		  opener.lApiOpen2("L1", selectedId, "cash", lockerNum);
	    	  } else {
	    		  CommonService.msg("이용권을 먼저 구매해주세요 ");
	 	         return;
	    	  }
	      } else if (button2.isSelected()) {
	    	  String selectedId =memberId.getText();
	    	  int lockerNum = seatCheck(selectedId);
	    	  if(lockerNum != 0 ) {
	    		  opener.lApiOpen2("L2", selectedId, "cash", lockerNum);
	    	  } else {
	    		  CommonService.msg("이용권을 먼저 구매해주세요 ");
	 	         return;
	    	  }
	      } else if (button3.isSelected()) {
	    	  String selectedId =memberId.getText();
	    	  int lockerNum = seatCheck(selectedId);
	    	  if(lockerNum != 0 ) {
	    		  opener.lApiOpen2("L4", selectedId, "cash", lockerNum);
	    	  } else {
	    		  CommonService.msg("이용권을 먼저 구매해주세요 ");
	 	         return;
	    	  }
	      } else if (button4.isSelected()) {
	    	  String selectedId =memberId.getText();
	    	  int lockerNum = seatCheck(selectedId);
	    	  if(lockerNum != 0 ) {
	    		  opener.lApiOpen2("L30", selectedId, "cash", lockerNum);
	    	  } else {
	    		  CommonService.msg("이용권을 먼저 구매해주세요 ");
	 	         return;
	    	  }
	      } else if (button5.isSelected()) {
	    	  String selectedId =memberId.getText();
	    	  int lockerNum = seatCheck(selectedId);
	    	  if(lockerNum != 0 ) {
	    		  opener.lApiOpen2("L50", selectedId, "cash", lockerNum);
	    	  } else {
	    		  CommonService.msg("이용권을 먼저 구매해주세요 ");
	 	         return;
	    	  }
	      } else if (button6.isSelected()) {
	    	  String selectedId =memberId.getText();
	    	  int lockerNum = seatCheck(selectedId);
	    	  if(lockerNum != 0 ) {
	    		  opener.lApiOpen2("L100", selectedId, "cash", lockerNum);
	    	  } else {
	    		  CommonService.msg("이용권을 먼저 구매해주세요 ");
	 	         return;
	    	  }
	      } else if (button7.isSelected()) {
	    	  String selectedId =memberId.getText();
	    	  int lockerNum = seatCheck(selectedId);
	    	  if(lockerNum != 0 ) {
	    		  opener.lApiOpen2("L200", selectedId, "cash", lockerNum);
	    	  } else {
	    		  CommonService.msg("이용권을 먼저 구매해주세요 ");
	 	         return;
	    	  }
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
	    	  String selectedId =memberId.getText();
	    	  int lockerNum = seatCheck(selectedId);
	    	  if(lockerNum != 0 ) {
	    		  opener.lApiOpen2("L1", selectedId, "card", lockerNum);
	    	  } else {
	    		  CommonService.msg("이용권을 먼저 구매해주세요 ");
	 	         return;
	    	  }
	         
	      } else if (button2.isSelected()) {
	    	  String selectedId =memberId.getText();
	    	  int lockerNum = seatCheck(selectedId);
	    	  if(lockerNum != 0 ) {
	    		  opener.lApiOpen2("L2", selectedId, "card", lockerNum);
	    	  } else {
	    		  CommonService.msg("이용권을 먼저 구매해주세요 ");
	 	         return;
	    	  }
	      } else if (button3.isSelected()) {
	    	  String selectedId =memberId.getText();
	    	  int lockerNum = seatCheck(selectedId);
	    	  if(lockerNum != 0 ) {
	    		  opener.lApiOpen2("L4", selectedId, "card", lockerNum);
	    	  } else {
	    		  CommonService.msg("이용권을 먼저 구매해주세요 ");
	 	         return;
	    	  }
	      } else if (button4.isSelected()) {
	    	  String selectedId =memberId.getText();
	    	  int lockerNum = seatCheck(selectedId);
	    	  if(lockerNum != 0 ) {
	    		  opener.lApiOpen2("L30", selectedId, "card", lockerNum);
	    	  } else {
	    		  CommonService.msg("이용권을 먼저 구매해주세요 ");
	 	         return;
	    	  }
	      } else if (button5.isSelected()) {
	    	  String selectedId =memberId.getText();
	    	  int lockerNum = seatCheck(selectedId);
	    	  if(lockerNum != 0 ) {
	    		  opener.lApiOpen2("L50", selectedId, "card", lockerNum);
	    	  } else {
	    		  CommonService.msg("이용권을 먼저 구매해주세요 ");
	 	         return;
	    	  }
	      } else if (button6.isSelected()) {
	    	  String selectedId =memberId.getText();
	    	  int lockerNum = seatCheck(selectedId);
	    	  if(lockerNum != 0 ) {
	    		  opener.lApiOpen2("L100", selectedId, "card", lockerNum);
	    	  } else {
	    		  CommonService.msg("이용권을 먼저 구매해주세요 ");
	 	         return;
	    	  }
	      } else if (button7.isSelected()) {
	    	  String selectedId =memberId.getText();
	    	  int lockerNum = seatCheck(selectedId);
	    	  if(lockerNum != 0 ) {
	    		  opener.lApiOpen2("L200", selectedId, "card", lockerNum);
	    	  } else {
	    		  CommonService.msg("이용권을 먼저 구매해주세요 ");
	 	         return;
	    	  }
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
	
	
	public int seatCheck(String checkId) {
		return service.seatCheckById(checkId);
	}
	
	public void payBtnSelected(ActionEvent e) {

	      for (int i = 1; i < 8; i++) {
	         String btnName = "#button" + i;
	         ToggleButton btn = (ToggleButton) payView.lookup(btnName);
	         btn.setStyle("-fx-background-color:#585858");
	      }

	      seatViewService svSer = new seatViewService();
	      String btn = svSer.idExtract(e);
	      // Button btn2 = (Button) adminSeat.lookup(useSeat);
	      // transparent
	      ToggleButton btn1 = (ToggleButton) payView.lookup(btn);
	      if (btn1.isSelected()) {
	         btn1.setStyle("-fx-background-color:#6699CC");
	      }
	}
	
	
}

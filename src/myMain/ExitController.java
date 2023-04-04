package myMain;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;


public class ExitController implements Initializable{
	private ExitService service;
	@FXML
	TextField hpNumber;
	
	
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		service = new ExitService();
		hpNumber.textProperty().addListener((a, before, after) -> {
			String result = idLengthCheck(after);
			hpNumber.setText(result);
		});
	
	
	}
	public String idLengthCheck(String userId) {
		if (userId.length() > 11) {
			return userId.substring(0, 11);
		}
		return userId;

	}

	//번호를 누르면 텍스트필드 안에 숫자 값이 들어감
	public void Exit1() {
		String a = hpNumber.getText() + "1";
		hpNumber.setText(a);
	}
	public void Exit2() {
		String a = hpNumber.getText() + "2";
		hpNumber.setText(a);
	}
	public void Exit3() {
		String a = hpNumber.getText() + "3";
		hpNumber.setText(a);
	}
	public void Exit4() {
		String a = hpNumber.getText() + "4";
		hpNumber.setText(a);
	}
	public void Exit5() {
		String a = hpNumber.getText() + "5";
		hpNumber.setText(a);
	}
	public void Exit6() {
		String a = hpNumber.getText() + "6";
		hpNumber.setText(a);
	}
	public void Exit7() {
		String a = hpNumber.getText() + "7";
		hpNumber.setText(a);
	}
	public void Exit8() {
		String a = hpNumber.getText() + "8";
		hpNumber.setText(a);
	}
	public void Exit9() {
		String a = hpNumber.getText() + "9";
		hpNumber.setText(a);
	}
	public void Exit0() {
		String a = hpNumber.getText() + "0";
		hpNumber.setText(a);
	}
	public void exitCheck() {
		String member_id = hpNumber.getText();
		String result = service.seatUse(member_id);
		Alert at = new Alert(AlertType.INFORMATION);
		at.setHeaderText("등록 정보");
		if(result != null && result.equals("Y")) {
			long min = service.getTime(member_id);
			String time = service.memberCheck(member_id);
			long a = Long.parseLong(time)-min;
			if (service.updateMember(a,member_id) != 0) {
				
				service.exitCheck(member_id);
				service.accessInsert(member_id);
				at.setContentText("퇴실 완료!");
			} else {
				at.setContentText("업데이트 실패");
			}
			
			
			
			
		}else {
			at.setContentText("등록된 핸드폰번호가 아닙니다.");
			hpNumber.setText("010");
		}
		
		at.show();
	}

}
	
	
	

	









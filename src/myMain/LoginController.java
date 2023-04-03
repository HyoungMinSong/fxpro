package myMain;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class LoginController implements Initializable{
	@FXML TextField hpNumber;
//	@FXML PasswordField pw;
//	private LoginService service;
//	private Stage primaryStage;
//	private Opener opener;
	private LoginService service;
	private Stage primaryStage;
	private Opener opener;
//	private payService pService;
	
	

	public void setOpener(Opener opener) {
		this.opener = opener;
	}

	public void todayTicket() {
		System.out.println("당일 이용권 씬 넣기");
		opener.TodayTicketOpen();
	}
	
	public void seasonTicket() {
		System.out.println("정기 이용권 씬 넣기");
	}
	
	public void lockerTicket() {
		System.out.println("사물함 이용권 씬 넣기");
		opener.lockerTicketOpen();
	}
	
	public void seatChange() {
		System.out.println("자리이동 씬 넣기");
		opener.seatChangeOpen();
	}
	
	public void timeExtend() {
		System.out.println("연장하기 씬 넣기");
		opener.timeExtendOpen();
	}
	
	public void seatCheckOut() {
		System.out.println("퇴실하기 씬 넣기");
	}
	
	public void enter() { //입장하기 정기권사용 버튼
		String id = hpNumber.getText();
		System.out.println("테스트");
		System.out.println(id);
		LoginDTO dto = service.seatLoginCheck(id); // id를 가지고 회원정보와 이용권 시간이 남아있는지 확인.
		Alert at = new Alert(AlertType.INFORMATION);
		at.setHeaderText("로그인 정보");
		if (dto == null) {
			at.setContentText("등록된 회원 정보가 없습니다.");
		} else {
			if(dto.getRemainTime() == 0) {
				at.setContentText("남은 이용권 시간이 없습니다.");
			} else {
				at.setContentText("로그인 성공");
				System.out.println("이용권 사용 씬 넣기");
				opener.seatSelectOpen(id);
			}
		}
		
		at.show();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		service = new LoginService();
//		pService = new payService();
	}
}

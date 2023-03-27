package ex5;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable{
	@FXML TextField id;
	@FXML PasswordField pw;
	private LoginService service;
	private Stage primaryStage;
	private Opener opener;
	
//	public void setPrimaryStage(Stage primaryStage) {
//		this.primaryStage = primaryStage;
//	}
	
	public void setOpener(Opener opener) {
		this.opener = opener;
	}
	// 로그인 버튼 
	public void loginProc(){	
		/*
		 LoginService Class를 생성하고, Method를 loginProc을 구현하세요.
		 LoginDAO Class를 생성하고, Method를 LoginProc을 구현하세요.
		 DAO는 데이터베이스 접근
		 Service는 데이터(입력 값) 검증
		 
		 출력 : 로그인 성공 또는 실패 Alert를 출력하기
		 Table Name : javaFx
		 Column Name : id, pw, name, gender(성별), hobbys(취미)
		 */
		service.loginProc(id,pw); 
		String result = service.loginCheck(id.getText()); //로그인 여부 확인
		if(result != null && result.equals("Y")) {
			opener.menuOpen();
		}
		
	}
	
	// 취소 버튼
	public void cancelProc(){	
		id.clear();
		pw.clear();
		id.requestFocus();// 해당 텍스트로 포커스
	}
	// 가입 버튼
	public void regProc(){	//새로운 창(스테이지 생성)
		opener.regOpen();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		service = new LoginService();
	}
}

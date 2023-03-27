package ex5;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class RegController implements Initializable{
	
	@FXML TextField name;
	@FXML TextField id;
	@FXML PasswordField pw;
	@FXML PasswordField confirm;
	@FXML ToggleGroup gender;
	@FXML ComboBox<String> ageCombo;
	@FXML CheckBox musicCheck;
	@FXML CheckBox sportCheck;
	@FXML CheckBox movieCheck;
	private RegService service;
	public RegDto dto;
	private Parent RegForm;
	private Stage stage;
	
	public void setRegForm(Parent regForm) {
		RegForm = regForm;
	}
	
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	// 회원 가입 버튼 
	
	public void regProc() {
		
		System.out.println(name);
//		System.out.println(name.getText());
		System.out.println("abcd");
		dto.setName(name.getText());
		dto.setId(id.getText());
		dto.setPw(pw.getText());
		dto.setPwCf(confirm.getText());
		RadioButton tog = (RadioButton)gender.getSelectedToggle();
		dto.setSex(tog.getText());
		dto.setAgeGroup(ageCombo.getValue());
		ArrayList<String> list = new ArrayList<String>();
		if(musicCheck.isSelected()){
			System.out.println(musicCheck);
			System.out.println(musicCheck.getText());

			list.add(musicCheck.getText());
		}
		if(sportCheck.isSelected()){
			list.add(sportCheck.getText());
		}		
		if(movieCheck.isSelected()){
			list.add(movieCheck.getText());
		}
		dto.setHobby(list);
		service.regProc(dto);
		/*
		 javafx 테이블에 age_group 컬럼을 추가
		 regService.regProc() Method
		  - 데이터 전달
		 regDAO.regProc() Method
		  - 입력 데이터 검증, 아이디 중복 체크
		  - javafx 테이블에 데이터 입력
		 */
	}
	
	// 회원 화면에서 취소 버튼
	public void regCancelProc() {
		CommonService.windowsClose(RegForm);	//다른 곳에서도 편하게 사용하기 위해 스태틱 메소드를 만든  커먼서비스에서 호출하기.
//		CommonService.windowsClose(stage); //스테이지만 넣어도 가능.
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		service = new RegService();
		dto = new RegDto();
	}
}

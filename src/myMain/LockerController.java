package myMain;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Parent;


public class LockerController implements Initializable{
	private LockerService service;
	private Parent locker;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		service = new LockerService();
	}
	
	public void setLockerForm(Parent lockerForm) {
		this.locker = lockerForm;
		
	}
	
	//사물함 이용권 화면에 버튼들에 회색을 입힘
	public void startLocker(){	
		service.startLocker(locker);
	
	}
	
	//버튼을 눌렀을때 화면의 색을 변경 시켜줌
	public void buttonSelect(ActionEvent e) {
		service.buttonSelect(e,locker);
		
	}
	


}









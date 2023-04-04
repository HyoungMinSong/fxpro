package myMain;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Parent;


public class LockerController implements Initializable{
	private LockerService service;
	private Parent locker;
	private String btnId;
	private Opener opener;
	
	
	
	public void setOpener(Opener opener) {
		this.opener = opener;
	}
	
	
	public void setBtnId(String btnId) {
		this.btnId = btnId;
	}

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
		String btnSelectedId = service.buttonSelect(e,locker);
		String btnVal = btnSelectedId.substring(5);
		setBtnId(btnVal);
		
	}
	
	public void NextPayProc() {
		System.out.println(btnId);
		if(service.checkLocker(btnId)) { //해당 락커 시트에 값이 있으면 false
			opener.LPayOPen(btnId);
		} else {
			CommonService.msg("이미 사용중인 사물함입니다.");
		}
	}
	
	public void LockerCancelProc() {
		opener.homeChangeOpen();
	}
	


}









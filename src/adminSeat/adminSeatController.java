package adminSeat;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import myMain.Opener;

public class adminSeatController implements Initializable{
	private adminSeatService adSer ;
	private Parent adminMain ;
	private Opener opener;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		adSer = new adminSeatService();
	}
	public void setView(Parent adminMain) {
		this.adminMain = adminMain;
	}
	public void setSeatView(Parent adminMain) {
		// TODO Auto-generated method stub
		this.adminMain = adminMain;
	}
	
	public void startSeat(Parent adminSeat) { //처음에 화면에 뿌려줄 데이터 .
		adSer.startSeat(adminSeat);
	}
	//버튼을 눌렀을때 action처리
	public void buttonSelect(ActionEvent e) {
		adSer.buttonSelect(e,adminMain);
		
	}
	public void adminPlusTime() {
		adSer.adminEnterTimePlus();
	}
	public void adminExit() {
		adSer.adminExit();
	}
	public void adminEnterTimePlus() {
		adSer.adminEnterTimePlus();
	}
	public void adminSeatMove() {
		adSer.adminSeatMove();
	}
	public void setOpener(Opener opener) {
		// TODO Auto-generated method stub
		this.opener = opener;
	}
    public void accessBtn() {
    	opener.accessOpen();
    }
    
    public void blackBtn() {
    	opener.blackOpen();
    }
    
	public void homeBtn() {
		opener.homeChangeOpen();
	}
	
	public void buyBtn() {
		opener.buyPageOpen();
	}

}

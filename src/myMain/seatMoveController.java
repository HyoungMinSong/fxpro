package myMain;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class seatMoveController implements Initializable{
	private seatMoveService service;
	private Stage primaryStage;
	private Button btn ;
	private Parent seatMove;
	private Opener opener;
	public void setOpener(Opener opener) {
		this.opener = opener;
	}

	public seatMoveService getService() {
		return service;
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		service = new seatMoveService();
	}
	public void setSeatMove(Parent seatMove) {
		this.seatMove = seatMove;
	}
	//초기 화면을 불러왔을때 버튼에 색을 입힘
	public void startSeat(String member_id, Opener opener2) {
		service.startSeat(seatMove,member_id,opener2);
		
	}
	//버튼을 눌렀을때 화면의 색을 변경 시켜줌
	public void buttonSelect(ActionEvent e) {
		service.buttonSelect(e,seatMove);
	}
	
	// Change버튼 눌렀을 때
	public void seatNext() {
		service.seatChange(seatMove);
	}
	
	public void prevBtn() { //이전으로 버튼
		opener.homeChangeOpen();
	}
	
	
}

package myMain;

import java.io.IOException;
import java.net.URL;
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

public class SeatChangeFormController implements Initializable{
	@FXML TextField hpNumber;
	private Stage primaryStage;
	private Opener opener;
	
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	public void setOpener(Opener opener) {
		this.opener = opener;
	}
	
	public void prevBtn() {
		opener.homeChangeOpen();
	}
	public void nextBtn() {
		String member_id=hpNumber.getText();
		//자리이동(전화번호입력 화면)에서 번호를 
		CommonDAO cmDAO = new CommonDAO();
		boolean dataUseCheck = cmDAO.checkUser(member_id);
		if(dataUseCheck) {
			opener.seatMove(member_id);
			
		}else if(dataUseCheck==false) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("알림");
	        alert.setContentText("사용하지 않는 유저입니다. 입장하기를 선택해주세요");
	        alert.show();
			
		}
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}



}

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

public class TimeExtendController implements Initializable{
//	@FXML TextField hpNumber;
	private Opener opener;
	
	public void setOpener(Opener opener) {
		this.opener = opener;
	}

	public void todayTicketExtend() {
		System.out.println("당일 이용권 연장 씬 넣기");
	}
	
	public void seasonTicketExtend() {
		System.out.println("정기 이용권 연장 씬 넣기");
	}
	
	public void lockerTicketExtend() {
		System.out.println("사물함 이용권 연장 씬 넣기");
	}
	
	public void prevBtn() {
		System.out.println("사물함 이용권 연장 씬 넣기");
		opener.homeChangeOpen();
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}
}

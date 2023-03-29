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
		System.out.println(123);
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}



}

package myMain;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class seatViewController implements Initializable{
	
	private seatViewService service;
	private Stage primaryStage;
	private Button btn ;
	private Parent seatView;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		service = new seatViewService();
		System.out.println("hi~");
		
	}
	public void setSeatView(Parent seatView) {
		// TODO Auto-generated method stub
		this.seatView = seatView;
	}
	
	//초기 화면을 불러왔을때 버튼에 색을 입힘
	public void startSeat() {
		service.startSeat(seatView);
		
	}
	//버튼을 눌렀을때 화면의 색을 변경 시켜줌
	public void buttonSelect(ActionEvent e) {
		service.buttonSelect(e,seatView);
		
	}
	
	
	
	
	
           
   
	
	

}

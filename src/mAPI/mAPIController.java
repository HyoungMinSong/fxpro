package mAPI;

import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;

public class mAPIController implements Initializable {
	@FXML
	Label entryDate;
	@FXML
	Label entryTime;
	@FXML
	Label productName;
	@FXML
	Label payment;
	@FXML
	Label exitTime;
	@FXML
	TextField entryPrice;
	private payDTO paydto;
	private apiService service;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		paydto = new payDTO();
		service = new apiService();
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat formatter= new SimpleDateFormat("MM.dd");
		entryDate.setText(formatter.format(date));
		SimpleDateFormat formatter2= new SimpleDateFormat("HH:mm");
		entryTime.setText(formatter2.format(date));
		
		productName.setText((paydto.getMemberTime()/60)+"시간");
		payment.setText(paydto.getPrice()+"원");
	}


	//  확인 버튼
	public void check() {
		Date date = new Date(System.currentTimeMillis());
		apiDTO api = new apiDTO();
		api.setBuyname(productName.getText());
		api.setEntrydate(date);
		api.setMemberId(paydto.getMemberId());
		api.setMemberTime(productName.getText());
		api.setPrice(paydto.getPrice());
		api.setEntryprice(Integer.parseInt(entryPrice.getText()));
		api.setBuyby(paydto.getBuyby());
//		
		service.apiProc(api);
		System.out.println("메인 화면으로 이동");
	}
	
	// 취소 버튼
	public void cancle() {
		System.out.println("pay화면으로 이동");
	}

}

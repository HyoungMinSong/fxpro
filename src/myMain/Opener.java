package myMain;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class Opener {
	private Stage primaryStage;
	private FXMLLoader homeloader; //홈 fmxl 로더
	private Parent loginForm;
	private Scene sceneHome;
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	public void setScene(Scene scene) {
		this.sceneHome = scene;
	}
	
//	public void regOpen() {
//		
//	Stage regStage = new Stage(); //매개변수로 받는 스테이지가 없으므로 스테이지 생성.
//	FXMLLoader loader = new FXMLLoader(getClass().getResource("regForm.fxml"));
//	Parent regForm=null;
//	try {
//		regForm = loader.load();
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	
//	RegController regCon = loader.getController(); //회원등록 컨트롤러에 해당 Parent를 넣어야 하기 때문에 컨트롤러 찾으면서
//	regCon.setRegForm(regForm);	//세터를 통해 Parent 넣기.
////	regCon.setStage(regStage); //걍 스테이지 넣어도 되네 ?
//	
//	ComboBox<String> cb = (ComboBox<String>)regForm.lookup("#ageCombo");
//	cb.getItems().addAll("10대 이하","20대","30대","40대","50대","60대 이상");
//	Scene scene = new Scene(regForm);
//	regStage.setTitle("회원가입 화면");
//	regStage.setScene(scene);
//	regStage.show();
//	
//}
//	
//	
//	public void menuOpen() {
//		//로그인 화면의 Stage에 Menu.fxml 화면을 실행하겠다.
//		
//				FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
//				Parent menuForm = null;
//				
//				try {
//					menuForm = loader.load();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//				
//				Scene scene = new Scene(menuForm);  //원래 있던 스테이지(메인 스테이지)에 따른 씬 넣기.
//				primaryStage.setTitle("메인 화면");
//				primaryStage.setScene(scene);
//				primaryStage.show();
//				
//	}



	public void seatChangeOpen() { //자리이동 보기
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader(getClass().getResource("seatchangeForm2.fxml"));
		Parent seatchangeForm = null;
		System.out.println(loader);
		try {
			seatchangeForm = loader.load();
			System.out.println("seatchangeForm" + seatchangeForm);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SeatChangeFormController lc = loader.getController();
		System.out.println(lc);
		lc.setOpener(this);
		
		Scene scene = new Scene(seatchangeForm);  //원래 있던 스테이지(메인 스테이지)에 따른 씬 넣기.
		primaryStage.setTitle("자리 이동");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void homeChangeOpen() { //로그인 화면을 보기
		// TODO Auto-generated method stub
//		System.out.println("테스트트트");
		try {
//			FXMLLoader loader = new FXMLLoader(getClass().getResource("loginForm2.fxml"));
//			Parent loginForm = homeloader.load();
//			System.out.println("로그인폼 확인 : " + loginForm);
//			Scene scene = new Scene(loginForm);
			primaryStage.setTitle("로그인 화면");
			primaryStage.setScene(sceneHome);
			primaryStage.show();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
	}

	public void seatSelectOpen(String id) {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader(getClass().getResource("seatView.fxml"));
		
		Parent seatViewForm = null;
		try {
			seatViewForm = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		seatViewController sv = loader.getController();
		
		sv.setSeatView(seatViewForm);
		sv.startSeat(id);
		
		Scene scene = new Scene(seatViewForm);  //원래 있던 스테이지(메인 스테이지)에 따른 씬 넣기.
		primaryStage.setTitle("자리 이동");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void TodayTicketOpen() {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader(getClass().getResource("pay.fxml"));
		
		Parent TodayTicketOpenForm = null;
		try {
			TodayTicketOpenForm = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		payController pc = loader.getController();
		pc.setOpener(this);
		
		Scene scene = new Scene(TodayTicketOpenForm);  //원래 있던 스테이지(메인 스테이지)에 따른 씬 넣기.
		primaryStage.setTitle("자리 이동");
		primaryStage.setScene(scene);
		primaryStage.show();
	}



			
}

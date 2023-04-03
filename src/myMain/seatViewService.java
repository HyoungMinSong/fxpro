package myMain;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import myMain.seatViewDAO;
import myMain.seatViewDTO;

public class seatViewService {
	private seatViewDAO dao;
	private String seatInfoData;
	//private timeCalc tcl = new timeCalc();

	public seatViewService() {
		seatViewDAO dao = new seatViewDAO();
		this.dao = dao ;
	}
	
	public ArrayList<seatViewDTO> selectUseSeat() {
		return dao.selectUseSeat();
	}
	//Fx:id 를 추출하는 메소드
	public String idExtract(ActionEvent e) {
		String idData = e.getSource().toString();
		System.out.println(e.getSource());
		String tmp[] = idData.split("=");
		String b = tmp[1];
		String tmp2[] = b.split(",");
		String fxId= "#"+tmp2[0]; 
		System.out.println("fx:id는 : " +fxId);
		
		return fxId;
	}
	
	public void startSeat(Parent seatView, String member_id) {
		ArrayList<seatViewDTO> dataList = selectUseSeat(); //사용중인 좌석을 가져와서
		for(int i = 1 ; i <25;i++) {
			String seat = "#s"+i;
			Button btn =(Button)seatView.lookup(seat);
			btn.setStyle("-fx-background-color:#D3D3D3;"+"-fx-border-color:BLACK");
			btn.setPrefSize(70, 70);
		}
		
		for(seatViewDTO data : dataList) {//////Orange//////
			//사용중이지 않은 데이터를 가져와야함.
			String seatName = data.getSeat_num();
			String useSeat = "#"+seatName;
			String memberNum = data.getMember_id();
			String member_time = data.getMember_time(); //잔여시간
			System.out.println("seatName :" + seatName +" memberNum : "+ memberNum + " member_time : "+ member_time);
			Button btn2 =(Button)seatView.lookup(useSeat);
			btn2.setStyle("-fx-background-color:ORANGE;"+"-fx-border-color:BLACK");
			btn2.setText(member_time+"분");
			btn2.setPrefSize(70, 70);
			
			//member_time 으로 남은 시간을 구하는 로직.
			CommonService cser = new CommonService();
			boolean flag = cser.before5Min(memberNum); //5분남았는지 아닌지 판별함.
			if(flag==true) {
				btn2.setStyle("-fx-background-color:RED;"+"-fx-border-color:BLACK");
				btn2.setPrefSize(70, 70);
			}
			
		}/////////////////////////////////////Orange//////
		
		TextField member_id_field = (TextField)seatView.lookup("#member_id_field");
		TextField member_time_info = (TextField)seatView.lookup("#member_time_info");
		member_id_field.setText(member_id);
		
		String member_time =dao.getMember_time(member_id);
		System.out.println("여긴가 ? " + member_time);
		member_time_info.setText(member_time);
	}//startSeat

	public void buttonSelect(ActionEvent e,Parent seatView) {
		ArrayList<seatViewDTO> dataList = selectUseSeat();//arrayList
		for(int i = 1 ; i <25;i++) {
			String seat = "#s"+i;
			Button btn =(Button)seatView.lookup(seat);
			btn.setStyle("-fx-background-color:#D3D3D3;"+"-fx-border-color:BLACK");
			btn.setPrefSize(70, 70);
		}
		
		for(seatViewDTO data : dataList) {
			//사용중이지 않은 데이터를 가져와야함.
			String useSeat = "#"+data.getSeat_num();
			String member_id = data.getMember_id();
			String member_time = data.getMember_time();
			Button btn2 =(Button)seatView.lookup(useSeat);
			btn2.setStyle("-fx-background-color:ORANGE;"+"-fx-border-color:BLACK");
			btn2.setPrefSize(70, 70);
			CommonService cser = new CommonService();
			
			boolean flag = cser.before5Min(member_id); //5분남았는지 아닌지 판별함.
			if(flag==true) {
				btn2.setStyle("-fx-background-color:RED;"+"-fx-border-color:BLACK");
				btn2.setText(member_time+"분");
				btn2.setPrefSize(70, 70);
			}
		}
		
		String ButtonfxId = idExtract(e);
		Button btn = (Button)seatView.lookup(ButtonfxId);
		btn.setStyle("-fx-background-color:#6699CC;"+"-fx-border-color:BLACK");
		btn.setPrefSize(70, 70);
		//우측 하단 TextField (seatInfo) 에 나오게 함
		TextField seatInfo = (TextField)seatView.lookup("#seatInfo");
		ButtonfxId =  ButtonfxId.replaceAll("#", "");
		seatInfo.setText(ButtonfxId);
		
		//////
		this.seatInfoData = ButtonfxId;
		System.out.println("seatinfoData 는 ? " +  seatInfoData);
		
	}
	
	public void seatNext(Parent seatView) { //seatNext 버튼을 눌렀을때 
		/*
		TextField member_id_field = (TextField)seatView.lookup("#member_id_field");
		TextField seatInfo = (TextField)seatView.lookup("seatInfo");
		*/
		
		String YN = dao.checkSeatUse(seatInfoData); //buttonSelect 메소드를 실행하면 seatInfoData 값이 바뀜 
		if(YN.equals("Y")) {
			Alert alert = new Alert(AlertType.INFORMATION);
			String contentText = "이미 사용중인 좌석입니다.";
			alert.setHeaderText("알림");
			alert.setContentText(contentText);
			alert.show();
		}else if(YN.equals("N")) {
			/*
			 opener 구현할 곳  
			 next 버튼을 눌렀을때 사용중일경우 위의 조건식이 실행되어 알림메세지가 뜨고, 
			 자리가 비었다면 해당 창이 실행 됨 
			 */
			
			/////////////데이터 넘기기 및 입장시간 출력 ///////////////
			TextField member_id_field = (TextField)seatView.lookup("#member_id_field");
			String member_id = member_id_field.getText();
			TextField member_time_field =(TextField)seatView.lookup("#member_time_info");
			String member_time = member_time_field.getText();
			System.out.println("seatinfoData 는seatNext메소드에서 ? " +  seatInfoData);
			dao.InsertSeatData(member_id, seatInfoData);
			dao.Update_limit_time(member_id); //남은 시트 시간을 업데이트함.
		}
	}

}

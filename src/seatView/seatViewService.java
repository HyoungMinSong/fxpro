package seatView;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class seatViewService {
	private seatViewDAO dao;
	public seatViewService() {
		seatViewDAO dao = new seatViewDAO();
		this.dao = dao ;
	}
	
	public ArrayList<seatViewDTO> selectUseSeat() {
		return dao.selectUseSeat();
	}

	public void startSeat(Parent seatView,String member_id) {
		ArrayList<seatViewDTO> dataList = selectUseSeat(); //사용중인 좌석을 가져와서
		for(int i = 1 ; i <25;i++) {
			String seat = "#s"+i;
			Button btn =(Button)seatView.lookup(seat);
			btn.setStyle("-fx-background-color:#D3D3D3;"+"-fx-border-color:BLACK");
		
		}
		
		for(seatViewDTO data : dataList) {
			//사용중이지 않은 데이터를 가져와야함.
			String useSeat = "#"+data.getSeat_num();
			System.out.println("useSeat 는 ? " + useSeat);
			Button btn2 =(Button)seatView.lookup(useSeat);
			btn2.setStyle("-fx-background-color:ORANGE;"+"-fx-border-color:BLACK");
		}
		TextField member_id_field = (TextField)seatView.lookup("#member_id_field");
		member_id_field.setText(member_id);
	}

	public void buttonSelect(ActionEvent e,Parent seatView) {
		ArrayList<seatViewDTO> dataList = selectUseSeat();//arrayList
		for(int i = 1 ; i <25;i++) {
			String seat = "#s"+i;
			Button btn =(Button)seatView.lookup(seat);
			btn.setStyle("-fx-background-color:#D3D3D3;"+"-fx-border-color:BLACK");
		
		}
		
		for(seatViewDTO data : dataList) {
			//사용중이지 않은 데이터를 가져와야함.
			String useSeat = "#"+data.getSeat_num();
			System.out.println("useSeat 는 ? " + useSeat);
			Button btn2 =(Button)seatView.lookup(useSeat);
			btn2.setStyle("-fx-background-color:ORANGE;"+"-fx-border-color:BLACK");
		}
		
		String ButtonfxId = idExtract(e);
		Button btn = (Button)seatView.lookup(ButtonfxId);
		btn.setStyle("-fx-background-color:BLUE;"+"-fx-border-color:BLACK");
		
		//우측 하단 TextField (seatInfo) 에 나오게 함
		TextField seatInfo = (TextField)seatView.lookup("#seatInfo");
		ButtonfxId =  ButtonfxId.replaceAll("#", "");
		seatInfo.setText(ButtonfxId);
		
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
	
	
	

}

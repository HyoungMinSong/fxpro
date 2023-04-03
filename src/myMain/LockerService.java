package myMain;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Button;


public class LockerService {
	private LockerDAO dao;
	public LockerService() {
		LockerDAO dao = new LockerDAO();
		this.dao = dao;
	}
	
	private ArrayList<LockerDTO> selectUseLocker() {
		
		return dao.selectUseLocker();
	}
	
	public void startLocker(Parent locker) {
	ArrayList<LockerDTO> dataList = selectUseLocker();// 사용중인 사물함을 가져옴
	for(int i = 1 ; i < 21;i++) {
		String lock = "#lock"+i;
		Button btn =(Button)locker.lookup(lock);
		btn.setStyle("-fx-background-color:#D3D3D3;"+"-fx-border-color:BLACK");
	
	}
	for(LockerDTO data : dataList) {
		//사용중이지 않은 데이터를 가져와야함.
		String useLocker = "#lock"+data.getLocker_num();
		System.out.println("useLocker 는 ? " + useLocker);
		Button btn2 =(Button)locker.lookup(useLocker);
		btn2.setStyle("-fx-background-color:ORANGE;"+"-fx-border-color:BLACK");
	}

		
	}
	public void buttonSelect(ActionEvent e,Parent locker) {
		ArrayList<LockerDTO> dataList = selectUseLocker();//arrayList
		for(int i = 1 ; i <21;i++) {
			String lock = "#lock"+i;
			Button btn =(Button)locker.lookup(lock);
			btn.setStyle("-fx-background-color:#D3D3D3;"+"-fx-border-color:BLACK");
		
		}
		for(LockerDTO data : dataList) {
			//사용중이지 않은 데이터를 가져와야함.
			String useLocker = "#lock"+data.getLocker_num();
			System.out.println("useLocker 는 ? " + useLocker);
			Button btn2 =(Button)locker.lookup(useLocker);
			btn2.setStyle("-fx-background-color:ORANGE;"+"-fx-border-color:BLACK");
		}
		
		String ButtonfxId = idExtract(e);
		Button btn = (Button)locker.lookup(ButtonfxId);
		btn.setStyle("-fx-background-color:BLUE;"+"-fx-border-color:BLACK");
		
		
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

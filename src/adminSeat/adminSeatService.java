package adminSeat;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Alert.AlertType;
import myMain.CommonDTO;
import myMain.CommonService;
import myMain.ExitService;
import myMain.seatViewDTO;

public class adminSeatService {
	private adminSeatDAO adDAO;
	private String seatInfoData;
	private String prevSeat;
	private boolean moveSelect = false;

	public void setPrevSeat(String prevSeat) {
		this.prevSeat = prevSeat;
	}

	@FXML
	TextField member_idField;
	
	private Parent adminSeat1;

	public void setAdminSeat1(Parent adminSeat) {
		this.adminSeat1 = adminSeat;
	}

	public adminSeatService() {
		adminSeatDAO adDAO = new adminSeatDAO();
		this.adDAO = adDAO;
	}

	// Fx:id 를 추출하는 메소드
	public String idExtract(ActionEvent e) {
		String idData = e.getSource().toString();
		// System.out.println(e.getSource());
		String tmp[] = idData.split("=");
		String b = tmp[1];
		String tmp2[] = b.split(",");
		String fxId = "#" + tmp2[0];
		// System.out.println("idExtract : " + fxId);

		return fxId;
	}

	public ArrayList<seatViewDTO> selectUseSeat() {
		return adDAO.selectUseSeat();
	}

	public void startSeat(Parent adminSeat) {
		setAdminSeat1(adminSeat);

		for (int i = 1; i < 25; i++) {
			String seat = "#s" + i;
			Button btn = (Button) adminSeat.lookup(seat);
			btn.setStyle("-fx-background-color:#D3D3D3;" + "-fx-border-color:BLACK");
			btn.setPrefSize(70, 70);
		}

		ArrayList<seatViewDTO> dataList = selectUseSeat();
		for (seatViewDTO data : dataList) {////// Orange//////
			// 사용중이지 않은 데이터를 가져와야함.
			String seatName = data.getSeat_num();
			String useSeat = "#" + seatName;
			String memberNum = data.getMember_id();
			String member_time = data.getMember_time(); // 잔여시간
			System.out.println("seatName :" + seatName + " memberNum : " + memberNum + " member_time : " + member_time);
			Button btn2 = (Button) adminSeat.lookup(useSeat);

			btn2.setStyle("-fx-background-color:ORANGE;" + "-fx-border-color:BLACK");
			btn2.setText(member_time + "분");
			btn2.setPrefSize(70, 70);

			// member_time 으로 남은 시간을 구하는 로직.
			CommonService cser = new CommonService();
			CommonDTO cmDTO = new CommonDTO();
			cmDTO = cser.before5Min(memberNum); // 5분남았는지 아닌지 판별함.
			String colorCode = cmDTO.getColor();

			if (colorCode.equals("0")) {
				btn2.setStyle("-fx-background-color:RED;" + "-fx-border-color:BLACK");
				btn2.setPrefSize(70, 70);
			}
		} //////////////// Orange//////
	}// StartSeat

	public void buttonSelect(ActionEvent e, Parent adminSeat) {
		System.out.println("/////////////////////////////////");
		System.out.println("moveSELect 는 : ? " + moveSelect);
		
		if(moveSelect==true) {
			//먼저 고친 걸 update해줌
			String seat1 = idExtract(e);
			seat1 =seat1.replace("#", "");
			
			TextField member_idField = (TextField) adminSeat.lookup("#member_idField");
			String member_id1 = member_idField.getText();
			adDAO.updateSeat1(member_id1,seat1);
			/////////////////////////////
			moveSelect=false;
			/////////////////////////////
			System.out.println("member_id1" + member_id1);
			System.out.println("seat1 : " + seat1);
			
			for (int i = 1; i < 25; i++) {
				String seat = "#s" + i;
				Button btn = (Button) adminSeat.lookup(seat);
				btn.setStyle("-fx-background-color:#D3D3D3;" + "-fx-border-color:BLACK");
				String seatnn= Integer.toString(i);
				btn.setText(seatnn);
				btn.setPrefSize(70, 70);
			}
			ArrayList<seatViewDTO> dataList = selectUseSeat();
			for (seatViewDTO data : dataList) {
				// 사용중이지 않은 데이터를 가져와야함.
				String useSeat = "#" + data.getSeat_num();
				String member_id = data.getMember_id();
				String member_time = data.getMember_time();
				Button btn2 = (Button) adminSeat.lookup(useSeat);
				btn2.setText(member_time + "분");
				btn2.setStyle("-fx-background-color:ORANGE;" + "-fx-border-color:BLACK");
				btn2.setPrefSize(70, 70);

				CommonService cser = new CommonService();
				CommonDTO cmDTO = new CommonDTO();
				cmDTO = cser.before5Min(member_id); // 5분남았는지 아닌지 판별함.
				String colorCode = cmDTO.getColor();

				if (colorCode.equals("0")) {
					btn2.setStyle("-fx-background-color:RED;" + "-fx-border-color:BLACK");
					btn2.setPrefSize(70, 70);
				} else if (colorCode.equals("-1")) {//회색
					String btnName = cmDTO.getSeat_Num();
					btnName = "#" + btnName;
					Button btn3 = (Button) adminSeat.lookup(btnName);
					btnName = btnName.replace("#s", "");
					System.out.println("btnName : ? " + btnName);
					btn3.setText(btnName);
					btn3.setStyle("-fx-background-color:#D3D3D3;" + "-fx-border-color:BLACK");
				}
			}
			
			String ButtonfxId = idExtract(e);
			Button btn = (Button) adminSeat.lookup(ButtonfxId);
			this.seatInfoData = ButtonfxId;
			
	}else if (moveSelect == false) {
		System.out.println("여긴 moveselect false 야 ~");
			for (int i = 1; i < 25; i++) {
				String seat = "#s" + i;
				Button btn = (Button) adminSeat.lookup(seat);
				btn.setStyle("-fx-background-color:#D3D3D3;" + "-fx-border-color:BLACK");
				btn.setPrefSize(70, 70);
			}

			ArrayList<seatViewDTO> dataList = selectUseSeat();
			for (seatViewDTO data : dataList) {
				// 사용중이지 않은 데이터를 가져와야함.
				String useSeat = "#" + data.getSeat_num();
				String member_id = data.getMember_id();
				String member_time = data.getMember_time();
				Button btn2 = (Button) adminSeat.lookup(useSeat);
				btn2.setStyle("-fx-background-color:ORANGE;" + "-fx-border-color:BLACK");
				btn2.setPrefSize(70, 70);

				CommonService cser = new CommonService();
				CommonDTO cmDTO = new CommonDTO();
				cmDTO = cser.before5Min(member_id); // 5분남았는지 아닌지 판별함.
				String colorCode = cmDTO.getColor();

				if (colorCode.equals("0")) {
					btn2.setStyle("-fx-background-color:RED;" + "-fx-border-color:BLACK");
					btn2.setPrefSize(70, 70);
				} else if (colorCode.equals("-1")) {
					String btnName = cmDTO.getSeat_Num();
					btnName = "#" + btnName;
					Button btn3 = (Button) adminSeat.lookup(btnName);
					btnName = btnName.replace("#s", "");
					System.out.println("btnName : ? " + btnName);
					btn3.setText(btnName);
					btn3.setStyle("-fx-background-color:#D3D3D3;" + "-fx-border-color:BLACK");
				}
			}

			String ButtonfxId = idExtract(e);
			Button btn = (Button) adminSeat.lookup(ButtonfxId);
			btn.setStyle("-fx-background-color:#6699CC;" + "-fx-border-color:BLACK");
			btn.setPrefSize(70, 70);
			this.seatInfoData = ButtonfxId;
			System.out.println("seatinfoData 는 ? " + seatInfoData);
			System.out.println("===================================");
			/*
			 * 버튼을 눌렀을때 , 해당 member_id를 조회하고, 그 정보를 보이게 할 코드
			 */
			// fx:id는 : #s11
			String seat = ButtonfxId.replaceAll("#", "");
			String member_id = adDAO.findMemberData(seat);
			if (member_id.equals("no")) {// 선택한 좌석이 사람이 없을때
				TextField member_idField = (TextField) adminSeat.lookup("#member_idField");
				TextField enter_timeField = (TextField) adminSeat.lookup("#enter_timeField");
				TextField remain_timeField = (TextField) adminSeat.lookup("#remain_timeField");
				member_idField.clear();
				enter_timeField.clear();
				remain_timeField.clear();
				
			} else {// member_id를 조회해서 , 멤버/잔여시간/입장시간 뿌리기
					// member_idField enter_timeField remain_timeField
				System.out.println("member_id 값은 ? " + member_id);
				String remainTime = adDAO.findRemainTime(member_id); // member 테이블에서 member time(remainTime)가져옴
				String access_time = adDAO.findEnterTime(member_id); // access_table 에서 access_time을 가져옴.

				TextField member_idField = (TextField) adminSeat.lookup("#member_idField");
				TextField enter_timeField = (TextField) adminSeat.lookup("#enter_timeField");
				TextField remain_timeField = (TextField) adminSeat.lookup("#remain_timeField");

				member_idField.setText(member_id);
				enter_timeField.setText(access_time);
				remain_timeField.setText(remainTime);
			}
		}//moveSelect = false
	}// buttonSelect

	public void adminExit() { // admin에서 퇴실버튼
		TextField member_idField = (TextField) adminSeat1.lookup("#member_idField");
		String member_id = member_idField.getText();
		if (member_id.isEmpty()) {
			System.out.println("데이터가 비어있습니다");
		} else {
			ExitService esr = new ExitService();
			long min = esr.getTime(member_id);

			esr.updateMember(min, member_id);
			esr.accessInsert(member_id);
			esr.exitCheck(member_id);

		}
	}

	public void adminEnterTimePlus() { // 일단은 무조건 1시간만 추가됨
		TextField member_idField = (TextField) adminSeat1.lookup("#member_idField");
		String member_id = member_idField.getText();
		int time = adDAO.selectMemberTime(member_id);
		time += 60;
		CommonService cser = new CommonService();
		cser.updateLimit_time(time,member_id);
		adDAO.memberTimeUD(time, member_id);
		System.out.println("업데이트 했음.");
	}

	public void adminSeatMove() {
		/*
		 * 클릭한 시트를 찾고 , 시트가 사용중인지 체크
		 * 
		 */
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText("알림");

		TextField member_idField = (TextField) adminSeat1.lookup("#member_idField");
		String member_id = member_idField.getText();
		adminSeatDTO result = adDAO.seatCheck(member_id);

		if (member_id.equals(result.getMember_id())) { // 선택한 좌석이 사용중인 좌석이면 ,
			alert.setContentText("이동할 좌석을 클릭해 주세요.");
			alert.show();
			moveSelect = true;
			
		} else{
			alert.setContentText("사용중이지 않은 좌석입니다.");
			alert.show();
		}
	}// adminSeatMone

	public void adminSeatMove2() {

	}

}

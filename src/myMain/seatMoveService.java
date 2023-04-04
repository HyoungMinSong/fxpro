package myMain;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class seatMoveService {
	 private seatMoveDAO dao;
	 private String seatInfoData;
	 private String member_id;
	 private Opener opener2;
	 
	public seatMoveService() {
	      seatMoveDAO dao = new seatMoveDAO();
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

	public void startSeat(Parent seatMove, String member_id, Opener opener2) {
		this.opener2 = opener2;
		ArrayList<seatViewDTO> dataList = selectUseSeat(); //사용중인 좌석을 가져와서
	      for(int i = 1 ; i <25;i++) {
	         String seat = "#s"+i;
	         Button btn =(Button)seatMove.lookup(seat);
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
	         Button btn2 =(Button)seatMove.lookup(useSeat);
	         btn2.setStyle("-fx-background-color:ORANGE;"+"-fx-border-color:BLACK");
	         btn2.setText(member_time+"분");
	         btn2.setPrefSize(70, 70);
	         
	         //member_time 으로 남은 시간을 구하는 로직.
	         CommonService cser = new CommonService();
	         CommonDTO cmDTO = new CommonDTO();
	         cmDTO = cser.before5Min(memberNum); //5분남았는지 아닌지 판별함.
	         String colorCode = cmDTO.getColor();
	         
	         if(colorCode.equals("0")) {
	            btn2.setStyle("-fx-background-color:RED;"+"-fx-border-color:BLACK");
	            btn2.setPrefSize(70, 70);
	         }
	         
	   
	      }/////////////Orange//////
	      this.member_id = member_id;
	}
	
	public void buttonSelect(ActionEvent e, Parent seatMove) {
		ArrayList<seatViewDTO> dataList = selectUseSeat();//arrayList
	      for(int i = 1 ; i <25;i++) {
	         String seat = "#s"+i;
	         Button btn =(Button)seatMove.lookup(seat);
	         btn.setStyle("-fx-background-color:#D3D3D3;"+"-fx-border-color:BLACK");
	         btn.setPrefSize(70, 70);
	      }
	      
	      for(seatViewDTO data : dataList) {
	         //사용중이지 않은 데이터를 가져와야함.
	         String useSeat = "#"+data.getSeat_num();
	         String member_id = data.getMember_id();
	         String member_time = data.getMember_time();
	         Button btn2 =(Button)seatMove.lookup(useSeat);
	         btn2.setStyle("-fx-background-color:ORANGE;"+"-fx-border-color:BLACK");
	         btn2.setPrefSize(70, 70);
	         CommonService cser = new CommonService();
	         CommonDTO cmDTO = new CommonDTO();
	         cmDTO = cser.before5Min(member_id); //5분남았는지 아닌지 판별함.
	         String colorCode= cmDTO.getColor();

	         
	         if(colorCode.equals("0")) {
	            btn2.setStyle("-fx-background-color:RED;"+"-fx-border-color:BLACK");
	            btn2.setPrefSize(70, 70);
	         }else if(colorCode.equals("-1")) {
	        	String btnName = cmDTO.getSeat_Num();
	        	btnName= "#"+btnName;
	            Button btn3 = (Button)seatMove.lookup(btnName);
	            btnName= btnName.replace("#s", "");
	            System.out.println("btnName : ? " + btnName);
	        	btn3.setText(btnName);
	        	btn3.setStyle("-fx-background-color:#D3D3D3;"+"-fx-border-color:BLACK");
	         }
			
	         
	      }
	      
	      String ButtonfxId = idExtract(e);
	      Button btn = (Button)seatMove.lookup(ButtonfxId);
	      btn.setStyle("-fx-background-color:#6699CC;"+"-fx-border-color:BLACK");
	      btn.setPrefSize(70, 70);
	   
	      //////
	      this.seatInfoData = ButtonfxId;
	      System.out.println("seatinfoData(버튼의 fxId)는 ? " +  seatInfoData);
	}

	public void seatChange(Parent seatMove) {
		String YN = dao.checkSeatUse(seatInfoData); //buttonSelect 메소드를 실행하면 seatInfoData 값이 바뀜 
		int a = 10;
		Alert alert = new Alert(AlertType.INFORMATION);
	      if(YN.equals("Y")) {
	         String contentText = "이미 사용중인 좌석입니다.";
	         alert.setHeaderText("알림");
	         alert.setContentText(contentText);
	         alert.show();
	      }else if(YN.equals("N")) {
	    	  
	    	 alert.setHeaderText("자리이동완료");
	    	 alert.setContentText("자리이동완료 되었습니다.");
	    	 seatInfoData = seatInfoData.replace("#", "");
	         dao.updateSeat(member_id ,seatInfoData);
	         
	         alert.show();
	         
	         opener2.homeChangeOpen();
	      }
		
	}

}
















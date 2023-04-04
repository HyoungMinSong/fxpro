package myMain;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class adminSeatService {
	private adminSeatDAO adDAO;
	
	
	public adminSeatService() {
		adminSeatDAO adDAO = new adminSeatDAO();
		this.adDAO = adDAO;
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
	public ArrayList<seatViewDTO> selectUseSeat() {
	      return adDAO.selectUseSeat();
	   }

	public void startSeat(Parent adminSeat) {
		ArrayList<seatViewDTO> dataList = selectUseSeat();
		for(int i = 1 ; i <25;i++) {
	         String seat = "#s"+i;
	         Button btn =(Button)adminSeat.lookup(seat);
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
	         Button btn2 =(Button)adminSeat.lookup(useSeat);
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
	      }////////////////Orange//////
	}//StartSeat 
	
	 public void buttonSelect(ActionEvent e, Parent adminSeat) {
		 ArrayList<seatViewDTO> dataList = selectUseSeat();
		 for(int i = 1 ; i <25;i++) {
	         String seat = "#s"+i;
	         Button btn =(Button)adminSeat.lookup(seat);
	         btn.setStyle("-fx-background-color:#D3D3D3;"+"-fx-border-color:BLACK");
	         btn.setPrefSize(70, 70);
	      }
	     
		 
	
	      System.out.println("===================================");
	   }//buttonSelect


}























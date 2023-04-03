package seatView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class seatViewMain extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		/*
		 Opener 화면 변경 처리는 아직 적용하지 않음. -0328 박승홍
		 */
		String member_id = "01041133401";
		FXMLLoader loader = new FXMLLoader(getClass().getResource("seatView.fxml"));
		Parent seatView = loader.load();
		
		seatViewController sc = loader.getController();
		
		sc.setSeatView(seatView);
		sc.startSeat(member_id);
		
		Scene scene = new Scene(seatView);
		primaryStage.setTitle("SEAT");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}


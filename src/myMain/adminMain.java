package myMain;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class adminMain extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("adminSeat.fxml"));
		Parent adminMain = loader.load();
		
		adminSeatController adCon =loader.getController();
		adCon.setView(adminMain);
		adCon.startSeat(adminMain);
		
		Scene scene = new Scene(adminMain);
		primaryStage.setTitle("Admin");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
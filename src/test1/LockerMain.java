package test1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


	public class LockerMain extends Application {
		@Override
		public void start(Stage primaryStage) throws Exception {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("lockerForm.fxml"));
			Parent lockerForm = loader.load();
			
			LockerController sc = loader.getController();
			
			sc.setLockerForm(lockerForm);
			sc.startLocker();
			
			Scene scene = new Scene(lockerForm);
			primaryStage.setTitle("사물함이용권");
			primaryStage.setScene(scene);
			primaryStage.show();

		}
		public static void main(String[] args) {
			launch(args);
		}
	}


package exit;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


	public class ExitMain extends Application {
		@Override
		public void start(Stage primaryStage) throws Exception {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("ExitForm.fxml"));
			Parent exitForm = loader.load();
			
			
			
			Scene scene = new Scene(exitForm);
			primaryStage.setTitle("퇴실하기");
			primaryStage.setScene(scene);
			primaryStage.show();

		}
		public static void main(String[] args) {
			launch(args);
		}
	}


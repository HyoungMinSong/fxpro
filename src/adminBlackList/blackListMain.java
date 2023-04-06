package adminBlackList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


	public class blackListMain extends Application {
		@Override
		public void start(Stage primaryStage) throws Exception {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("blackListForm.fxml"));
			Parent blackListForm = loader.load();
			
			
			
			Scene scene = new Scene(blackListForm);
			primaryStage.setTitle("블랙리스트");
			primaryStage.setScene(scene);
			primaryStage.show();

		}
		public static void main(String[] args) {
			launch(args);
		}
	}


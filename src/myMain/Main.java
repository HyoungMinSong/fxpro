package myMain;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("loginForm2.fxml"));
		Parent loginForm = loader.load();
		
		Opener opener = new Opener();
		opener.setPrimaryStage(primaryStage);
		LoginController lc = loader.getController();
		lc.setOpener(opener);
		
		Scene scene = new Scene(loginForm);
		opener.setScene(scene);
		primaryStage.setTitle("로그인 화면");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}






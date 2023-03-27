package ex5;

import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class CommonService {

	public static void msg(String contentText) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText("알림");
		alert.setContentText(contentText);
		alert.show();
	}
	
	public static void windowsClose(Parent form) {
		Stage stage = (Stage)form.getScene().getWindow(); //Parent를 통해 스테이지 찾기.
		stage.close(); //창 닫기.
	}
	public static void windowsClose(Stage stage) {
		
		stage.close();
	}
}

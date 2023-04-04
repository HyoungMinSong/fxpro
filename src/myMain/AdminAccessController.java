package myMain;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import myMain.CommonService;
import myMain.Opener;

public class AdminAccessController implements Initializable {
//	@FXML
//	ToggleButton button1;


	private Opener opener;
	
	public void setOpener(Opener opener) {
		this.opener = opener;
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {


	}

}

package myMain;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginService {
	private LoginDAO dao;
	
	public LoginService() {
		dao = new LoginDAO();
	}

//	public void loginProc(TextField id, PasswordField pw) {
//		// TODO Auto-generated method stub
//		String tId = id.getText();
//		String pId = pw.getText();
//		Alert at = new Alert(AlertType.INFORMATION);
//		at.setHeaderText("로그인 정보");
//		if(dao.loginProc(tId, pId)) {
//			at.setContentText("로그인이 성공되었습니다.");
//			dao.loginSuccess(tId);
//		}else {
//			at.setContentText("로그인이 실패했습니다.");
//		}
//		at.show();
//	}
	


	public LoginDTO seatLoginCheck(String id) {
		// TODO Auto-generated method stub
		LoginDTO dto = dao.seatLoginCheck(id);	
		return dto;
	}
}

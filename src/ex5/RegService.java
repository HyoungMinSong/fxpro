package ex5;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class RegService {
	RegDAO dao = new RegDAO();
	Alert at;
	boolean result;
	public RegService() {
//		dao = new RegDAO();
		at = new Alert(AlertType.INFORMATION);
		at.setHeaderText("회원가입 정보");
	}

	public void regProc(RegDto dto) {
		// TODO Auto-generated method stub
		
		if(dao.checkId(dto.getId())) {
			at.setContentText("ID가 중복되었습니다.");
			at.show();
		} else {
			if(!dto.getPw().equals(dto.getPwCf())) {
				at.setContentText("Pw가 다릅니다.");
				at.show();
			} else {
				result = dao.regProc(dto);
				if(result) {
					at.setContentText("회원가입이 성공했습니다.");
					at.show();
				} else {
					at.setContentText("회원가입이 실패했습니다.");
					at.show();
				}
				
			}
		}
		

		
	}

}

package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class DoAgainActionController {
	
	private MainApp mainApp; 
	
	@FXML
	private Button buildWithCard = new Button(); 
	@FXML
	private Button buildWithKing = new Button(); 
	@FXML
	private Button electCounsellor = new Button(); 
	@FXML
	private Button buyPermissionCard = new Button(); 
	
	@FXML
	private void handleBuildWithCard() {
		mainApp.showBonusBuildWithCard();
		mainApp.getTempStage().close();
	}
	@FXML
	private void handleBuildWithKing() {
		mainApp.showBonusBuildWithKing();
		mainApp.getTempStage().close();
	}
	@FXML
	private void handleElectCounsellor() {
		mainApp.showBonusElectCounsellor();
		mainApp.getTempStage().close();
	}
	@FXML
	private void handleBuyPermissionCard() {
		mainApp.showBonusBuyPermissionCard();
		mainApp.getTempStage().close();
	}
	/**
	 * @param mainApp the mainApp to set
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

}
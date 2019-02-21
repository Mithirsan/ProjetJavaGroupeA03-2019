package view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class GamePlayOptionAndJokersVBox extends VBox {

	private Button btnOption;
	
	private Button btnJokerAudienceOpinion;
	private Button btnJokerFiftyFifty;
	private Button btnJokerTimeFreezer;
	private Button btnJokerAnotherChance;
	
	public GamePlayOptionAndJokersVBox() {
		this.setPadding(new Insets(10));
		this.setSpacing(5);
		
		this.getChildren().addAll(
				getBtnOption(), 
				getBtnJokerAudienceOpinion(), 
				getBtnJokerFiftyFifty(), 
				getBtnJokerTimeFreezer(), 
				getBtnJokerAnotherChance()
		);
	}
	
	public Button getBtnOption() {
		if (btnOption == null) {
			btnOption = new Button("Options");
		}
		return btnOption;
	}
	
	public Button getBtnJokerAudienceOpinion() {
		if(btnJokerAudienceOpinion == null) {
			btnJokerAudienceOpinion = new Button("Audience Opinion");
		}
		return btnJokerAudienceOpinion;
	}

	public Button getBtnJokerFiftyFifty() {
		if(btnJokerFiftyFifty == null) {
			btnJokerFiftyFifty = new Button("Fifty Fifty");
		}
		return btnJokerFiftyFifty;
	}

	public Button getBtnJokerTimeFreezer() {
		if(btnJokerTimeFreezer == null) {
			btnJokerTimeFreezer = new Button("Time Freezer");
		}
		return btnJokerTimeFreezer;
	}

	public Button getBtnJokerAnotherChance() {
		if(btnJokerAnotherChance == null) {
			btnJokerAnotherChance = new Button("Another Chance");
		}
		return btnJokerAnotherChance;
	}
}

package view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;

public class GamePlayOptionAndJokersVBox extends VBox {

	private Button btnOption;
	
	private Button btnJokerAudienceOpinion;
	private Button btnJokerFiftyFifty;
	private Button btnJokerTimeFreezer;
	private Button btnJokerAnotherChance;
	private Separator separator;
	
	public GamePlayOptionAndJokersVBox() {
		this.setPadding(new Insets(10));
		this.setSpacing(5);
		
		this.getChildren().addAll(
				getBtnOption(),
				getSeparator(),
				getBtnJokerAudienceOpinion(), 
				getBtnJokerFiftyFifty(), 
				getBtnJokerTimeFreezer(), 
				getBtnJokerAnotherChance()
		);
	}
	
	public Button getBtnOption() {
		if (btnOption == null) {
			btnOption = new Button("Options");
			btnOption.getStyleClass().add("btnOption");
			this.setSpacing(5);
			btnOption.setOnAction(e->{
				((FinalViewStackPane) getParent().getParent()).getOptionBorderPane().setVisible(true);
				getParent().setVisible(false);
				((FinalViewStackPane) getParent().getParent()).getGamePlayBorderPane().getTimer().pauseTimer(true);
			});
			
		}
		return btnOption;
	}
	
	public Button getBtnJokerAudienceOpinion() {
		if(btnJokerAudienceOpinion == null) {
			btnJokerAudienceOpinion = new Button("A O");
			btnJokerAudienceOpinion.getStyleClass().add("btnJoker");
			
			btnJokerAudienceOpinion.setDisable(true);
		}
		return btnJokerAudienceOpinion;
	}

	public Button getBtnJokerFiftyFifty() {
		if(btnJokerFiftyFifty == null) {
			btnJokerFiftyFifty = new Button("F F");
			btnJokerFiftyFifty.getStyleClass().add("btnJoker");
			
			btnJokerFiftyFifty.setDisable(true);
		}
		return btnJokerFiftyFifty;
	}

	public Button getBtnJokerTimeFreezer() {
		if(btnJokerTimeFreezer == null) {
			btnJokerTimeFreezer = new Button("Time Freeze");
			btnJokerTimeFreezer.getStyleClass().add("btnJoker");
			
			btnJokerTimeFreezer.setOnAction(e->{
					((GamePlayBorderPane) getParent()).getTimer().freezeTimer();
				});
			}
		return btnJokerTimeFreezer;
	}
		


	public Button getBtnJokerAnotherChance() {
		if(btnJokerAnotherChance == null) {
			btnJokerAnotherChance = new Button("A C");
			btnJokerAnotherChance.getStyleClass().add("btnJoker");
			
			btnJokerAnotherChance.setDisable(true);
		}
		return btnJokerAnotherChance;
	}

	public Separator getSeparator() {
		if(separator == null) {
			separator = new Separator();
			separator.getStyleClass().add("sep");
		}
		return separator;
	}
	
	
}

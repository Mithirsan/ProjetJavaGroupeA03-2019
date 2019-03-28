package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;
import model.Deck;

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
			btnJokerAudienceOpinion.setOnAction(e->{
				AudienceOpinionJokerStrategy aOJoker = new AudienceOpinionJokerStrategy();
				aOJoker.effectOfJoker(Deck.getInstance().getQuestions().get(Deck.getIndex()).getRound());
				double[] tmp = aOJoker.getAudienceChoices();
				showPourcent(tmp);
			});
		}
		return btnJokerAudienceOpinion;
	}

	private void showPourcent(double[] tmp) {
		for(int i = 0; i < 4; i++) {
			tmp[i] = (double)Math.round(tmp[i] * 100d) / 100d;
		}
		Node nodeTmp = ((GamePlayBorderPane) getParent()).getStatementAndChoices().getChoices();
		((GamePlayChoicesGridPane) nodeTmp).getBtnAnswerA().setText("A: " + Deck.getInstance().getQuestions().get(Deck.getIndex()).getChoice(0) + " - " + tmp[0] + "%");
		((GamePlayChoicesGridPane) nodeTmp).getBtnAnswerB().setText("B: " + Deck.getInstance().getQuestions().get(Deck.getIndex()).getChoice(1) + " - " + tmp[1] + "%");
		((GamePlayChoicesGridPane) nodeTmp).getBtnAnswerC().setText("C: " + Deck.getInstance().getQuestions().get(Deck.getIndex()).getChoice(2) + " - " + tmp[2] + "%");
		((GamePlayChoicesGridPane) nodeTmp).getBtnAnswerD().setText("D: " + Deck.getInstance().getQuestions().get(Deck.getIndex()).getChoice(3) + " - " + tmp[3] + "%");
		getBtnJokerAudienceOpinion().setDisable(true);
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

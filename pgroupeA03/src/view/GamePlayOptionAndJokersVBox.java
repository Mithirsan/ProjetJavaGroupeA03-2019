package view;

import java.io.File;

import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import model.AnotherChanceJokerStrategy;
import model.AudienceOpinionJokerStrategy;
import model.Deck;
import model.FiftyFiftyJokerStrategy;
import model.TimeFreezeJokerStrategy;

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
			ImageView ivOption = new ImageView(new Image(new File("resources/pictures/btnOption.png").toURI().toString()));
			ivOption.setFitHeight(25);
			ivOption.setFitWidth(25);
			btnOption = new Button("",ivOption);
			btnOption.getStyleClass().add("btnOption");
			this.setSpacing(5);
			btnOption.setOnAction(e->{
				((FinalViewStackPane) getParent().getParent()).getOptionBorderPane().setVisible(true);
				((GamePlayBorderPane)getParent()).getTimer().getMP45to20().stop();
				((GamePlayBorderPane)getParent()).getTimer().getMP20to10().stop();
				((GamePlayBorderPane)getParent()).getTimer().getMP10to0().stop();
				getParent().setVisible(false);
				((FinalViewStackPane) getParent().getParent()).getGamePlayBorderPane().getTimer().pauseTimer(true);
			});
			
		}
		return btnOption;
	}
	
	public Button getBtnJokerAudienceOpinion() {
		if(btnJokerAudienceOpinion == null) {
			ImageView ivAudienceOpinion = new ImageView(new Image(new File("resources/pictures/btnAO.png").toURI().toString()));
			ivAudienceOpinion.setFitHeight(25);
			ivAudienceOpinion.setFitWidth(25);
			btnJokerAudienceOpinion = new Button("", ivAudienceOpinion);
			btnJokerAudienceOpinion.getStyleClass().add("btnJoker");
			btnJokerAudienceOpinion.setOnAction(e->{
				AudienceOpinionJokerStrategy aOJoker = new AudienceOpinionJokerStrategy();
				aOJoker.effectOfJoker();
				double[] tmp = aOJoker.getAudienceChoices();
				showPourcent(tmp);
				if(!Deck.getInstance().getJoker(0)) {
					getBtnJokerAudienceOpinion().setDisable(true);
				}
			});
		}
		return btnJokerAudienceOpinion;
	}

	private void showPourcent(double[] tmp) {
		for(int i = 0; i < 4; i++) {
			tmp[i] = (double)Math.round(tmp[i] * 100d) / 100d;
		}
		Node nodeTmp = ((GamePlayBorderPane) getParent()).getStatementAndChoices().getChoices();
		((GamePlayChoicesGridPane) nodeTmp).getBtnAnswerA().setText("A: " + Deck.getInstance().
				getGameQuestions().get(Deck.getInstance().getIndex()).getChoice(0) + " - " + tmp[0] + "%");
		((GamePlayChoicesGridPane) nodeTmp).getBtnAnswerB().setText("B: " + Deck.getInstance().
				getGameQuestions().get(Deck.getInstance().getIndex()).getChoice(1) + " - " + tmp[1] + "%");
		((GamePlayChoicesGridPane) nodeTmp).getBtnAnswerC().setText("C: " + Deck.getInstance().
				getGameQuestions().get(Deck.getInstance().getIndex()).getChoice(2) + " - " + tmp[2] + "%");
		((GamePlayChoicesGridPane) nodeTmp).getBtnAnswerD().setText("D: " + Deck.getInstance().
				getGameQuestions().get(Deck.getInstance().getIndex()).getChoice(3) + " - " + tmp[3] + "%");
	}

	public Button getBtnJokerFiftyFifty() {
		if(btnJokerFiftyFifty == null) {
			ImageView ivFiftyFifty = new ImageView(new Image(new File("resources/pictures/btnFF.png").toURI().toString()));
			ivFiftyFifty.setFitHeight(25);
			ivFiftyFifty.setFitWidth(25);
			btnJokerFiftyFifty = new Button("", ivFiftyFifty);
			btnJokerFiftyFifty.getStyleClass().add("btnJoker");
			
			btnJokerFiftyFifty.setOnAction(e->{
				FiftyFiftyJokerStrategy fFJoker = new FiftyFiftyJokerStrategy();
				fFJoker.effectOfJoker();
				if(!Deck.getInstance().getJoker(1)) {
					disable2False(fFJoker.get2FalseIndex());
				}
			});
		}
		return btnJokerFiftyFifty;
	}

	private void disable2False(int[] get2FalseIndex) {
		Node nodeTmp = ((GamePlayBorderPane) getParent()).getStatementAndChoices().getChoices();
		for(int i = 0; i < 2; i++) {
			if(get2FalseIndex[i] == 0) {
				((GamePlayChoicesGridPane) nodeTmp).getBtnAnswerA().setDisable(true);
			}else if(get2FalseIndex[i] == 1) {
				((GamePlayChoicesGridPane) nodeTmp).getBtnAnswerB().setDisable(true);
			}else if(get2FalseIndex[i] == 2) {
				((GamePlayChoicesGridPane) nodeTmp).getBtnAnswerC().setDisable(true);
			}else {
				((GamePlayChoicesGridPane) nodeTmp).getBtnAnswerD().setDisable(true);
			}
			getBtnJokerFiftyFifty().setDisable(true);
		}
	}

	public Button getBtnJokerTimeFreezer() {
		if(btnJokerTimeFreezer == null) {
			ImageView ivTimeFreezer = new ImageView(new Image(new File("resources/pictures/btnTF.png").toURI().toString()));
			ivTimeFreezer.setFitHeight(25);
			ivTimeFreezer.setFitWidth(25);
			btnJokerTimeFreezer = new Button("", ivTimeFreezer);
			btnJokerTimeFreezer.getStyleClass().add("btnJoker");
			
			btnJokerTimeFreezer.setOnAction(e->{
					TimeFreezeJokerStrategy tFJoker = new TimeFreezeJokerStrategy();
					tFJoker.effectOfJoker();
					if(!Deck.getInstance().getJoker(2)) {
						((FinalViewStackPane) getParent().getParent()).getGamePlayBorderPane().getTimer().freezeTimer();
						btnJokerTimeFreezer.setDisable(true);
					}
				});
			}
		return btnJokerTimeFreezer;
	}
		
	public Button getBtnJokerAnotherChance() {
		if(btnJokerAnotherChance == null) {
			ImageView ivAnotherChance = new ImageView(new Image(new File("resources/pictures/btnR.png").toURI().toString()));
			ivAnotherChance.setFitHeight(25);
			ivAnotherChance.setFitWidth(25);
			btnJokerAnotherChance = new Button("", ivAnotherChance);
			btnJokerAnotherChance.getStyleClass().add("btnJoker");
		
			btnJokerAnotherChance.setOnAction(e->{
				AnotherChanceJokerStrategy aCJoker= new AnotherChanceJokerStrategy();
				aCJoker.effectOfJoker();
				if(!Deck.getInstance().getJoker(3)) {
					((FinalViewStackPane) getParent().getParent()).getGamePlayBorderPane().getStatementAndChoices().getChoices().setAChance(true);
					btnJokerAnotherChance.setDisable(true);
				}
			});		
		}
		return btnJokerAnotherChance;
	}

	public Separator getSeparator() {
		if(separator == null) {
			separator = new Separator();
			separator.setValignment(VPos.CENTER);
			separator.getStyleClass().add("sep");
		}
		return separator;
	}	
}

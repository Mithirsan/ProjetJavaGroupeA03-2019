package view;

import java.io.IOException;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.css.PseudoClass;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import model.Deck;
import model.Stats;
import util.Serializable;

public class GamePlayChoicesGridPane extends GridPane  {
	private boolean aChance = false;
	private Button btnAnswerA;
	private Button btnAnswerB;
	private Button btnAnswerC;
	private Button btnAnswerD;
	
	public GamePlayChoicesGridPane() {
		this.setPadding(new Insets(5));
		this.setVgap(10);
		this.setHgap(10);
		
		this.add(getBtnAnswerA(), 0, 0);
		this.add(getBtnAnswerB(), 1, 0);
		this.add(getBtnAnswerC(), 0, 1);
		this.add(getBtnAnswerD(), 1, 1);
		
		this.setAlignment(Pos.CENTER);
	}
	
	public Button getBtnAnswerA() {
		if (btnAnswerA == null) {
			btnAnswerA = new Button("A: " + Deck.getInstance().getGameQuestions().get(Deck.getInstance().getIndex()).getChoice(0));
			btnAnswerA.setOnAction(e->{
			checkAnswer(btnAnswerA, Deck.getInstance().getGameQuestions().get(Deck.getInstance().getIndex()).getChoiceValue(0));
			});
			btnAnswerA.getStyleClass().add("btnAnswer");
		}
		return btnAnswerA;
	}

	public Button getBtnAnswerB() {
		if(btnAnswerB == null) {
			btnAnswerB = new Button("B: " + Deck.getInstance().getGameQuestions().get(Deck.getInstance().getIndex()).getChoice(1));
			btnAnswerB.setOnAction(e->{
				checkAnswer(btnAnswerB, Deck.getInstance().getGameQuestions().get(Deck.getInstance().getIndex()).getChoiceValue(1));
			});
			btnAnswerB.getStyleClass().add("btnAnswer");
		}
		return btnAnswerB;
	}

	public Button getBtnAnswerC() {
		if(btnAnswerC == null) {
			btnAnswerC = new Button("C: " + Deck.getInstance().getGameQuestions().get(Deck.getInstance().getIndex()).getChoice(2));

			btnAnswerC.setOnAction(e->{
			checkAnswer(btnAnswerC, Deck.getInstance().getGameQuestions().get(Deck.getInstance().getIndex()).getChoiceValue(2));
			});
			btnAnswerC.getStyleClass().add("btnAnswer");
		}
		return btnAnswerC;
	}

	public Button getBtnAnswerD() {
		if(btnAnswerD == null) {
			btnAnswerD = new Button("D: " + Deck.getInstance().getGameQuestions().get(Deck.getInstance().getIndex()).getChoice(3));
			btnAnswerD.setOnAction(e->{
						checkAnswer(btnAnswerD, Deck.getInstance().getGameQuestions().get(Deck.getInstance().getIndex()).getChoiceValue(3));
			});
			btnAnswerD.getStyleClass().add("btnAnswer");
		}
		
		return btnAnswerD;
	}
	
	private void checkAnswer(Node flashing, boolean bool) {
		((FinalViewStackPane) getParent().getParent().getParent()).getGamePlayBorderPane().getTimer().pauseTimer(true);
		PseudoClass flashHighlight;
		PseudoClass test = PseudoClass.getPseudoClass("Testing");
		
		if(bool) {
			flashHighlight = PseudoClass.getPseudoClass("RightAnswer");
		}else {
			flashHighlight = PseudoClass.getPseudoClass("WrongAnswer");
		}
		
		KeyFrame on = new KeyFrame(Duration.seconds(0.1), ek-> {
			flashing.pseudoClassStateChanged(test, true);
	    });
		KeyFrame off = new KeyFrame(Duration.seconds(0.4), ek-> {
			flashing.pseudoClassStateChanged(test, false);
	    });
		
		KeyFrame beforEnd = new KeyFrame(Duration.seconds(0.1), ek-> {
			flashing.pseudoClassStateChanged(flashHighlight, true);
		});
		KeyFrame end = new KeyFrame(Duration.seconds(0.4), ek-> {
			flashing.pseudoClassStateChanged(flashHighlight, false);
		});
		
		Timeline endFlasher = new Timeline(beforEnd, end);
		endFlasher.setCycleCount(1);
		endFlasher.setAutoReverse(true);
		
		Timeline flasher = new Timeline(on, off);
		flasher.setCycleCount(4);
		flasher.setAutoReverse(true); 
		flasher.playFromStart();
		flasher.setOnFinished(ek->{
			flashing.pseudoClassStateChanged(test, false);
			endFlasher.playFromStart();
		});
		
		endFlasher.setOnFinished(ek -> {
			flashing.pseudoClassStateChanged(flashHighlight, false);
			((FinalViewStackPane) getParent().getParent().getParent()).getGamePlayBorderPane().getTimer().pauseTimer(false);
			if(bool) {
				success();
			}else {
				if(aChance){
					flashing.setDisable(true);
					setAChance(false);
				}else {
						fail();	
				}
			}		
		});
		Stats stats;
		try {
			stats = new Stats().downloadData();
			stats.setTimePlayed(((FinalViewStackPane) getParent().getParent().getParent()).getGamePlayBorderPane().getTimer().getSeconds());
			Serializable.writeSaveStats(stats.toJSon());
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	private void success() {
		Deck.increaseIndex();
		resetTxt();
		((FinalViewStackPane) getParent().getParent().getParent()).getGamePlayBorderPane().getTimer().refreshTimer();
		((FinalViewStackPane) getParent().getParent().getParent()).getGamePlayBorderPane().getLevels().nextStage();
		aChance=false;
		((FinalViewStackPane) getParent().getParent().getParent()).getGamePlayBorderPane().getTimer().speechStatement().playFromStart();
	}
	
	public void resetTxt() {
		((GamePlayStatementAndChoicesVBox) getParent()).getLblStatement().setText(Deck.getInstance().getGameQuestions().get(Deck.getInstance().getIndex()).getStatement());
		getBtnAnswerA().setText("A: " + Deck.getInstance().getGameQuestions().get(Deck.getInstance().getIndex()).getChoice(0));
		getBtnAnswerB().setText("B: " + Deck.getInstance().getGameQuestions().get(Deck.getInstance().getIndex()).getChoice(1));
		getBtnAnswerC().setText("C: " + Deck.getInstance().getGameQuestions().get(Deck.getInstance().getIndex()).getChoice(2));
		getBtnAnswerD().setText("D: " + Deck.getInstance().getGameQuestions().get(Deck.getInstance().getIndex()).getChoice(3));
		getBtnAnswerA().setDisable(false);getBtnAnswerB().setDisable(false);getBtnAnswerC().setDisable(false);getBtnAnswerD().setDisable(false);
	}
	
	public void fail() {
		resetTxt();
		((GamePlayBorderPane)getParent().getParent()).getTimer().getMP45to20().stop();
		((GamePlayBorderPane)getParent().getParent()).getTimer().getMP20to10().stop();
		((GamePlayBorderPane)getParent().getParent()).getTimer().getMP10to0().stop();
		
		((FinalViewStackPane)getParent().getParent().getParent()).getMenuBorderPane().getMenuVBox().getMusic().play();
		((FinalViewStackPane)getParent().getParent().getParent()).getGamePlayBorderPane().setVisible(false);
		((GamePlayBorderPane)getParent().getParent()).resetForNewGame();
		((FinalViewStackPane)getParent().getParent().getParent()).getGamePlayBorderPane().getTimer().stopTimer();
		((FinalViewStackPane)getParent().getParent().getParent()).getLooseScreenBorderPane().setVisible(true);
		((FinalViewStackPane)getParent().getParent().getParent()).getLooseScreenBorderPane().getPathTransition().playFromStart();
	}

	public boolean isAChance() {
		return aChance;
	}

	public void setAChance(boolean bool) {
		this.aChance = bool;
	}
	
	public void loadGame() {
		Deck.increaseIndex();
		resetTxt();
		((FinalViewStackPane) getParent().getParent().getParent()).getGamePlayBorderPane().getLevels().nextStage();
	}
	
}
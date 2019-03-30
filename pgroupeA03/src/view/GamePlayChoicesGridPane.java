package view;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import model.Deck;

public class GamePlayChoicesGridPane extends GridPane  {

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
			btnAnswerA = new Button("A: " + Deck.getInstance().getQuestions().get(Deck.getIndex()).getChoice(0));
			btnAnswerA.setOnAction(e->{
				if(Deck.getInstance().getQuestions().get(Deck.getIndex()).getChoiceValue(0)) {
					PseudoClass flashHighlight = PseudoClass.getPseudoClass("RightAnswer");
					Node background = ((GamePlayBorderPane) getParent().getParent()).getStatementAndChoices().getLblStatement();
					KeyFrame on = new KeyFrame(Duration.seconds(0.5), ek-> {
						background.pseudoClassStateChanged(flashHighlight, true);
				    });
					KeyFrame off = new KeyFrame(Duration.seconds(0.5), ek-> {
						background.pseudoClassStateChanged(flashHighlight, false);
				    });
					
					Timeline flasher = new Timeline(on, off);
					flasher.setCycleCount(4);
					flasher.playFromStart();
					flasher.setOnFinished(ek->{
						background.pseudoClassStateChanged(flashHighlight, false);
						refresh();				
					});
				}else {
					PseudoClass flashHighlight = PseudoClass.getPseudoClass("WrongAnswer");
					Node background = ((GamePlayBorderPane) getParent().getParent()).getStatementAndChoices().getLblStatement();
					KeyFrame on = new KeyFrame(Duration.seconds(0.5), ek-> {
						background.pseudoClassStateChanged(flashHighlight, true);
				    });
					KeyFrame off = new KeyFrame(Duration.seconds(0.5), ek-> {
						background.pseudoClassStateChanged(flashHighlight, false);
				    });
					
					Timeline flasher = new Timeline(on, off);
					flasher.setCycleCount(4);
					flasher.playFromStart();
					flasher.setOnFinished(ek->{
						background.pseudoClassStateChanged(flashHighlight, false);
						fail();				
					});
				}
			});
			btnAnswerA.getStyleClass().add("btnAnswer");
		}
		return btnAnswerA;
	}

	public Button getBtnAnswerB() {
		if(btnAnswerB == null) {
			btnAnswerB = new Button("B: " + Deck.getInstance().getQuestions().get(Deck.getIndex()).getChoice(1));
			btnAnswerB.setOnAction(e->{
				if(Deck.getInstance().getQuestions().get(Deck.getIndex()).getChoiceValue(1)) {
					PseudoClass flashHighlight = PseudoClass.getPseudoClass("RightAnswer");
					Node background = ((GamePlayBorderPane) getParent().getParent()).getStatementAndChoices().getLblStatement();
					KeyFrame on = new KeyFrame(Duration.seconds(0.5), ek-> {
						background.pseudoClassStateChanged(flashHighlight, true);
				    });
					KeyFrame off = new KeyFrame(Duration.seconds(0.5), ek-> {
						background.pseudoClassStateChanged(flashHighlight, false);
				    });
					
					Timeline flasher = new Timeline(on, off);
					flasher.setCycleCount(4);
					flasher.playFromStart();
					flasher.setOnFinished(ek->{
						background.pseudoClassStateChanged(flashHighlight, false);
						refresh();				
					});
				}else {
					PseudoClass flashHighlight = PseudoClass.getPseudoClass("WrongAnswer");
					Node background = ((GamePlayBorderPane) getParent().getParent()).getStatementAndChoices().getLblStatement();
					KeyFrame on = new KeyFrame(Duration.seconds(0.5), ek-> {
						background.pseudoClassStateChanged(flashHighlight, true);
				    });
					KeyFrame off = new KeyFrame(Duration.seconds(0.5), ek-> {
						background.pseudoClassStateChanged(flashHighlight, false);
				    });
					
					Timeline flasher = new Timeline(on, off);
					flasher.setCycleCount(4);
					flasher.playFromStart();
					flasher.setOnFinished(ek->{
						background.pseudoClassStateChanged(flashHighlight, false);
						fail();				
					});
				}
			});
			btnAnswerB.getStyleClass().add("btnAnswer");
		}
		return btnAnswerB;
	}

	public Button getBtnAnswerC() {
		if(btnAnswerC == null) {
			btnAnswerC = new Button("C: " + Deck.getInstance().getQuestions().get(Deck.getIndex()).getChoice(2));

			btnAnswerC.setOnAction(e->{
				if(Deck.getInstance().getQuestions().get(Deck.getIndex()).getChoiceValue(2)) {
					PseudoClass flashHighlight = PseudoClass.getPseudoClass("RightAnswer");
					Node background = ((GamePlayBorderPane) getParent().getParent()).getStatementAndChoices().getLblStatement();
					KeyFrame on = new KeyFrame(Duration.seconds(0.5), ek-> {
						background.pseudoClassStateChanged(flashHighlight, true);
				    });
					KeyFrame off = new KeyFrame(Duration.seconds(0.5), ek-> {
						background.pseudoClassStateChanged(flashHighlight, false);
				    });
					
					Timeline flasher = new Timeline(on, off);
					flasher.setCycleCount(4);
					flasher.playFromStart();
					flasher.setOnFinished(ek->{
						background.pseudoClassStateChanged(flashHighlight, false);
						refresh();				
					});
				}else {
					PseudoClass flashHighlight = PseudoClass.getPseudoClass("WrongAnswer");
					Node background = ((GamePlayBorderPane) getParent().getParent()).getStatementAndChoices().getLblStatement();
					KeyFrame on = new KeyFrame(Duration.seconds(0.5), ek-> {
						background.pseudoClassStateChanged(flashHighlight, true);
				    });
					KeyFrame off = new KeyFrame(Duration.seconds(0.5), ek-> {
						background.pseudoClassStateChanged(flashHighlight, false);
				    });
					
					Timeline flasher = new Timeline(on, off);
					flasher.setCycleCount(4);
					flasher.playFromStart();
					flasher.setOnFinished(ek->{
						background.pseudoClassStateChanged(flashHighlight, false);
						fail();				
					});
				}
			});
			btnAnswerC.getStyleClass().add("btnAnswer");
		}
		return btnAnswerC;
	}

	public Button getBtnAnswerD() {
		if(btnAnswerD == null) {
			btnAnswerD = new Button("D: " + Deck.getInstance().getQuestions().get(Deck.getIndex()).getChoice(3));
			btnAnswerD.setOnAction(e->{
				if(Deck.getInstance().getQuestions().get(Deck.getIndex()).getChoiceValue(3)) {
					PseudoClass flashHighlight = PseudoClass.getPseudoClass("RightAnswer");
					Node background = ((GamePlayBorderPane) getParent().getParent()).getStatementAndChoices().getLblStatement();
					KeyFrame on = new KeyFrame(Duration.seconds(0.5), ek-> {
						background.pseudoClassStateChanged(flashHighlight, true);
				    });
					KeyFrame off = new KeyFrame(Duration.seconds(0.5), ek-> {
						background.pseudoClassStateChanged(flashHighlight, false);
				    });
					
					Timeline flasher = new Timeline(on, off);
					flasher.setCycleCount(4);
					flasher.playFromStart();
					flasher.setOnFinished(ek->{
						background.pseudoClassStateChanged(flashHighlight, false);
						refresh();				
					});
				}else {
					PseudoClass flashHighlight = PseudoClass.getPseudoClass("WrongAnswer");
					Node background = ((GamePlayBorderPane) getParent().getParent()).getStatementAndChoices().getLblStatement();
					KeyFrame on = new KeyFrame(Duration.seconds(0.5), ek-> {
						background.pseudoClassStateChanged(flashHighlight, true);
				    });
					KeyFrame off = new KeyFrame(Duration.seconds(0.5), ek-> {
						background.pseudoClassStateChanged(flashHighlight, false);
				    });
					
					Timeline flasher = new Timeline(on, off);
					flasher.setCycleCount(4);
					flasher.playFromStart();
					flasher.setOnFinished(ek->{
						background.pseudoClassStateChanged(flashHighlight, false);
						fail();				
					});
				}
			});
			btnAnswerD.getStyleClass().add("btnAnswer");
		}
		
		return btnAnswerD;
	}
	
	private void refresh() {
		Deck.increaseIndex();
		((GamePlayStatementAndChoicesVBox) getParent()).getLblStatement().setText(Deck.getInstance().getQuestions().get(Deck.getIndex()).getStatement());
		getBtnAnswerA().setText("A: " + Deck.getInstance().getQuestions().get(Deck.getIndex()).getChoice(0));
		getBtnAnswerB().setText("B: " + Deck.getInstance().getQuestions().get(Deck.getIndex()).getChoice(1));
		getBtnAnswerC().setText("C: " + Deck.getInstance().getQuestions().get(Deck.getIndex()).getChoice(2));
		getBtnAnswerD().setText("D: " + Deck.getInstance().getQuestions().get(Deck.getIndex()).getChoice(3));
		getBtnAnswerA().setDisable(false);getBtnAnswerB().setDisable(false);getBtnAnswerC().setDisable(false);getBtnAnswerD().setDisable(false);
		((FinalViewStackPane) getParent().getParent().getParent()).getGamePlayBorderPane().getTimer().refreshTimer();
		((FinalViewStackPane) getParent().getParent().getParent()).getGamePlayBorderPane().getLevels().nextStage();
	}
	
	public void fail() {
		((FinalViewStackPane)getParent().getParent().getParent()).getGamePlayBorderPane().setVisible(false);
		((GamePlayBorderPane)getParent().getParent()).reset();
		((FinalViewStackPane) getParent(). getParent().getParent()).getGamePlayBorderPane().getTimer().stopTimer();
		((FinalViewStackPane)getParent().getParent().getParent()).getLooseScreenBorderPane().setVisible(true);
	}
}

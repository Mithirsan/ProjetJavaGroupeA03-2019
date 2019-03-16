package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import model.Deck;

public class GamePlayChoicesGridPane extends GridPane {

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
					this.refresh();	
				
				} else {
					this.fail();
		
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
					this.refresh();
		
				} else {
					this.fail();
				
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
					this.refresh();
				} else {
					this.fail();
					
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
					this.refresh();

				} else {
					this.fail(); 
				}
			});
			btnAnswerD.getStyleClass().add("btnAnswer");
		}
		return btnAnswerD;
	}
	
	private void refresh() {
		Deck.increaseIndex();
		((GamePlayStatementAndChoicesVBox) getParent()).getLblStatement().setText(Deck.getInstance().getQuestions().get(Deck.getIndex()).getStatement());
		btnAnswerA.setText("A: " + Deck.getInstance().getQuestions().get(Deck.getIndex()).getChoice(0));
		btnAnswerB.setText("B: " + Deck.getInstance().getQuestions().get(Deck.getIndex()).getChoice(1));
		btnAnswerC.setText("C: " + Deck.getInstance().getQuestions().get(Deck.getIndex()).getChoice(2));
		btnAnswerD.setText("D: " + Deck.getInstance().getQuestions().get(Deck.getIndex()).getChoice(3));
		((FinalViewStackPane) getParent().getParent().getParent()).getGamePlayBorderPane().getTimer().refreshTimer();
		((FinalViewStackPane) getParent().getParent().getParent()).getGamePlayBorderPane().getLevels().nextStage();
	}
	public void fail() {
		((FinalViewStackPane)getParent().getParent().getParent()).getGamePlayBorderPane().setVisible(false);
		((GamePlayBorderPane)getParent().getParent()).start();
		((FinalViewStackPane) getParent(). getParent().getParent()).getGamePlayBorderPane().getTimer().stopTimer();
		((FinalViewStackPane)getParent().getParent().getParent()).getMenuBorderPane().setVisible(true);
	}
}

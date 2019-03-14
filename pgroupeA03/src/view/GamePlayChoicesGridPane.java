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
//			btnAnswerA.getStyleClass().add("btnAnswer");
		}
		return btnAnswerA;
	}

	public Button getBtnAnswerB() {
		if(btnAnswerB == null) {
			btnAnswerB = new Button("B: " + Deck.getInstance().getQuestions().get(Deck.getIndex()).getChoice(1));
//			btnAnswerB.getStyleClass().add("btnAnswer");
		}
		return btnAnswerB;
	}

	public Button getBtnAnswerC() {
		if(btnAnswerC == null) {
			btnAnswerC = new Button("C: " + Deck.getInstance().getQuestions().get(Deck.getIndex()).getChoice(2));
//			btnAnswerC.getStyleClass().add("btnAnswer");
		}
		return btnAnswerC;
	}

	public Button getBtnAnswerD() {
		if(btnAnswerD == null) {
			btnAnswerD = new Button("D: " + Deck.getInstance().getQuestions().get(Deck.getIndex()).getChoice(3));
//			btnAnswerD.getStyleClass().add("btnAnswer");
		}
		return btnAnswerD;
	}
}

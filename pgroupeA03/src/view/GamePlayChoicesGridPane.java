package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class GamePlayChoicesGridPane extends GridPane {

	private Button btnAnswerA;
	private Button btnAnswerB;
	private Button btnAnswerC;
	private Button btnAnswerD;
	
	public GamePlayChoicesGridPane() {
		this.setPadding(new Insets(5));
		
		this.add(getBtnAnswerA(), 0, 0, 1, 4);
		this.add(getBtnAnswerB(), 0, 4, 1, 4);
		this.add(getBtnAnswerC(), 1, 0, 1, 4);
		this.add(getBtnAnswerD(), 1, 4, 1, 4);
		
		this.setAlignment(Pos.CENTER);
	}
	
	public Button getBtnAnswerA() {
		if (btnAnswerA == null) {
			btnAnswerA = new Button("A: ");
		}
		return btnAnswerA;
	}

	public Button getBtnAnswerB() {
		if(btnAnswerB == null) {
			btnAnswerB = new Button("B: ");
		}
		return btnAnswerB;
	}

	public Button getBtnAnswerC() {
		if(btnAnswerC == null) {
			btnAnswerC = new Button("C: ");
		}
		return btnAnswerC;
	}

	public Button getBtnAnswerD() {
		if(btnAnswerD == null) {
			btnAnswerD = new Button("D: ");
		}
		return btnAnswerD;
	}
}

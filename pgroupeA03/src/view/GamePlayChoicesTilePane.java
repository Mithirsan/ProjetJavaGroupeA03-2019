package view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;

public class GamePlayChoicesTilePane extends TilePane {

	private Button btnAnswerA;
	private Button btnAnswerB;
	private Button btnAnswerC;
	private Button btnAnswerD;
	
	public GamePlayChoicesTilePane() {
		this.setPadding(new Insets(5));
		this.setVgap(5);
		this.setHgap(5);
		this.setPrefColumns(2);
		
		this.getChildren().addAll(getBtnAnswerA(), getBtnAnswerB(), getBtnAnswerC(), getBtnAnswerD());
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

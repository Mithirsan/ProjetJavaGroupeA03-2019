package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class GamePlayStatementAndChoicesGridPane extends GridPane {
	
	private Label lblStatement;
	
	private GamePlayChoicesTilePane choices = new GamePlayChoicesTilePane();
	
	public GamePlayStatementAndChoicesGridPane() {
		this.setPadding(new Insets(5));
		
		this.add(getLblStatement(), 0, 0);
		
		this.add(choices, 0, 1);
		
		this.setAlignment(Pos.CENTER);
	}
	
	public Label getLblStatement() {
		if(lblStatement == null) {
			lblStatement = new Label("Question ?");
		}
		return lblStatement;
	}
}

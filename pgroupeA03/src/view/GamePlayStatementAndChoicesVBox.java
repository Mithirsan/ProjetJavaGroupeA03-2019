package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import model.Deck;

public class GamePlayStatementAndChoicesVBox extends VBox {
	
	private Label lblStatement;
	
	private GamePlayChoicesGridPane choices;
	
	public GamePlayStatementAndChoicesVBox() {
		this.setPadding(new Insets(5));
		
		this.getChildren().addAll(getLblStatement(), getChoices());
		
		this.setAlignment(Pos.CENTER);
	}
	
	public Label getLblStatement() {
		if(lblStatement == null) {
			lblStatement = new Label(Deck.getInstance().getQuestions().get(Deck.getIndex()).getStatement());
			lblStatement.getStyleClass().add("lblStatement");
		}
		return lblStatement;
	}

	public GamePlayChoicesGridPane getChoices() {
		if(choices == null) {
			choices = new GamePlayChoicesGridPane();
		}
		return choices;
	}
	
}

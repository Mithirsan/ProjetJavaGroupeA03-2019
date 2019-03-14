package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import model.Deck;

public class GamePlayStatementAndChoicesVBox extends VBox {
	
	private Label lblStatement;
	
	private GamePlayChoicesGridPane choices = new GamePlayChoicesGridPane();
	
	public GamePlayStatementAndChoicesVBox() {
		this.setPadding(new Insets(5));
		
		this.getChildren().addAll(getLblStatement(), choices);
		
		this.setAlignment(Pos.CENTER);
	}
	
	public Label getLblStatement() {
		if(lblStatement == null) {
			lblStatement = new Label(Deck.getInstance().getQuestions().get(Deck.getIndex()).getStatement());
			lblStatement.getStyleClass().add("lblStatement");
		}
		return lblStatement;
	}
}

package view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class LooseScreenBorderPane extends BorderPane {
	private Label lblMessage;
	
	public LooseScreenBorderPane() {
		HBox text = new HBox();
		text.getChildren().add(getLblMessage());
		text.setAlignment(Pos.CENTER);
		setBottom(text);
	}

	public Label getLblMessage() {
		if(lblMessage == null) {
			lblMessage = new Label("You've losed the game, click to continue");
			lblMessage.getStyleClass().add("withe");
		}
		return lblMessage;
	}
}

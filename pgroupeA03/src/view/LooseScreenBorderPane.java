package view;

import java.io.File;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;

public class LooseScreenBorderPane extends BorderPane {
	private Label lblMessage;
	
	public LooseScreenBorderPane() {
//		BackgroundSize backgroundSize = new BackgroundSize( 960, 540, true, true, true, false);
//		BackgroundImage bg = new BackgroundImage(new Image(new File("resources/pictures/ElectricChair.jpg").toURI().toString()), 
//				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
//		setBackground(new Background(bg));
		setBottom(getLblMessage());
		getLblMessage().setAlignment(Pos.CENTER);
	}

	public Label getLblMessage() {
		if(lblMessage == null) {
			lblMessage = new Label("You've losed the game, click to continue");
			lblMessage.getStyleClass().add("withe");
		}
		return lblMessage;
	}
}

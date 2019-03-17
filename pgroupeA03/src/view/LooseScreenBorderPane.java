package view;

import java.io.File;


import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;

public class LooseScreenBorderPane extends BorderPane {
	public LooseScreenBorderPane() {
		BackgroundSize backgroundSize = new BackgroundSize( 960, 540, true, true, true, false);
		BackgroundImage bg = new BackgroundImage(new Image(new File("ressources/pictures/ElectricChair.jpg").toURI().toString()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
		setBackground(new Background(bg));
	}
	

}

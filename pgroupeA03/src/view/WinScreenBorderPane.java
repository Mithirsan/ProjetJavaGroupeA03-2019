package view;

import java.io.File;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;

public class WinScreenBorderPane extends BorderPane {
	private ImageView portalImageView;
	
	public WinScreenBorderPane() {
		BackgroundSize backgroundSize = new BackgroundSize( 960, 540, true, true, true, false);
		BackgroundImage bg = new BackgroundImage(new Image(new File("ressources/pictures/ThePath.png").toURI().toString()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
		setBackground(new Background(bg));
		setCenter(getPortalImageView());
	}

	public ImageView getPortalImageView() {
		if ( portalImageView==null) {
			Image image =new Image(new File("ressources/pictures/Gate.gif").toURI().toString());
			
			portalImageView = new ImageView(image);
			portalImageView.setFitWidth(1000);
			portalImageView.setPreserveRatio(true);
			portalImageView.setSmooth(true);
			portalImageView.setCache(true);
		}
		return portalImageView;
	}
}

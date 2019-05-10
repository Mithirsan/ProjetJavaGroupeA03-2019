package view;

import java.io.File;

import javafx.animation.PathTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.VLineTo;
import javafx.util.Duration;

public class LooseScreenBorderPane extends BorderPane {
	private Label lblMessage;
	private PathTransition pathTransition;
	private ImageView loseImage;
	private HBox contents;
	
	public LooseScreenBorderPane() {
		StackPane elements = new StackPane();
		elements.getChildren().addAll(getContents(), getLblMessage());
		elements.setAlignment(Pos.CENTER);
		setCenter(elements);
	}

	public Label getLblMessage() {
		if(lblMessage == null) {
			lblMessage = new Label("You've losed the game, click to continue");
			lblMessage.getStyleClass().add("withe");
			lblMessage.setVisible(false);
		}
		return lblMessage;
	}

	public PathTransition getPathTransition() {
		if(pathTransition == null) {
			Path path = new Path();
			path.getElements().add(new MoveTo(480., 0.));
		    path.getElements().add(new VLineTo(270.));
		    
		    getContents().getChildren().add(path);
		    getContents().getChildren().add(getLoseImage());
		    
		    pathTransition = new PathTransition();
		    pathTransition.setDuration(Duration.seconds(5.0));
		    pathTransition.setPath(path);
		    pathTransition.setNode(getLoseImage());
		    pathTransition.setCycleCount(1);
		    pathTransition.setOnFinished(e->{
		    	getLblMessage().setVisible(true);
		    });
		}
		return pathTransition;
	}

	public ImageView getLoseImage() {
		if(loseImage == null) {
			loseImage = new ImageView(new Image(new File("resources/pictures/bars.png").toURI().toString()));
			loseImage.setFitHeight(540);
			loseImage.setFitWidth(960);
		}
		return loseImage;
	}

	public HBox getContents() {
		if(contents == null) {
			contents = new HBox();
		}
		return contents;
	}
}

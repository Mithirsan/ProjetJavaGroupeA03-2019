package view;

import java.io.File;

import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MenuVBox extends VBox{
	private Button btnPlay;
	private Button btnLoad;
	private Button btnOption;
	private Button btnpresenter;
	private Button btnQuit;
	private MediaPlayer musicPlayer;
			
	
	public MenuVBox() {
		getChildren().addAll(getBtnPlay(),getBtnLoad(),getBtnOption(),getBtnQuit());
		setSpacing(10);
		setAlignment(Pos.CENTER);
		getMusic().play();
		getMusic().setVolume(0.05);
	}
	
	public Button getBtnPlay() {
		if(btnPlay==null) {
			btnPlay=new Button("Play");
			btnPlay.getStyleClass().add("mainMenuBtn");
			btnPlay.setOnAction(e->{
				getParent().setVisible(false);
				((FinalViewStackPane) getParent(). getParent()).getGamePlayBorderPane().setVisible(true);
				((FinalViewStackPane) getParent(). getParent()).getGamePlayBorderPane().getTimer().startTimer();
			});
		}
		return btnPlay;
	}
	public void setBtnPlay(Button btnPlay) {
		this.btnPlay = btnPlay;
	}
	public Button getBtnLoad() {
		if(btnLoad==null) {
			btnLoad=new Button("Load");
			btnLoad.getStyleClass().add("mainMenuBtn");
			
			btnLoad.setDisable(true);
		}
		return btnLoad;
	}
	
	public Button getBtnOption() {
		if(btnOption==null) {
			btnOption= new Button("Option");
			btnOption.getStyleClass().add("mainMenuBtn");
			btnOption.setOnAction(e->{
				((FinalViewStackPane) getParent() .getParent()).getOptionsMenuBorderPane().setVisible(true);
				((FinalViewStackPane) getParent() .getParent()).getMenuBorderPane().getMenuVBox().setVisible(false);
			});
			
		}
		return btnOption;
	}
	
	public Button getBtnQuit() {
		if(btnQuit==null) {
			btnQuit= new Button("Quit");
			btnQuit.getStyleClass().add("mainMenuBtn");
			btnQuit.setOnAction(e->{
				System.exit(0);
			});
		}
		return btnQuit;
	}
	public void setBtnQuit(Button btnQuit) {
		this.btnQuit = btnQuit;
	}

	public MediaPlayer getMusic() {
		if( musicPlayer==null) {
			Media media = new Media(new File("ressources/sounds/MusiqueTest.mp3").toURI().toString());
			musicPlayer = new MediaPlayer(media);
			musicPlayer.setCycleCount(Timeline.INDEFINITE);
		}
		return musicPlayer;
	}
}
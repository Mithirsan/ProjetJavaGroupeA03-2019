package view;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import model.Deck;
import model.Game;
import model.Stats;
import util.Serializable;

public class MenuVBox extends VBox{
	private Button btnPlay;
	private Button btnLoad;
	private Button btnOption;
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
				((FinalViewStackPane) getParent(). getParent()).getGamePlayBorderPane().getTimer().speechStatement().playFromStart();
				getMusic().stop();
				try {
					Stats stats = new Stats().downloadData();
					stats.setPartyPlayed();
					Serializable.writeSaveStats(stats.toJSon());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
			btnLoad.setOnAction(e->{
				getMusic().stop();
				try {
					Game game = new Game().downloadData();
					List<Boolean>tmpList =game.getJokerUsed();
					Deck.setInstance(game.getDeck());
					for(int i=0;i<game.getIndex();i++) {
						((FinalViewStackPane) getParent(). getParent()).getGamePlayBorderPane().getStatementAndChoices().getChoices().refreshForContinueGame();
					}
					((FinalViewStackPane) getParent(). getParent()).getGamePlayBorderPane().getTimer().setSeconds(game.getTimerLeft());
					Deck.getInstance().setJokers(tmpList);
					((FinalViewStackPane) getParent().getParent()).getGamePlayBorderPane().getOptionAndJokers().getBtnJokerAudienceOpinion().setDisable(!tmpList.get(0));
					((FinalViewStackPane) getParent().getParent()).getGamePlayBorderPane().getOptionAndJokers().getBtnJokerFiftyFifty().setDisable(!tmpList.get(1));	
					((FinalViewStackPane) getParent().getParent()).getGamePlayBorderPane().getOptionAndJokers().getBtnJokerTimeFreezer().setDisable(!tmpList.get(2));
					((FinalViewStackPane) getParent().getParent()).getGamePlayBorderPane().getOptionAndJokers().getBtnJokerAnotherChance().setDisable(!tmpList.get(3));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				getParent().setVisible(false);
				((FinalViewStackPane) getParent(). getParent()).getGamePlayBorderPane().setVisible(true);
			
				
			});
			
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
			Media media = new Media(new File("resources/sounds/Main music.wav").toURI().toString());
			musicPlayer = new MediaPlayer(media);
			musicPlayer.setCycleCount(Timeline.INDEFINITE);
		}
		return musicPlayer;
	}
}
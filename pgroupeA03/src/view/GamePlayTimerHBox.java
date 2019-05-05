package view;

import java.io.File;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class GamePlayTimerHBox extends HBox {
	
	private final int START_TIME = 45;
	private int seconds = START_TIME;
	private Timeline timer;
	
	private Label lblCountDown;
	
	private MediaPlayer mp45to20;
	private MediaPlayer mp20to10;
	private MediaPlayer mp10to0;
	
	public GamePlayTimerHBox() {
		this.setPadding(new Insets(10));
		this.setSpacing(5);
		
		this.getChildren().add(getLblCountDown());
		
		this.setAlignment(Pos.BASELINE_CENTER);
	}
	
	public Label getLblCountDown() {
		if(lblCountDown == null) {
			lblCountDown = new Label(START_TIME + " seconds remaining");
		}
		return lblCountDown;
	}
	
	public int getSeconds() {
		return seconds;
	}
	
	public void startTimer() {
		//creation d'une TimeLine cyclique infinie
		timer = new Timeline();
		timer.setCycleCount(Timeline.INDEFINITE);
		//si la TimeLine n'est pas null, on utilise la methode stopTimer
		if(timer != null) {
			stopTimer();
		}
		getMP45to20().play();
		//mise à jour du text
		getLblCountDown().setText(seconds + " seconds remaining");
		//creation d'une keyframe qui s'excecute toutes les seconds
		KeyFrame frame = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				seconds--;
				getLblCountDown().setText(seconds + " seconds remaining");
				
				if(seconds <= 0) {
					getMP10to0().stop();
					stopTimer();
					((FinalViewStackPane) getParent().getParent()).getGamePlayBorderPane().getStatementAndChoices().getChoices().fail();
				} else if(seconds < 10) {
					getMP20to10().stop();
					getMP10to0().play();
				} else if(seconds < 20) {
					getMP45to20().stop();
					getMP20to10().play();
				} 	
			}
		});
		timer.getKeyFrames().add(frame);
	}
	
	public Timeline speechStatement() {
		Timeline speech = new Timeline();
		speech.setCycleCount(1);
		KeyFrame frameSpeech = new KeyFrame(Duration.seconds(1),e->{
			if(((FinalViewStackPane) getParent(). getParent()).getOratorBorderPane().isChecked()) {
				String textLbl = ((FinalViewStackPane) getParent(). getParent()).getGamePlayBorderPane().getStatementAndChoices().getLblStatement().getText();
				((FinalViewStackPane) getParent(). getParent()).getOratorBorderPane().getTts().speak(textLbl,  2.0f, true, true);
				String choicesA = ((FinalViewStackPane) getParent(). getParent()).getGamePlayBorderPane().getStatementAndChoices().getChoices().getBtnAnswerA().getText();
				((FinalViewStackPane) getParent(). getParent()).getOratorBorderPane().getTts().speak(choicesA,  2.0f, true, true);
				String choicesB = ((FinalViewStackPane) getParent(). getParent()).getGamePlayBorderPane().getStatementAndChoices().getChoices().getBtnAnswerB().getText();
				((FinalViewStackPane) getParent(). getParent()).getOratorBorderPane().getTts().speak(choicesB,  2.0f, true, true);
				String choicesC = ((FinalViewStackPane) getParent(). getParent()).getGamePlayBorderPane().getStatementAndChoices().getChoices().getBtnAnswerC().getText();
				((FinalViewStackPane) getParent(). getParent()).getOratorBorderPane().getTts().speak(choicesC,  2.0f, true, true);
				String choicesD = ((FinalViewStackPane) getParent(). getParent()).getGamePlayBorderPane().getStatementAndChoices().getChoices().getBtnAnswerD().getText();
				((FinalViewStackPane) getParent(). getParent()).getOratorBorderPane().getTts().speak(choicesD,  2.0f, true, true);
				}
		});
		speech.getKeyFrames().add(frameSpeech);
		
		speech.setOnFinished(e->{
			timer.playFromStart();
		});
		
		return speech;
	}
	
	public void freezeTimer() {
		//utilisation du joker Time Frezer
		this.stopTimer();
		getMP45to20().stop();
		getMP20to10().stop();
		getMP10to0().stop();
		getLblCountDown().setText("Time freezed !");
	}
	
	public void stopTimer() {
		//arrete la timeline et remet les seconds à la valeur par default
		timer.stop();
		seconds = START_TIME;
	}
	
	public void pauseTimer(boolean bool) {
		//arrete la timeline ou la relance selon la velur reçue en arguement
		if(bool) {
			timer.stop();
		}
		else {
			if(!getLblCountDown().getText().equals("Time freezed !")) {
				timer.play();
			}	
		}
	}

	public Timeline getTimer() {
		return timer;
	}
	
	public void refreshTimer() {
		stopTimer();
		timer.play();
		speechStatement();
	}

	public void setSeconds(int seconds) {
		startTimer();
		stopTimer();
		this.seconds = seconds;
		timer.play();
	}
	
	public MediaPlayer getMP45to20() {
		if( mp45to20==null) {
			Media media = new Media(new File("resources/sounds/45-20.wav").toURI().toString());
			mp45to20 = new MediaPlayer(media);
			mp45to20.setCycleCount(Timeline.INDEFINITE);
			mp45to20.setVolume(0.1);
		}
		return mp45to20;
	}
	
	public MediaPlayer getMP20to10() {
		if( mp20to10==null) {
			Media media = new Media(new File("resources/sounds/20-10.wav").toURI().toString());
			mp20to10 = new MediaPlayer(media);
			mp20to10.setCycleCount(Timeline.INDEFINITE);
			mp20to10.setVolume(0.1);
		}
		return mp20to10;
	}
	
	public MediaPlayer getMP10to0() {
		if( mp10to0==null) {
			Media media = new Media(new File("resources/sounds/10-0.wav").toURI().toString());
			mp10to0 = new MediaPlayer(media);
			mp10to0.setCycleCount(Timeline.INDEFINITE);
			mp10to0.setVolume(0.1);
		}
		return mp10to0;
	}
}

package view;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

public class GamePlayTimerHBox extends HBox {
	
	private final int START_TIME = 45;
	private int seconds = START_TIME;
	private Timeline timer;
	
	private Label lblCountDown;
	
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
		//mise à jour du text
		getLblCountDown().setText(seconds + " seconds remaining");
		//creation d'une keyframe qui s'excecute toutes les seconds
		KeyFrame frame = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				seconds--;
				getLblCountDown().setText(seconds + " seconds remaining");
				//si le temps atteind 0, la partie est fini (utilisation de la methode fail() pour eviter le code redondant).
				if(seconds <= 0) {
					stopTimer();
					((FinalViewStackPane) getParent().getParent()).getGamePlayBorderPane().getStatementAndChoices().getChoices().fail();
				}
				
			}
		});
		timer.getKeyFrames().add(frame);
		timer.playFromStart();
	}
	
	public void freezeTimer() {
		//utilisation du joker Time Frezer
		this.stopTimer();
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
	}

	public void setSeconds(int seconds) {
		startTimer();
		stopTimer();
		this.seconds = seconds;
		timer.play();
	}
	
	
	
}

package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.scene.layout.BorderPane;
import model.Deck;

public class GamePlayBorderPane extends BorderPane {

	private GamePlayStatementAndChoicesVBox statementAndChoices;
	private GamePlayOptionAndJokersVBox optionAndJokers;
	private GamePlayLevelsVBox levels;
	private GamePlayTimerHBox timer ;
	private GameplayPoolStatusHBox poolStatus;
	
	public GamePlayBorderPane() {
		setTop(getTimer());
		setLeft(getOptionAndJokers());
		setCenter(getPoolStatus());
		setRight(getLevels());
		setBottom(getStatementAndChoices()); 
	}
	
	public GamePlayStatementAndChoicesVBox getStatementAndChoices() {
		if(statementAndChoices==null) {
			statementAndChoices = new GamePlayStatementAndChoicesVBox ();
		}
		return statementAndChoices;
	}

	public GamePlayOptionAndJokersVBox getOptionAndJokers() {
		if(optionAndJokers==null) {
			optionAndJokers = new GamePlayOptionAndJokersVBox();
		}
		return optionAndJokers;
	}

	public GamePlayLevelsVBox getLevels() {
		if(levels==null) {
			levels = new GamePlayLevelsVBox();
		}
		return levels;
	}
	
	public GamePlayTimerHBox getTimer() {
		if(timer==null) {
			timer=new GamePlayTimerHBox();
		}
		return timer;
	}

	public GameplayPoolStatusHBox getPoolStatus() {
		if(poolStatus==null) {
			poolStatus=new GameplayPoolStatusHBox();
		}
		return poolStatus;
	}
	public void reset() {
		Deck.getInstance().addQuestions();
		
		getLevels().restart();
		getStatementAndChoices().getChoices().resetTxt();
		getPoolStatus().getLblViewPool().setText("none");
		getOptionAndJokers().getBtnJokerAnotherChance().setDisable(false);
		getOptionAndJokers().getBtnJokerAudienceOpinion().setDisable(false);
		getOptionAndJokers().getBtnJokerFiftyFifty().setDisable(false);
		getOptionAndJokers().getBtnJokerTimeFreezer().setDisable(false);
		
	}
}

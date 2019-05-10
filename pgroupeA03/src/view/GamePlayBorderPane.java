package view;

import javafx.scene.layout.BorderPane;

import model.Deck;

public class GamePlayBorderPane extends BorderPane {

	private GamePlayStatementAndChoicesVBox statementAndChoices;
	private GamePlayOptionAndJokersVBox optionAndJokers;
	private GamePlayLevelsVBox levels;
	private GamePlayTimerHBox timer ;
	private GameplayPresenterAndPoolStatusHBox presenterAndPoolStatus;
	
	public GamePlayBorderPane() {
		setTop(getTimer());
		setLeft(getOptionAndJokers());
		setCenter(getPresenterAndPoolStatus());
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

	public GameplayPresenterAndPoolStatusHBox getPresenterAndPoolStatus() {
		if(presenterAndPoolStatus==null) {
			presenterAndPoolStatus=new GameplayPresenterAndPoolStatusHBox();
		}
		return presenterAndPoolStatus;
	}
	
	public void resetForNewGame() {
		Deck.getInstance().refreshGameQuestion();
		getLevels().restart();
		getStatementAndChoices().getChoices().resetTxt();
		getPresenterAndPoolStatus().getLblViewPool().setText("none");
		getOptionAndJokers().getBtnJokerAnotherChance().setDisable(false);
		getOptionAndJokers().getBtnJokerAudienceOpinion().setDisable(false);
		getOptionAndJokers().getBtnJokerFiftyFifty().setDisable(false);
		getOptionAndJokers().getBtnJokerTimeFreezer().setDisable(false);
		
	}
}

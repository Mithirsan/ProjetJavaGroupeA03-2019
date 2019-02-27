package view;

import javafx.scene.layout.BorderPane;

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
		freeze();
	}
	
	public void freeze() {
		getOptionAndJokers().getBtnJokerTimeFreezer().setOnAction(e->{
			getTimer().freezeTimer(getTimer().getSeconds());
		});
	}
	
	public GamePlayStatementAndChoicesVBox getStatementAndChoices() {
		if(statementAndChoices==null) {
			statementAndChoices = new GamePlayStatementAndChoicesVBox ();
		}
		return statementAndChoices;
	}
	
	public void setStatementAndChoices(GamePlayStatementAndChoicesVBox statementAndChoices) {
		this.statementAndChoices = statementAndChoices;
	}
	
	public GamePlayOptionAndJokersVBox getOptionAndJokers() {
		if(optionAndJokers==null) {
			optionAndJokers = new GamePlayOptionAndJokersVBox();
		}
		return optionAndJokers;
	}
	
	public void setOptionAndJokers(GamePlayOptionAndJokersVBox optionAndJokers) {
		this.optionAndJokers = optionAndJokers;
	}
	
	public GamePlayLevelsVBox getLevels() {
		if(levels==null) {
			levels = new GamePlayLevelsVBox();
		}
		return levels;
	}
	
	public void setLevels(GamePlayLevelsVBox levels) {
		this.levels = levels;
	}
	public GamePlayTimerHBox getTimer() {
		if(timer==null) {
			timer=new GamePlayTimerHBox();
		}
		return timer;
	}
	public void setTimer(GamePlayTimerHBox timer) {
		this.timer = timer;
	}
	public GameplayPoolStatusHBox getPoolStatus() {
		if(poolStatus==null) {
			poolStatus=new GameplayPoolStatusHBox();
		}
		return poolStatus;
	}
	public void setPoolStatus(GameplayPoolStatusHBox poolStatus) {
		this.poolStatus = poolStatus;
	}
}

package view;

import javafx.scene.layout.BorderPane;

public class GamePlayBorderPane extends BorderPane {

	private GamePlayStatementAndChoicesVBox statementAndChoices = new GamePlayStatementAndChoicesVBox();
	private GamePlayOptionAndJokersVBox optionAndJokers = new GamePlayOptionAndJokersVBox();
	private GamePlayLevelsVBox levels = new GamePlayLevelsVBox();
	private GamePlayTimerHBox timer = new GamePlayTimerHBox();
	private GameplayPoolStatusHBox poolStatus = new GameplayPoolStatusHBox();
	
	public GamePlayBorderPane() {
		setTop(timer);
		setLeft(optionAndJokers);
		setCenter(poolStatus);
		setRight(levels);
		setBottom(statementAndChoices);
	}
}

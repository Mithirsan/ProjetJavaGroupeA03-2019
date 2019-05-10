package view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.effect.PerspectiveTransform;
import javafx.scene.layout.VBox;
import model.Stage;
import model.Stats;
import util.Serializable;

public class GamePlayLevelsVBox extends VBox {

	private List<Label> lblLevels;
	
	private int stage;
	
	public GamePlayLevelsVBox() {
		PerspectiveTransform e = new PerspectiveTransform();
		//left top
		e.setUlx(-40);   e.setUly(40);
		//right top
        e.setUrx(90);  e.setUry(-20);
        //left bottom
        e.setLlx(-40);  e.setLly(370); 
        //right bottom
        e.setLrx(90);  e.setLry(430);
        
		this.setPadding(new Insets(10));
		this.setSpacing(5);    
        
		this.getChildren().addAll(getLblLevels());
		
		this.setEffect(e);
	}

	public List<Label> getLblLevels() {
		if (lblLevels == null) {
			lblLevels = new ArrayList<Label>();
			int tmp = -1;
			ObservableList<Stage> stages = FXCollections.observableArrayList(Stage.values());
			for (Stage s : stages) {
				Label tmpLabel = new Label(s.getStage());
				lblLevels.add(0,tmpLabel);
				tmp ++;
			}
			stage = tmp;
			lblLevels.get(stage).getStyleClass().add("stageActual");
		}
		return lblLevels;
	}
	
	public void nextStage() {
		lblLevels.get(stage).getStyleClass().remove("stageActual");
		if(stage%5 ==0) {
			lblLevels.get(stage).getStyleClass().add("stageWonSaved");
			((GamePlayBorderPane)getParent()).getOptionAndJokers().getBtnJokerAnotherChance().setDisable(false);
		} else { 
			lblLevels.get(stage).getStyleClass().add("stageWon");
		}
		String tmp = lblLevels.get(stage).getText();
		if (stage == 0) {
			((FinalViewStackPane) getParent().getParent()).getGamePlayBorderPane().setVisible(false);
			((FinalViewStackPane) getParent().getParent()).getGamePlayBorderPane().getTimer().stopTimer();
			((FinalViewStackPane) getParent().getParent()).getGamePlayBorderPane().resetForNewGame();
			((FinalViewStackPane) getParent().getParent()).getWinScreen().setVisible(true);
			Stats stats;
			try {
				stats = new Stats().downloadData();
				stats.setPartyWin();
				stats.setTotalDays(14);
				Serializable.writeSaveStats(stats.toJSon());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} else {
			lblLevels.get(--stage).getStyleClass().add("stageActual");
		    ((FinalViewStackPane) getParent().getParent()).getGamePlayBorderPane().getPresenterAndPoolStatus().getLblViewPool().setText(tmp);
		}
	}

	public void restart() {
		for(Label l : lblLevels) {
			l.getStyleClass().removeAll("stageActual", "stageWonSaved", "stageWon");
		}
		stage = 14;
		lblLevels.get(stage).getStyleClass().add("stageActual");
	}

	public int getStage() {
		return stage;
	}

	public void setStage(int stage) {
		this.stage = stage;
	}
}

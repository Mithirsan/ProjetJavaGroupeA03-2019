package view;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import model.Stage;

public class GamePlayLevelsVBox extends VBox {
	
	private List<Label> lblLevels;
	
	private int stage;
	
	public GamePlayLevelsVBox() {
		this.setPadding(new Insets(10));
		this.setSpacing(5);
		this.getChildren().addAll(getLblLevels());
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
		} else { 
			lblLevels.get(stage).getStyleClass().add("stageWon");
		}
		String tmp = lblLevels.get(stage).getText();
		lblLevels.get(--stage).getStyleClass().add("stageActual");
	//	((FinalViewStackPane) getParent().getParent().getParent()).getGamePlayBorderPane().getPoolStatus().getLblViewPool().setText(tmp);
	}
}

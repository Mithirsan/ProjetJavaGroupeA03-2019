package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

public class GamePlayLevelsVBox extends VBox {
	
	private ListView<String> lvLevels;
	
	public GamePlayLevelsVBox() {
		this.setPadding(new Insets(10));
		this.setSpacing(5);
		
		this.getChildren().addAll(getLvLevels());
	}
	
	public ListView<String> getLvLevels() {
		if(lvLevels == null) {
			lvLevels = new ListView<String>();
			ObservableList<String> items = FXCollections.observableArrayList(
					"15", "14", "13", "12", "11", "10", "9", "8", "7", "6", "5", "4", "3", "2", "1");
			lvLevels.setItems(items);
		}
		return lvLevels;
	}
}

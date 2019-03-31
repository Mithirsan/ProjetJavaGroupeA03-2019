package view;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import model.Stage;



public class LeavingHBox extends HBox {

	
	private Label lblLeaveGain;
	private Label lblPool;
	


	public LeavingHBox () {
		this.setPadding(new Insets (10));
		
		
		this.getChildren().add(getLblLeaveGain());
		
			
								
		setAlignment(Pos.CENTER);
		
	}
		

	public Label getLblLeaveGain() {
		if(lblLeaveGain==null) {
			lblLeaveGain = new  Label ("Your gain is :"); 
		}
		return lblLeaveGain;
	}
	
	
	public Label getLblPool() {
		if(lblPool==null) {
			lblPool = new Label (((FinalViewStackPane) getParent().getParent().getParent()).getGamePlayBorderPane().getPoolStatus().getLblViewPool().getText());
		}
		return lblPool;
	}

}


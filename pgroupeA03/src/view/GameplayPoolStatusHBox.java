package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class GameplayPoolStatusHBox extends HBox{
	
	private Button btnLeaveWithPool;
	
	private Label lblViewPool;
	
	public GameplayPoolStatusHBox() {
		this.setPadding(new Insets(10));
		this.setSpacing(5);
		
		this.getChildren().addAll(getLblViewPool(), getBtnLeaveWithPool());
		
		this.setAlignment(Pos.BOTTOM_CENTER);
	}

	public Button getBtnLeaveWithPool() {
		if (btnLeaveWithPool == null) {
			btnLeaveWithPool = new Button("Leave with the actual pool");
		}
		return btnLeaveWithPool;
	}

	public Label getLblViewPool() {
		if(lblViewPool == null) {
			lblViewPool = new Label("none");
		}
		return lblViewPool;
	}
}

package view;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class AdminBorderPane extends BorderPane {
	
	private Label lblWelcome;

	public AdminBorderPane() {
		
		setCenter(getLblWelcome());
	}
	
	
	
	public Label getLblWelcome() {
		if(lblWelcome==null) {
			lblWelcome = new Label("Welcome admin");
		}
		return lblWelcome;
	}
}

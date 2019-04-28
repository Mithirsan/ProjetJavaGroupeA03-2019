package view;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class OptionsMenuBorderPane extends BorderPane {

	private Label lblTitle;
	private OptionsMenuVBox optionsMenuVBox;
	
	public OptionsMenuBorderPane() {
		setCenter(getOptionsVBox());
	}
	
	public Label getLblTitle() {
		if(lblTitle==null) {
			lblTitle= new Label("Option");
		}
		return lblTitle;
	}

	public OptionsMenuVBox getOptionsVBox() {
		if(optionsMenuVBox==null) {
			optionsMenuVBox = new OptionsMenuVBox();
		}
		return optionsMenuVBox;
	}

}

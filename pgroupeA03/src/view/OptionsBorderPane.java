package view;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class OptionsBorderPane extends BorderPane {

	private Label lblTitle;
	private OptionsVBox optionsVBox;
	
	public OptionsBorderPane() {
		setCenter(getOptionsVBox());
	}
	
	public Label getLblTitle() {
		if(lblTitle==null) {
			lblTitle= new Label("Option");
		}
		return lblTitle;
	}

	public OptionsVBox getOptionsVBox() {
		if(optionsVBox==null) {
			optionsVBox = new OptionsVBox();
		}
		return optionsVBox;
	}
}




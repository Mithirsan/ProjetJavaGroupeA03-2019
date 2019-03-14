package view;

import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TrueVBox extends VBox {
	private RadioButton [] rdbTrue;
	private ToggleGroup toggle;	
	public TrueVBox() {	
		for (RadioButton rdb : getRdbTrue()) {
			getChildren().add(rdb);
			setSpacing(10.);
		}
		
	}
	
	public RadioButton[] getRdbTrue() {
		if(rdbTrue==null) {
			rdbTrue = new RadioButton [4];
			for (int i = 0; i<=3;i++) {
				rdbTrue [i] = new RadioButton("True");			
				rdbTrue [i].setToggleGroup(getToggle());
				if (i == 0) {
					rdbTrue[0].setSelected(true);
				}
			}		
		}
		return rdbTrue;
	}
	public ToggleGroup getToggle() {
		if(toggle==null) {
			toggle = new ToggleGroup();
		}
		return toggle;
	}
}

package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class LeavingHBox extends HBox {

	
	private Label lblLeaveGain;
	private Label lblPool;
	private String gain;
	


	public LeavingHBox () {
		this.setPadding(new Insets (10));
		
		this.getChildren().addAll(getLblPool(),getLblLeaveGain());
		
		
								
		setAlignment(Pos.CENTER);
		
	}
		

	public Label getLblLeaveGain() {
		if(lblLeaveGain==null) {
			lblLeaveGain = new  Label (gain); 
			
		}
		return lblLeaveGain;
	}


	public String getGain() {
		return gain;
	}


	public void setGain(String gain) {
		this.gain = gain;
		lblLeaveGain.setText(gain);
	}
	
	
	public Label getLblPool() {
		if(lblPool==null) {
			lblPool = new Label ("Your gain is : ");
		}	
		return lblPool;
	}
	

}


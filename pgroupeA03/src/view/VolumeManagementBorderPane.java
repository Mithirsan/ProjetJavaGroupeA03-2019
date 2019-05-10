package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class VolumeManagementBorderPane extends BorderPane {
	private Slider sliderVolume;
	
	private Label soundLbl ;
	private Button btnBack;
	private double soundVolume = 100.;
	
	public VolumeManagementBorderPane() {
		HBox viewProgresHBox= new HBox();
		viewProgresHBox.getChildren().addAll(getSliderVolume());
		viewProgresHBox.setAlignment(Pos.CENTER);
		VBox soundVBox = new VBox();
		soundVBox.getChildren().addAll(viewProgresHBox,getSoundLbl(),getBtnBack());
		soundVBox.setPadding(new Insets(10));
		soundVBox.setSpacing(5);
		soundVBox.setAlignment(Pos.CENTER);
		setCenter(soundVBox );		
	}
	
	public Slider getSliderVolume() {
		if(sliderVolume == null) {
			sliderVolume = new Slider();
			sliderVolume.setValue(50.);
			sliderVolume.setMin(0.);
			sliderVolume.setMax(100.);
			sliderVolume.setPrefWidth(200.);
			sliderVolume.setPadding(new Insets(10.));
			sliderVolume.valueProperty().addListener((observable, oldValue, newValue) -> {
				soundVolume = newValue.doubleValue();
				oldValue.doubleValue();
				sliderVolume.setValue(newValue.doubleValue());
				int tmpSoundValue = (int) soundVolume;
				getSoundLbl().setText(tmpSoundValue +"%");
				((FinalViewStackPane) getParent()).getMenuBorderPane().getMenuVBox().getMusic().setVolume(soundVolume/100.);
			});
		}
		return sliderVolume;
	}

	public Label getSoundLbl() {
		if( soundLbl==null) {
			 soundLbl =new Label("50%");
		}
		return soundLbl;
	}
	
	public Button getBtnBack() {
			if(btnBack==null) {
				btnBack = new Button("Return to menu");
				btnBack.setOnAction(e->{
					((FinalViewStackPane) getParent()).getOptionsMenuBorderPane().setVisible(true);
					((FinalViewStackPane) getParent()).getVolumeManagementBorderPane().setVisible(false);	
				});		
			}
			return btnBack;
	}	
}

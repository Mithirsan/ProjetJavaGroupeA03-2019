package view;

import util.TextToSpeech;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class OratorChoicesBorderPane extends BorderPane{
	private Button btnVoice1;
	private Button btnVoice2;
	private Button btnVoice3;
	private TextToSpeech tts = new TextToSpeech();
	private Button btnRetrun;
	private CheckBox chkActivate;
	private boolean checked=false;
	
	public OratorChoicesBorderPane() {
		VBox vboxBtnVoice = new VBox(getChkActivate(),getBtnVoice1(),getBtnVoice2(),getBtnVoice3(),getBtnRetrun());
		setCenter(vboxBtnVoice);
		
	}
	

	public CheckBox getChkActivate() {
		if(chkActivate==null) {
			chkActivate =new CheckBox("Activate");
			chkActivate.setOnAction(e->{
				checked=!checked;
			});
		}
		return chkActivate;
	}


	public Button getBtnVoice1() {
		if(btnVoice1==null) {
			btnVoice1 = new Button("Male voice");
			btnVoice1.setOnAction(e->{
			tts.setVoice("cmu-rms-hsmm");	
			tts.speak("This is a test", 2.0f, false, true);
			});
		}
		return btnVoice1;
	}


	public Button getBtnVoice2() {
		if(btnVoice2==null) {
			btnVoice2 = new Button("Female voice 1");
			btnVoice2.setOnAction(e->{
			tts.setVoice("dfki-poppy-hsmm");
			tts.speak("This is a test", 2.0f, false, true);
			});
		}
		return btnVoice2;
	}


	public Button getBtnVoice3() {
		if( btnVoice3==null) {
			btnVoice3 = new Button("Female voice 2");
			btnVoice3.setOnAction(e->{
			tts.setVoice("cmu-slt-hsmm");
			tts.speak("This is a test", 2.0f, false, true);
			});
		}
		return btnVoice3;
	}
	public Button getBtnRetrun() {
		if(btnRetrun==null) {
			btnRetrun = new Button("Return to menu");
			btnRetrun.setOnAction(e->{
				((FinalViewStackPane) getParent()).getOptionsMenuBorderPane().setVisible(true);
				((FinalViewStackPane) getParent()).getOratorBorderPane().setVisible(false);	
			});
		}
		return btnRetrun;
	}



	public TextToSpeech getTts() {
		return tts;
	}


	public boolean isChecked() {
		return checked;
	}
	
	
	
	
	
	
	
	
	
}

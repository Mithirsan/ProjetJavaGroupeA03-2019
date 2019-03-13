package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class OptionsVBox extends VBox{
	private Button btnContinue;
	private Button btnQuit;
	private Button btnVolumeManagement;
	private Button btnDisplayManagement;
	private static final double prefWidth = 150. ;
			
	
	public OptionsVBox() {
		getChildren().addAll(getBtnContinue(),getBtnQuit(),getBtnVolumeManagement(),getBtnDisplayManagement());
		setSpacing(10);
		setAlignment(Pos.CENTER);
	}
	
	public Button getBtnContinue() {
		if(btnContinue==null) {
			btnContinue=new Button("Continue");
			btnContinue.setPrefWidth(prefWidth);
			btnContinue.setOnAction(e->{
				((FinalViewStackPane) getParent() .getParent()).getGamePlayBorderPane().setVisible(true);
				((FinalViewStackPane) getParent() .getParent()).getOptionBorderPane().setVisible(false);
				((FinalViewStackPane) getParent().getParent()).getGamePlayBorderPane().getTimer().pauseTimer(false);
				
			});
		}
		return btnContinue;
	}

	
	public Button getBtnVolumeManagement() {
		if(btnVolumeManagement==null) {
			btnVolumeManagement=new Button("Volume Management");
			btnVolumeManagement.setPrefWidth(prefWidth);
		}
		return btnVolumeManagement;
	}

	public Button getBtnDisplayManagement() {
		if(btnDisplayManagement==null) {
			btnDisplayManagement= new Button("Display Management");
			btnDisplayManagement.setPrefWidth(prefWidth);
		}
		return btnDisplayManagement;
	}
	
	public Button getBtnQuit() {
		if(btnQuit==null) {
			btnQuit= new Button("Quit");
			btnQuit.setPrefWidth(prefWidth);
			btnQuit.setOnAction(e->{
				((FinalViewStackPane) getParent() .getParent()).getOptionBorderPane().setVisible(false);
				((FinalViewStackPane) getParent() .getParent()).getMenuBorderPane().setVisible(true);
			});
		}
		return btnQuit;
	}	
}

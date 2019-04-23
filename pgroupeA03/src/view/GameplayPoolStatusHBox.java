package view;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class GameplayPoolStatusHBox extends BorderPane {
	
	private Button btnLeaveWithPool;
	

	private ImageView imagePresenter;
	
	private Label lblViewPool;
	
	public GameplayPoolStatusHBox() {
		this.setPadding(new Insets(10));
		HBox hboxgain = new HBox (getLblViewPool(), getBtnLeaveWithPool());
		hboxgain.setSpacing(10);
		hboxgain.setAlignment(Pos.BASELINE_CENTER);
		setBottom(hboxgain);
	}

	public ImageView getImagePresenter() {
		return imagePresenter;
	}

	public Button getBtnLeaveWithPool() {
		if (btnLeaveWithPool == null) {
			btnLeaveWithPool = new Button("Leave with the actual gain");
			btnLeaveWithPool.getStyleClass().add("btnLeaveWPool");
			btnLeaveWithPool.setOnAction(e-> {
				((FinalViewStackPane) getParent() .getParent()).getLeavingHBox().setGain(getLblViewPool().getText());
				((FinalViewStackPane) getParent() .getParent()).getGamePlayBorderPane().setVisible(false);
				((FinalViewStackPane) getParent() .getParent()).getLeavingHBox().setVisible(true);
			});
			
		}
		return btnLeaveWithPool;
	}

	public Label getLblViewPool() {
		if(lblViewPool == null) {
			lblViewPool = new Label("none");
			lblViewPool.getStyleClass().add("lblViewPool");
		}
		return lblViewPool;
	}
	public void putNewImage (ImageView image) {
		imagePresenter=image;
		this.getChildren().add(getImagePresenter());
		
		
	}
}

package view;


import java.io.File;
import java.io.IOException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import model.Deck;
import model.Stats;
import util.Serializable;

public class GameplayPoolStatusHBox extends BorderPane {
	private Button btnLeaveWithPool;
	
	private ImageView imagePresenter;
	
	private Label lblViewPool;
	
	public GameplayPoolStatusHBox() {
		this.setPadding(new Insets(10));
		setCenter(getImagePresenter());
		HBox hboxgain = new HBox (getLblViewPool(), getBtnLeaveWithPool());
		hboxgain.setSpacing(10);
		hboxgain.setAlignment(Pos.BASELINE_CENTER);
		setBottom(hboxgain);
		 
		
	}

	public ImageView getImagePresenter() {
		if(imagePresenter==null) {
			imagePresenter= new ImageView(new Image ( new File("resources/pictures/JP-Foucault.jpg").toURI().toString() ));
		}
		return imagePresenter;
	}
	

	public void setImagePresenter(Image imagePresenter) {
		this.getImagePresenter().setImage(imagePresenter);
	}

	public Button getBtnLeaveWithPool() {
		if (btnLeaveWithPool == null) {
			btnLeaveWithPool = new Button("Leave with the actual gain");
			btnLeaveWithPool.getStyleClass().add("btnLeaveWPool");
			btnLeaveWithPool.setOnAction(e-> {
				((FinalViewStackPane) getParent() .getParent()).getLeavingHBox().setGain(getLblViewPool().getText());
				((FinalViewStackPane) getParent() .getParent()).getGamePlayBorderPane().setVisible(false);
				((FinalViewStackPane) getParent() .getParent()).getLeavingHBox().setVisible(true);
				((FinalViewStackPane) getParent() .getParent()).getGamePlayBorderPane().getTimer().stopTimer();
				((FinalViewStackPane)getParent().getParent().getParent()).getMenuBorderPane().getMenuVBox().getMusic().play();
				
				Stats stats;
				try {
					stats = new Stats().downloadData();
					stats.setPartyWin();
					int tmpStage = ((FinalViewStackPane) getParent().getParent()).getGamePlayBorderPane().getLevels().getStage();
					if((tmpStage>=0)&&(tmpStage<14) ) {
						stats.setTotalDays(14-(tmpStage+1));
					}
					Serializable.writeSaveStats(stats.toJSon());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				((FinalViewStackPane) getParent() .getParent()).getGamePlayBorderPane().reset();
				Deck.getInstance().jokerReset();
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
}

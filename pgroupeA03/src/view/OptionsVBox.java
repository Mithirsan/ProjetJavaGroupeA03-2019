package view;

import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import model.Deck;
import model.Game;
import util.Serializable;

public class OptionsVBox extends VBox{
	private Button btnContinue;
	private Button btnQuit;
	private Button btnQuitAndSave;
	private Button btnVolumeManagement;
	private Button btnDisplayManagement;
			
	public OptionsVBox() {
		getChildren().addAll(getBtnContinue(),getBtnVolumeManagement(),getBtnDisplayManagement(),getBtnQuitAndSave(),getBtnQuit());
		setSpacing(10);
		setAlignment(Pos.CENTER);
	}
	
	public Button getBtnContinue() {
		if(btnContinue==null) {
			btnContinue=new Button("Continue");
			btnContinue.getStyleClass().add("mainMenuBtn");
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
			btnVolumeManagement.getStyleClass().add("mainMenuBtn");
			
			btnVolumeManagement.setOnAction(e->{
				getParent().setVisible(false);
				((FinalViewStackPane) getParent(). getParent()).getVolumeManagementBorderPane().setVisible(true);
			});
		}
		return btnVolumeManagement;
	}

	public Button getBtnDisplayManagement() {
		if(btnDisplayManagement==null) {
			btnDisplayManagement= new Button("Display Management");
			btnDisplayManagement.getStyleClass().add("mainMenuBtn");
			
			btnDisplayManagement.setDisable(true);
		}
		return btnDisplayManagement;
	}
	
	public Button getBtnQuitAndSave() {
		if(btnQuitAndSave == null) {
			btnQuitAndSave = new Button("Save & Quit");
			btnQuitAndSave.getStyleClass().add("mainMenuBtn");
			btnQuitAndSave.setOnAction(e->{
				((FinalViewStackPane) getParent() .getParent()).getOptionBorderPane().setVisible(false);
				((FinalViewStackPane) getParent() .getParent()).getMenuBorderPane().setVisible(true);
				((FinalViewStackPane)getParent().getParent()).getMenuBorderPane().getMenuVBox().getMusic().play();
				
				int tmpIndex = Deck.getInstance().getIndex();
				int tmpTimeLeft =((FinalViewStackPane) getParent().getParent()).getGamePlayBorderPane().getTimer().getSeconds();
				List<Boolean>tmpList = Deck.getInstance().getJokers();
				Deck tmpDeck = Deck.getInstance();
				Game saveGame = new Game(tmpIndex, tmpTimeLeft, tmpList, tmpDeck);
				Serializable.writeSaveGame(saveGame.toJSon());
				((FinalViewStackPane) getParent() .getParent()).getGamePlayBorderPane().reset();
				Deck.getInstance().jokerReset();
			});
		}
		return btnQuitAndSave;
	}

	public Button getBtnQuit() {
		if(btnQuit==null) {
			btnQuit= new Button("Quit");
			btnQuit.getStyleClass().add("mainMenuBtn");
			btnQuit.setOnAction(e->{
				((FinalViewStackPane) getParent() .getParent()).getOptionBorderPane().setVisible(false);
				((FinalViewStackPane) getParent() .getParent()).getMenuBorderPane().setVisible(true);
				((FinalViewStackPane)getParent().getParent()).getMenuBorderPane().getMenuVBox().getMusic().play();
			});
		}
		return btnQuit;
	}	
}

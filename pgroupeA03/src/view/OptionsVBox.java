package view;

import java.util.ArrayList;
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
	private Button btnVolumeManagement;
	private Button btnDisplayManagement;
			
	public OptionsVBox() {
		getChildren().addAll(getBtnContinue(),getBtnVolumeManagement(),getBtnDisplayManagement(),getBtnQuit());
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
			
			btnVolumeManagement.setDisable(true);
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
	
	public Button getBtnQuit() {
		if(btnQuit==null) {
			btnQuit= new Button("Quit");
			btnQuit.getStyleClass().add("mainMenuBtn");
			btnQuit.setOnAction(e->{
				((FinalViewStackPane) getParent() .getParent()).getOptionBorderPane().setVisible(false);
				((FinalViewStackPane) getParent() .getParent()).getMenuBorderPane().setVisible(true);
				int tmpIndex = Deck.getInstance().getIndex();
				int tmpTimeLeft =((FinalViewStackPane) getParent().getParent()).getGamePlayBorderPane().getTimer().getSeconds();
				boolean tmpJ1,tmpJ2,tmpJ3,tmpJ4;
				tmpJ1=((FinalViewStackPane) getParent().getParent()).getGamePlayBorderPane().getOptionAndJokers().getBtnJokerAnotherChance().isDisabled();
				tmpJ2=((FinalViewStackPane) getParent().getParent()).getGamePlayBorderPane().getOptionAndJokers().getBtnJokerAudienceOpinion().isDisabled();
				tmpJ3=((FinalViewStackPane) getParent().getParent()).getGamePlayBorderPane().getOptionAndJokers().getBtnJokerFiftyFifty().isDisabled();
				tmpJ4=((FinalViewStackPane) getParent().getParent()).getGamePlayBorderPane().getOptionAndJokers().getBtnJokerTimeFreezer().isDisabled();
				List<Boolean>tmpList = new ArrayList<>();
				tmpList.add(tmpJ1);
				tmpList.add(tmpJ2);
				tmpList.add(tmpJ3);
				tmpList.add(tmpJ4);
				Deck tmpDeck = Deck.getInstance();
				Game saveGame = new Game(tmpIndex, tmpTimeLeft, tmpList, tmpDeck);
				Serializable.writeSaveGame(saveGame.toJSon());
				((FinalViewStackPane) getParent() .getParent()).getGamePlayBorderPane().reset();
						});
		}
		return btnQuit;
	}	
}

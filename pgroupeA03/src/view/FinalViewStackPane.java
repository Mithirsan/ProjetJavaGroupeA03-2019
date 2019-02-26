package view;

import javafx.scene.layout.StackPane;

public class FinalViewStackPane extends StackPane{
	private MenuBorderPane menuBorderPane;
	private GamePlayBorderPane gamePlayBorderPane;
	
	

	public FinalViewStackPane() {
		getChildren().addAll(getMenuBorderPane(),getGamePlayBorderPane());
		
	}

	public MenuBorderPane getMenuBorderPane() {
		if(menuBorderPane==null) {
			menuBorderPane= new MenuBorderPane();
			menuBorderPane.getMenuVBox().getBtnPlay().setOnAction(e->{
				menuBorderPane.setVisible(false);
				getGamePlayBorderPane().setVisible(true);
			});
		}
		return menuBorderPane;
	}

	public void setMenuBorderPane(MenuBorderPane menuBorderPane) {
		this.menuBorderPane = menuBorderPane;
	}
	
	public GamePlayBorderPane getGamePlayBorderPane() {
		if(gamePlayBorderPane==null) {
			gamePlayBorderPane = new GamePlayBorderPane();
			gamePlayBorderPane.setVisible(false);
			
		}
		return gamePlayBorderPane;
	}

	public void setGamePlayBorderPane(GamePlayBorderPane gamePlayBorderPane) {
		this.gamePlayBorderPane = gamePlayBorderPane;
	}
}

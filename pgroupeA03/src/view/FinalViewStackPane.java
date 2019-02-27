package view;

import javafx.scene.layout.StackPane;

public class FinalViewStackPane extends StackPane{
	private MenuBorderPane menuBorderPane;
	private GamePlayBorderPane gamePlayBorderPane;
	private LoginAdminAnchorPane loginAdminAnchorPane;
	

	public FinalViewStackPane() {
		getChildren().addAll(getMenuBorderPane(),getGamePlayBorderPane(),getLoginAdminAnchorPane());
		
	}

	public MenuBorderPane getMenuBorderPane() {
		if(menuBorderPane==null) {
			menuBorderPane= new MenuBorderPane();
		}
		return menuBorderPane;
	}
	
	public GamePlayBorderPane getGamePlayBorderPane() {
		if(gamePlayBorderPane==null) {
			gamePlayBorderPane = new GamePlayBorderPane();
			gamePlayBorderPane.setVisible(false);
			
		}
		return gamePlayBorderPane;
	}

	public LoginAdminAnchorPane getLoginAdminAnchorPane() {
		if(loginAdminAnchorPane==null) {
			loginAdminAnchorPane= new LoginAdminAnchorPane();
			loginAdminAnchorPane.setVisible(false);
		}
		return loginAdminAnchorPane;
	}

	
	
}

package view;

import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

public class AdminBorderPane extends BorderPane {
	
	private MenuBar menuBar;
	private Menu menuQuit;

	public AdminBorderPane() {
		setTop(getMenuBar());
		
		
	}

	public MenuBar getMenuBar() {
		if(menuBar==null) {
			menuBar= new MenuBar();
			menuBar.getMenus().add(getMenuQuit());
		}
		return menuBar;
	}

	public Menu getMenuQuit() {
		if(menuQuit==null)
		{
			Label lblQuit = new Label("Quit");
			menuQuit = new Menu("",lblQuit);
			lblQuit.setOnMouseClicked(e->{
				((FinalViewStackPane) getParent()).getLoginAdminAnchorPane().setVisible(true);
				((FinalViewStackPane) getParent()).getAdminBorderPane().setVisible(false);
				
			});
			
		}
		return menuQuit;
	}	
}

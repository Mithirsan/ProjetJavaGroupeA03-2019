package view;

import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

public class AdminBorderPane extends BorderPane {
	
	private MenuBar menuBar;
	private Menu menuQuit;
	private Menu menuFile;
	private MenuItem menuILoad;
	private MenuItem menuISave;
	private MenuItem menuISaveAs;
	

	public AdminBorderPane() {
		setTop(getMenuBar());
		
		
	}

	public MenuBar getMenuBar() {
		if(menuBar==null) {
			menuBar= new MenuBar();
			menuBar.getMenus().addAll(getMenuQuit(),getMenuFile());
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

	public Menu getMenuFile() {
		if(menuFile==null) {
			menuFile = new Menu("File");
			menuFile.getItems().addAll(getMenuILoad(),getMenuISave(),getMenuISaveAs());
		}
		return menuFile;
	}

	public MenuItem getMenuILoad() {
		if(menuILoad==null) {
			menuILoad=new MenuItem("Load");
		}
		return menuILoad;
	}

	public MenuItem getMenuISave() {
		if(menuISave==null) {
			menuISave= new MenuItem("Save");
		}
		return menuISave;
	}

	public MenuItem getMenuISaveAs() {
		if(menuISaveAs==null) {
			menuISaveAs= new MenuItem("Save as ...");
		}
		return menuISaveAs;
	}	
}

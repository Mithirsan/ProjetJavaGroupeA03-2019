package view;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class MenuBorderPane extends BorderPane{

	private MenuVBox menuVBox;
	private Button adminButton; 

	public MenuBorderPane() {
		setCenter(getMenuVBox());
		
		setBottom(getAdminButton());
		setAlignment(getAdminButton(),Pos.BASELINE_RIGHT);
		
	}
	public MenuVBox getMenuVBox() {
		if(menuVBox==null) {
			menuVBox = new MenuVBox();
		}
		return menuVBox;
	}
	
	public Button getAdminButton() {
		if(adminButton==null) {
			adminButton = new Button("Admin");
			
		
		}
		return adminButton;
	}
	
}

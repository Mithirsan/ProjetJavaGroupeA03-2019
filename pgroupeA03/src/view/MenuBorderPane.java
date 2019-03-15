package view;


import java.io.File;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;

public class MenuBorderPane extends BorderPane{

	private MenuVBox menuVBox;
	private Button adminButton; 

	public MenuBorderPane() {
		BackgroundSize backgroundSize = new BackgroundSize( 960, 540, true, true, true, false);
		BackgroundImage bg = new BackgroundImage(new Image(new File("ressources/pictures/Background.jpg").toURI().toString()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
		setBackground(new Background(bg));
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
			adminButton.setOnAction(e->{
				((FinalViewStackPane) getParent()).getMenuBorderPane().setVisible(false);
				((FinalViewStackPane) getParent()).getLoginAdminAnchorPane().setVisible(true);
			});
		}
		return adminButton;
	}
	
}

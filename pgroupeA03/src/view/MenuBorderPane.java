package view;

import java.io.File;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class MenuBorderPane extends BorderPane{

	private MenuVBox menuVBox;
	private Button btnAdmin; 

	public MenuBorderPane() {
		setCenter(getMenuVBox());
		
		setBottom(getBtnAdmin());
		setAlignment(getBtnAdmin(),Pos.BASELINE_RIGHT);
		
	}
	public MenuVBox getMenuVBox() {
		if(menuVBox==null) {
			menuVBox = new MenuVBox();
		}
		return menuVBox;
	}
	
	public Button getBtnAdmin() {
		if(btnAdmin==null) {
			ImageView ivAdmin = new ImageView(new Image(new File("resources/pictures/btnOption.png").toURI().toString()));
			ivAdmin.setFitHeight(25);
			ivAdmin.setFitWidth(25);
			btnAdmin = new Button("", ivAdmin);
			btnAdmin.setOnAction(e->{
				((FinalViewStackPane) getParent()).getMenuBorderPane().setVisible(false);
				((FinalViewStackPane) getParent()).getLoginAdminAnchorPane().setVisible(true);
			});
			btnAdmin.getStyleClass().add("btnAdmin");
		}
		return btnAdmin;
	}
	
}

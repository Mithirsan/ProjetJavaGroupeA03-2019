package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
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
			btnAdmin = new Button("Admin");
			btnAdmin.setOnAction(e->{
				((FinalViewStackPane) getParent()).getMenuBorderPane().setVisible(false);
				((FinalViewStackPane) getParent()).getLoginAdminAnchorPane().setVisible(true);
			});
			btnAdmin.getStyleClass().add("btnAdmin");
		}
		return btnAdmin;
	}
	
}

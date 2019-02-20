package view;


import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class MenuBorderPane extends BorderPane{
	private Label lblTitle;
	private MenuVBox menuVBox;

	public MenuBorderPane() {
		setTop(getLblTitle());
		setCenter(getMenuVBox());
		
	}
	
	
	public Label getLblTitle() {
		if(lblTitle==null) {
			lblTitle= new Label("Who want to reduce his punishment ? ");
		}
		return lblTitle;
	}

	public MenuVBox getMenuVBox() {
		if(menuVBox==null) {
			menuVBox = new MenuVBox();
		}
		return menuVBox;
	}
}

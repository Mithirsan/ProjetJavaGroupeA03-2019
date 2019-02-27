package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class MenuVBox extends VBox{
	private Button btnPlay;
	private Button btnLoad;
	private Button btnOption;
	private Button btnQuit;
	private static final double prefWidth = 150. ;
			
	
	public MenuVBox() {
		getChildren().addAll(getBtnPlay(),getBtnLoad(),getBtnOption(),getBtnQuit());
		setSpacing(10);
		setAlignment(Pos.CENTER);
	}
	
	public Button getBtnPlay() {
		if(btnPlay==null) {
			btnPlay=new Button("Play");
			btnPlay.setPrefWidth(prefWidth);
			btnPlay.setOnAction(e->{
				getParent().setVisible(false);
				((FinalViewStackPane) getParent(). getParent()).getGamePlayBorderPane().setVisible(true);
			});
		}
		return btnPlay;
	}
	public void setBtnPlay(Button btnPlay) {
		this.btnPlay = btnPlay;
	}
	public Button getBtnLoad() {
		if(btnLoad==null) {
			btnLoad=new Button("Load");
			btnLoad.setPrefWidth(prefWidth);
		}
		return btnLoad;
	}
	public void setBtnLoad(Button btnLoad) {
		this.btnLoad = btnLoad;
	}
	public Button getBtnOption() {
		if(btnOption==null) {
			btnOption= new Button("Option");
			btnOption.setPrefWidth(prefWidth);
		}
		return btnOption;
	}
	public void setBtnOption(Button btnOption) {
		this.btnOption = btnOption;
	}
	public Button getBtnQuit() {
		if(btnQuit==null) {
			btnQuit= new Button("Quit");
			btnQuit.setPrefWidth(prefWidth);
			btnQuit.setOnAction(e->{
				System.exit(0);
			});
		}
		return btnQuit;
	}
	public void setBtnQuit(Button btnQuit) {
		this.btnQuit = btnQuit;
	}
	
}

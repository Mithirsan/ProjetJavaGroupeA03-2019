package view;

import javafx.scene.control.Button;

public class MenuVBox {
	private Button btnPlay;
	private Button btnLoad;
	private Button btnOption;
	private Button btnQuit;
	
	public Button getBtnPlay() {
		if(btnPlay==null) {
			btnPlay=new Button("Play");
		}
		return btnPlay;
	}
	public void setBtnPlay(Button btnPlay) {
		this.btnPlay = btnPlay;
	}
	public Button getBtnLoad() {
		if(btnLoad==null) {
			btnLoad=new Button("Load");
		}
		return btnLoad;
	}
	public void setBtnLoad(Button btnLoad) {
		this.btnLoad = btnLoad;
	}
	public Button getBtnOption() {
		return btnOption;
	}
	public void setBtnOption(Button btnOption) {
		this.btnOption = btnOption;
	}
	public Button getBtnQuit() {
		return btnQuit;
	}
	public void setBtnQuit(Button btnQuit) {
		this.btnQuit = btnQuit;
	}
	
	
	
	

}

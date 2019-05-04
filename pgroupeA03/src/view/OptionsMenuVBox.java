package view;

import java.io.IOException;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import model.Stats;

public class OptionsMenuVBox extends VBox {
	private Button btnPresenter;
	private Button btnStats;
	private Button btnOrator;
	private Button btnVolumeManagement;
	private Button btnDisplayManagement;
	private Button btnQuit;
			
	public OptionsMenuVBox() {
		getChildren().addAll(getBtnPresenter(),getBtnStats(),getBtnVolumeManagement(),getBtnDisplayManagement(),getBtnQuit());
		setSpacing(10);
		setAlignment(Pos.CENTER);
	}
	
	public Button getBtnPresenter() {
		if(btnPresenter==null) {
			btnPresenter=new Button("Presenter");
			btnPresenter.getStyleClass().add("mainMenuBtn");
			btnPresenter.setOnAction(e->{
				getParent().setVisible(false);
				((FinalViewStackPane) getParent(). getParent()).getPresenterBorderPane().setVisible(true);
			});
		}
		return btnPresenter;
	}
	
	public Button getBtnStats() {
		if(btnStats==null) {
			btnStats=new Button("Statistics");
			btnStats.getStyleClass().add("mainMenuBtn");
			btnStats.setOnAction(e->{
				try {
					Stats stats = new Stats().downloadData();
					((FinalViewStackPane) getParent(). getParent()).getStatsBroderPane().setPartyPlayed(stats.getPartyPlayed());
					((FinalViewStackPane) getParent(). getParent()).getStatsBroderPane().setPartyWin(stats.getPartyWin());
					((FinalViewStackPane) getParent(). getParent()).getStatsBroderPane().setTotalDays(stats.getTotalDays());
					((FinalViewStackPane) getParent(). getParent()).getStatsBroderPane().setTimePlayed(stats.getTimePlayed());
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				getParent().setVisible(false);
				((FinalViewStackPane) getParent(). getParent()).getStatsBroderPane().setVisible(true);
			});
		}
		return btnStats;
	}

	
	public Button getBtnVolumeManagement() {
		if(btnVolumeManagement==null) {
			btnVolumeManagement=new Button("Volume Management");
			btnVolumeManagement.getStyleClass().add("mainMenuBtn");
			
		}
		return btnVolumeManagement;
	}

	public Button getBtnDisplayManagement() {
		if(btnDisplayManagement==null) {
			btnDisplayManagement= new Button("Display Management");
			btnDisplayManagement.getStyleClass().add("mainMenuBtn");
			
		}
		return btnDisplayManagement;
	}
	
	public Button getBtnOrateur() {
		if(btnOrator==null) {
			btnOrator= new Button("Orator");
			btnOrator.getStyleClass().add("mainMenuBtn");
			btnOrator.setOnAction(e->{
			
			});
		}
		return btnOrator;
	}
	public Button getBtnQuit() {
		if(btnQuit==null) {
			btnQuit= new Button("Quit");
			btnQuit.getStyleClass().add("mainMenuBtn");
			btnQuit.setOnAction(e->{
				((FinalViewStackPane) getParent() .getParent()).getOptionsMenuBorderPane().setVisible(false);
				((FinalViewStackPane) getParent() .getParent()).getMenuBorderPane().getMenuVBox().setVisible(true);
			
			});
		}
		return btnQuit;
	}	

}

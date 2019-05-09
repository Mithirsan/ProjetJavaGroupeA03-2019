package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class StatisticBorderPane extends BorderPane {
	
	private Label lblGamePlayed;
	private Label lblNbGamePlayed;
	private Label lblGameWin;
	private Label lblNbGameWin;
	private Label lblDays;
	private Label lblNbDays;
	private Label lblTimePlayed;
	private Label lblNbTimePlayed;
	private Button btnRetrun;

	private int partyPlayed =0;
	private int partyWin =0;
	private int totalDays =0;
	private int timePlayed =0;
	
	public StatisticBorderPane() {
		
		VBox vbLabels = new VBox(getLblGamePlayed(), getLblGameWin(), getLblDays(), getLblTimePlayed());
		VBox vbStats = new VBox(getLblNbGamePlayed(), getLblNbGameWin(), getLblNbDays(), getLblNbTimePlayed());
		HBox hbResult = new HBox(vbLabels, vbStats);
		hbResult.setSpacing(10.);
		hbResult.setPadding(new Insets(5.));
		
		VBox vbResult = new VBox(hbResult,getBtnRetrun());
		vbResult.setSpacing(10.);
		vbResult.setPadding(new Insets(380.));
		vbResult.setAlignment(Pos.CENTER);
		setCenter(vbResult);
	}
	
	public Button getBtnRetrun() {
		if(btnRetrun==null) {
			btnRetrun = new Button("Return to menu");
			btnRetrun.setOnAction(e->{
				((FinalViewStackPane) getParent()).getOptionsMenuBorderPane().setVisible(true);
				((FinalViewStackPane) getParent()).getStatsBroderPane().setVisible(false);	
			});
		}
		return btnRetrun;
	}

	public Label getLblGamePlayed() {
		if(lblGamePlayed==null) {
			lblGamePlayed =new Label("Total of games played:");
		}
		return lblGamePlayed;
	}
	
	public Label getLblNbGamePlayed() {
		if(lblNbGamePlayed==null) {
			lblNbGamePlayed = new Label();
		}
		return lblNbGamePlayed;
	}
	
	public Label getLblGameWin() {
		if(lblGameWin==null) {
			lblGameWin =new Label("Total of games win:");
		}
		return lblGameWin;
	}
	
	public Label getLblNbGameWin() {
		if( lblNbGameWin==null) {
			 lblNbGameWin = new Label();
		}
		return lblNbGameWin;
	}
	
	public Label getLblDays() {
		if(lblDays==null) {
			lblDays =new Label("Total of days win:");
		}
		return lblDays;
	}
	
	public Label getLblNbDays() {
		if(lblNbDays==null) {
			lblNbDays = new Label();
		}
		return lblNbDays;
	}
	
	public Label getLblTimePlayed() {
		if(lblTimePlayed==null) {
			lblTimePlayed =new Label("Total of time play:");
		}
		return lblTimePlayed;
	}
	
	public Label getLblNbTimePlayed() {
		if(lblNbTimePlayed==null) {
			lblNbTimePlayed= new Label(timePlayed + " seconds");
		}	
		return lblNbTimePlayed;
	}
	
	public void setPartyPlayed(int partyPlayed) {
		this.partyPlayed = partyPlayed;
		getLblNbGamePlayed().setText(partyPlayed+" played");
		
	}
	
	public void setPartyWin(int partyWin) {
		this.partyWin = partyWin;
		getLblNbGameWin().setText(partyWin+" win");
		
	}
	
	public void setTotalDays(int totalDays) {
		this.totalDays = totalDays;
		getLblNbDays().setText(totalDays+ " days");
	}
	
	public void setTimePlayed(int timePlayed) {
		this.timePlayed = timePlayed;
		getLblNbTimePlayed().setText(timePlayed + " seconds");
	}
}

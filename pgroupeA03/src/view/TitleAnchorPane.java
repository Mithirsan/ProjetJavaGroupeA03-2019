package view;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import model.Round;

public class TitleAnchorPane extends AnchorPane  {
	
	private TextField txtAuthor;
	private TextField txtStatement;
	private ComboBox<Round> cbRound;
	
	public TitleAnchorPane() {
		setPadding(new Insets(10));
		getCbRound().getSelectionModel().selectFirst();
		HBox hbox = new HBox();
		hbox.getChildren().addAll(getTxtAuthor(),getCbRound());
		hbox.setSpacing(10.);
		hbox.setPadding(new Insets(0,0,10,0));
		VBox vbox = new VBox();
		vbox.getChildren().addAll(hbox,getTxtStatement());
		this.getChildren().add(vbox);
		setLeftAnchor(vbox, 10.);
		setRightAnchor(vbox, 10.);
	}
	
	public TextField getTxtStatement() {
		if(txtStatement==null) {
			txtStatement = new TextField();
			txtStatement.setPromptText("Enter the statement");
		}
		return txtStatement;
	}

	public void setTxtStatement(TextField txtStatement) {
		this.txtStatement = txtStatement;
	}

	public TextField getTxtAuthor() {
		if(txtAuthor==null) {
			txtAuthor= new TextField();
			txtAuthor.setPromptText("Author");	
		}
		return txtAuthor;
	}

	public void setTxtAuthor(TextField txtAuthor) {
		this.txtAuthor = txtAuthor;
	}

	public ComboBox<Round> getCbRound() {
		if(cbRound==null) {
			cbRound = new ComboBox<>();
			ObservableList<Round> round = FXCollections.observableArrayList(Round.values());
			cbRound = new ComboBox<>(round);
		
		}
		return cbRound;
	}
	
	

}

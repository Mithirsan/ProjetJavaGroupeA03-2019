package view;

import java.util.List;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import model.Deck;
import model.Question;
import model.Round;


public class TableQuestionBorderPane extends BorderPane {
	
	private TableView<Question> tableQuestion;
	private ObservableList<Question> listQuestion;
	private TableColumn<Question, String> colAuthor, colStatement;
	private TableColumn<Question, Round> colRound ;
	private TableColumn<Question, Map<String, Boolean>> colChoices;
	private HBox hboxButton;
	private Button btnDel,btnAdd;
	
	public TableQuestionBorderPane() {
		setCenter(getTableQuestion());
		getTableQuestion().getColumns().add(getColAuthor());
		getTableQuestion().getColumns().add(getColRound());
		getTableQuestion().getColumns().add(getColStatement());
		getTableQuestion().getColumns().add(getColChoices());
		setBottom(getHboxButton());
		
	}
	
	public HBox getHboxButton() {
		if(hboxButton==null) {
			hboxButton= new HBox();
			hboxButton.getChildren().addAll(getBtnAdd(),getBtnDel());
		}
		return hboxButton;
	}
	
	public TableView<Question> getTableQuestion() {
		if(tableQuestion == null) {
			tableQuestion = new TableView<>();
			tableQuestion.setItems(getListQuestion());
			tableQuestion.setEditable(true);
			tableQuestion.setPrefHeight(620.);
			tableQuestion.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		}
		return tableQuestion;
	}
	public ObservableList<Question> getListQuestion() {
		if(listQuestion== null) {
			listQuestion = FXCollections.observableArrayList(Deck.getInstance().getQuestions());
		}
		return listQuestion;
	}
	public TableColumn<Question, String> getColAuthor() {
		if (colAuthor == null) {
			colAuthor = new TableColumn<>("author");
			colAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
			colAuthor.setCellFactory(TextFieldTableCell.<Question>forTableColumn());
			colAuthor.setOnEditCommit((CellEditEvent<Question, String> e) -> {
				e.getRowValue().setAuthor(e.getNewValue());
				Deck.getInstance().update(e.getRowValue());
				
			});
		}
		return colAuthor;
	}
	public TableColumn<Question, String> getColStatement() {
		if (colStatement == null) {
			colStatement = new TableColumn<>("statement");
			colStatement.setCellValueFactory(new PropertyValueFactory<>("statement"));
			colStatement.setCellFactory(TextFieldTableCell.<Question>forTableColumn());
			colStatement.setOnEditCommit((CellEditEvent<Question, String> e) -> {
				e.getRowValue().setStatement(e.getNewValue());
				Deck.getInstance().update(e.getRowValue());
				
			});
		}
		return colStatement;
	}
	
	public TableColumn<Question, Round> getColRound() {
		if (colRound == null) {
			colRound = new TableColumn<>("round");
			colRound.setCellValueFactory(new PropertyValueFactory<>("round"));
			ObservableList<Round> roundV = FXCollections.observableArrayList(Round.values());
			colRound.setCellFactory(ComboBoxTableCell.forTableColumn(roundV));
			colRound.setOnEditCommit((CellEditEvent<Question,Round> e) -> {
				e.getRowValue().setRound(e.getNewValue());
				Deck.getInstance().update(e.getRowValue());
			});
		}
		return colRound;
	}
	
	public TableColumn<Question, Map<String, Boolean>> getColChoices() {
		if (colChoices == null) {
			colChoices = new TableColumn<>("choices");
			TableColumn<Question,List<String> >colAnswer = new TableColumn<>("Answer"); 
			TableColumn<Question,List<Boolean> >colValue = new TableColumn<>("Value"); 
			colChoices.getColumns().addAll(colAnswer,colValue);
		}
		return colChoices;
	}
	
	public Button getBtnDel() {
		if(btnDel==null) {
			btnDel = new Button("Delete");
		}
		return btnDel;
	}
	
	public Button getBtnAdd() {
		if(btnAdd==null) {
			btnAdd=new Button("Add");
			btnAdd.setOnAction(e->{
				((FinalViewStackPane)getParent().getParent()).getAddQuestionBorderPane().setVisible(true);
				((FinalViewStackPane)getParent().getParent()).getAdminBorderPane().setVisible(false);
			});
		}
		return btnAdd;
	}
	

}

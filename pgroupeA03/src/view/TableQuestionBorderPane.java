package view;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
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
	private HBox hboxButton;
	private Button btnDel,btnAdd;
	
	public TableQuestionBorderPane() {
		setCenter(getTableQuestion());
		getTableQuestion().getColumns().add(getColAuthor());
		getTableQuestion().getColumns().add(getColRound());
		getTableQuestion().getColumns().add(getColStatement());
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
			tableQuestion.setPrefHeight(620.);
			tableQuestion.setEditable(true);
			tableQuestion.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
			tableQuestion.setColumnResizePolicy(tableQuestion.CONSTRAINED_RESIZE_POLICY);
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
			colAuthor.setOnEditStart(e->{
				autocomplet(e);
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
			colStatement.setOnEditStart(e->{
				autocomplet(e);
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
			colRound.setOnEditStart(e->{
				autocomplet(e);
			});
		}
		return colRound;
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
	
	public void autocomplet (Event e) {
		((FinalViewStackPane) getParent().getParent()).getUpdateQuestionBorderPane().setVisible(true);
		((FinalViewStackPane) getParent().getParent()).getAdminBorderPane().setVisible(false);
		((FinalViewStackPane) getParent().getParent()).getUpdateQuestionBorderPane().getTitleAnchorPane().getTxtAuthor().setText(((CellEditEvent<Question, String>) e).getRowValue().getAuthor());	
		((FinalViewStackPane) getParent().getParent()).getUpdateQuestionBorderPane().getTitleAnchorPane().getTxtStatement().setText(((CellEditEvent<Question, String>) e).getRowValue().getStatement());
		((FinalViewStackPane) getParent().getParent()).getUpdateQuestionBorderPane().getTitleAnchorPane().getCbRound().setValue(((CellEditEvent<Question,Round>) e).getRowValue().getRound());
		((FinalViewStackPane) getParent().getParent()).getUpdateQuestionBorderPane().getChoicesVBox().getTxtChoices1().setText(((CellEditEvent<Question, String>) e).getRowValue().getChoice(0));
		((FinalViewStackPane) getParent().getParent()).getUpdateQuestionBorderPane().getChoicesVBox().getTxtChoices2().setText(((CellEditEvent<Question,String>) e).getRowValue().getChoice(1));
		((FinalViewStackPane) getParent().getParent()).getUpdateQuestionBorderPane().getChoicesVBox().getTxtChoices3().setText(((CellEditEvent<Question, String>) e).getRowValue().getChoice(2));
		((FinalViewStackPane) getParent().getParent()).getUpdateQuestionBorderPane().getChoicesVBox().getTxtChoices4().setText(((CellEditEvent<Question,String>) e).getRowValue().getChoice(3));
		((FinalViewStackPane) getParent().getParent()).getUpdateQuestionBorderPane().getTrueVBox().setRdbTrue(((CellEditEvent<Question,String>) e).getRowValue().getChoiceTrue());	
	}
}

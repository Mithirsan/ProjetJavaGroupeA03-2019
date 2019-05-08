package view;


import java.util.ArrayList;
import java.util.List;

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
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import model.CareTMemento;
import model.Deck;
import model.OriginMemento;
import model.Question;
import model.Round;


public class TableQuestionBorderPane extends BorderPane {
	
	private TableView<Question> tableQuestion;
	private ObservableList<Question> listQuestion;
	private TableColumn<Question, String> colAuthor, colStatement;
	private TableColumn<Question, Round> colRound ;
	private HBox hboxButton;
	private Button btnDel,btnAdd;
	
	private Integer nbManip = 0;
	private Integer totalManip = 0;
	private CareTMemento cTakerMemento;
	private OriginMemento originMemento;
	
	
	public TableQuestionBorderPane() {
		originMemento = new OriginMemento();
		originMemento.setState(Deck.getInstance().getQuestions());
		getcTakerMemento().add(originMemento.saveToMemento());
		setCenter(getTableQuestion());
		getTableQuestion().getColumns().add(getColAuthor());
		getTableQuestion().getColumns().add(getColRound());
		getTableQuestion().getColumns().add(getColStatement());
		setBottom(getHboxButton());
		
		setOnKeyPressed(event -> {
			if(event.getCode() == KeyCode.Z && event.isControlDown()) {
				if(totalManip > 0) {
					totalManip--;
					originMemento.getFromMemento(getcTakerMemento().get(totalManip));
					Deck.getInstance().loadState(originMemento.getState());
					updateObservableList();
				}
			}
			if(event.getCode() == KeyCode.Y && event.isControlDown()) {
				if(totalManip < nbManip) {
					totalManip++;
					originMemento.getFromMemento(getcTakerMemento().get(totalManip));
					Deck.getInstance().loadState(originMemento.getState());
					updateObservableList();
				}
			}
		});	
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
		
			listQuestion = FXCollections.observableArrayList(Deck.getAllQuestion());
		}
		return listQuestion;
	}
	public TableColumn<Question, String> getColAuthor() {
		if (colAuthor == null) {
			colAuthor = new TableColumn<>("author");
			colAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
			colAuthor.setCellFactory(TextFieldTableCell.<Question>forTableColumn());
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
			colRound.setOnEditStart(e->{
				autocomplet(e);
			});
		}
		return colRound;
	}	
	public Button getBtnDel() {
		if(btnDel==null) {
			btnDel = new Button("Delete");
			btnDel.setOnAction(e->{
				ObservableList<Question> tmpList = getTableQuestion().getSelectionModel().getSelectedItems();
				if(Deck.getInstance().deleteAllDeck(tmpList)) {
					getListQuestion().removeAll(tmpList);
					nbManip++;
					totalManip= nbManip;
					originMemento.setState(Deck.getInstance().getQuestions());
					getcTakerMemento().add(originMemento.saveToMemento());
				}
			});
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
	public void updateObservableList() {
		getListQuestion().clear();
        getListQuestion().addAll(Deck.getInstance().getQuestions());
	}

	public CareTMemento getcTakerMemento() {
		if(cTakerMemento==null) {
			cTakerMemento = new CareTMemento();
		}
		return cTakerMemento;
	}

	public Integer getNbManip() {
		return nbManip;
	}
	
	
	public void setNbManip(Integer nbManip) {
		this.nbManip = nbManip;
	}

	public Integer getTotalManip() {
		return totalManip;
	}
	
	public void setTotalManip(Integer totalManip) {
		this.totalManip = totalManip;
	}

	public OriginMemento getOriginMemento() {
		return originMemento;
	}
	
	public void emptyCareTaker() {
		cTakerMemento = new CareTMemento();
		OriginMemento origiMemento = new OriginMemento();
		origiMemento.setState(Deck.getInstance().getQuestions());
		cTakerMemento.add(origiMemento.saveToMemento());
		nbManip = 0;
		totalManip = 0;
	}
	
	
	
}

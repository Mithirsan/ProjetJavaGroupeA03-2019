package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Popup;
import model.Deck;
import model.Question;
import model.Round;

public class UpdateQuestionBorderPane extends BorderPane {
	private TitleAnchorPane titleAnchorPane;
	private ChoicesVBox choicesVBox;
	private TrueVBox trueVBox;
	private Button btnUpdate;
	private Button btnCancel;
	
	public UpdateQuestionBorderPane() {
		this.setPadding(new Insets(10));
		setTop(getTitleAnchorPane());
		HBox hbox = new HBox(getChoicesVBox(),getTrueVBox());
		hbox.setSpacing(10.);
		hbox.setAlignment(Pos.CENTER);
		setCenter(hbox);
		HBox hboxbtn = new HBox(getBtnCancel(),getBtnUpdate());
		hboxbtn.setAlignment(Pos.BASELINE_RIGHT);
		setBottom(hboxbtn);
		BorderPane.setAlignment(getBtnUpdate(),Pos.BASELINE_RIGHT);
	}
	
	public TitleAnchorPane getTitleAnchorPane() {
		if(titleAnchorPane==null) {
			 titleAnchorPane = new TitleAnchorPane();
			 titleAnchorPane.getTxtStatement().setEditable(false);
		}
		return titleAnchorPane;
	}
	
	public ChoicesVBox getChoicesVBox() {
		if(choicesVBox==null) {
			choicesVBox=new ChoicesVBox();
		}
		return choicesVBox;
	}
	
	public TrueVBox getTrueVBox() {
		if(trueVBox==null) {
			trueVBox = new TrueVBox();
		}
		return trueVBox;
	}

	public Button getBtnUpdate() {
		if(btnUpdate==null) {
			btnUpdate= new Button("Update");
			btnUpdate.setOnAction(e->{
				this.setVisible(false);
				((FinalViewStackPane) getParent()).getAdminBorderPane().setVisible(true);	
				String tmpAuthor = getTitleAnchorPane().getTxtAuthor().getText();
				Round tmpRound = getTitleAnchorPane().getCbRound().getValue();
				String tmpStatement = getTitleAnchorPane() .getTxtStatement().getText();
				Map <String,Boolean> tmpChoices =new HashMap<String, Boolean>() ;
				RadioButton[] tmpRadio =getTrueVBox().getRdbTrue().clone();
				List<String>choices = new ArrayList<>();
				choices.add(getChoicesVBox().getTxtChoices1().getText());
				choices.add(getChoicesVBox().getTxtChoices2().getText());
				choices.add(getChoicesVBox().getTxtChoices3().getText());
				choices.add(getChoicesVBox().getTxtChoices4().getText());
				
				boolean allFieldComplete = false;
				int wrongField = 0;
				Popup errorFieldPopup = new Popup();
				Label lblError = new Label();		
				if(tmpStatement.equals("")){
					lblError.setText("Need a statement");
					wrongField++;
				}
				if(tmpAuthor.equals("")){
					lblError.setText("Need an Author");
					wrongField++;
				}
				for (String tmp : choices) {
					if(tmp.equals("")){
						lblError.setText("A field is not complete");
						wrongField++;
					}
				}
				if(wrongField==0) {
					allFieldComplete = true ;
					for (int i=0 ; i <=3;i++) {
						if (tmpRadio[i].isSelected()) {
							tmpChoices.put(choices.get(i), true);
						}
						else {
							tmpChoices.put(choices.get(i), false);
						}
					}
				}
				System.out.println("Avant update :"+Deck.getInstance().getQuestions());
				Question q= new Question (tmpAuthor,tmpRound,tmpStatement,tmpChoices);
				System.out.println(Deck.getInstance().update(q));	
				System.out.println("Apres update :"+Deck.getInstance().getQuestions());
				((FinalViewStackPane) getParent()).getAdminBorderPane().getTableQuestion().updateObservableList();
			});
		}
		return btnUpdate;
	}
	
	public Button getBtnCancel() {
		if(btnCancel == null) {
			btnCancel = new Button("Cancel");
			btnCancel.setOnAction(e->{
				this.setVisible(false);
				((FinalViewStackPane) getParent()).getAdminBorderPane().setVisible(true);
			});
		}
		return btnCancel;
	}	
}

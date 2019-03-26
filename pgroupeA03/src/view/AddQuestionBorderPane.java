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

public class AddQuestionBorderPane extends BorderPane{
	private TitleAnchorPane titleAnchoPane;
	private ChoicesVBox choicesVBox;
	private TrueVBox trueVBox;
	private Button btnOK;
	private Button btnCancel;



	public AddQuestionBorderPane() {
		this.setPadding(new Insets(10));
		setTop(getTitleAnchorPane());
		HBox hbox = new HBox(getChoicesVBox(),getTrueVBox());
		hbox.setSpacing(10.);
		hbox.setAlignment(Pos.CENTER);
		setCenter(hbox);
		HBox hboxbtn = new HBox(getBtnCancel(),getBtnOk());
		hboxbtn.setAlignment(Pos.BASELINE_RIGHT);
		setBottom(hboxbtn);
	}

	
	public TitleAnchorPane getTitleAnchorPane() {
		if(titleAnchoPane==null) {
			 titleAnchoPane = new TitleAnchorPane();
		}
		return titleAnchoPane;
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

	public Button getBtnOk() {
		if(btnOK==null) {
			btnOK= new Button("OK");
			btnOK.setOnAction(e->{
				
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
				if (allFieldComplete) {
					Question tmpQuestion = new Question(tmpAuthor, tmpRound, tmpStatement,tmpChoices);
					Deck.getInstance().addQuestion(tmpQuestion);
					this.setVisible(false);
					((FinalViewStackPane) getParent()).getAdminBorderPane().setVisible(true);
					
					
				}
				else {
				
					errorFieldPopup.getContent().add(lblError);
					errorFieldPopup.show(getScene().getWindow()); 
				}
			});
			
		}
		return btnOK;
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

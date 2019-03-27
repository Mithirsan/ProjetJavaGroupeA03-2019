package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import model.Question;

public class UpdateQuestionBorderPane extends BorderPane {
	private TitleAnchorPane titleAnchorPane;
	private ChoicesVBox choicesVBox;
	private TrueVBox trueVBox;
	private Button btnUpdate;
	private Button btnCancel;
	private	int indexQuestion;
	
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
			/*	this.setVisible(false);
				((FinalViewStackPane) getParent()).getAdminBorderPane().setVisible(true);
			*/
				System.out.println(getIndexQuestion());
				
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

	public int getIndexQuestion() {
		return indexQuestion;
	}

	public void setIndexQuestion(int indexQuestion) {
		this.indexQuestion = indexQuestion;
	}	
	
	
}

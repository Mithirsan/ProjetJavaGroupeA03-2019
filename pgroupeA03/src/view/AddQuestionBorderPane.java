package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class AddQuestionBorderPane extends BorderPane{
	private TitleAnchorPane titleAnchoPane;
	private ChoicesVBox choicesVBox;
	private TrueVBox trueVBox;
	private Button btnOK;
	



	public AddQuestionBorderPane() {
		this.setPadding(new Insets(10));
		setTop(getTitleAcnhorPane());
		HBox hbox = new HBox(getChoicesVBox(),getTrueVBox());
		hbox.setSpacing(10.);
		hbox.setAlignment(Pos.CENTER);
		setCenter(hbox);
		setBottom(getBtnOk());
		BorderPane.setAlignment(getBtnOk(),Pos.BASELINE_RIGHT);
	}

	
	public TitleAnchorPane getTitleAcnhorPane() {
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


	public void setVbt(TrueVBox vbt) {
		this.trueVBox = vbt;
	}

	public Button getBtnOk() {
		if(btnOK==null) {
			btnOK= new Button("OK");
			
		}
		return btnOK;
	}


	public void setBtnOk(Button btnOk) {
		this.btnOK = btnOk;
	}

}

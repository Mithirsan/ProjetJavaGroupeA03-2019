package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class UpdateQuestionBorderPane extends BorderPane {
	private TitleAnchorPane titleAnchorPane;
	private ChoicesVBox choicesVBox;
	private TrueVBox trueVBox;
	private Button btnOK;
	private Button btnCancel;
	



	public UpdateQuestionBorderPane() {
		this.setPadding(new Insets(10));
		setTop(getTitleAnchorPane());
		HBox hbox = new HBox(getChoicesVBox(),getTrueVBox());
		hbox.setSpacing(10.);
		hbox.setAlignment(Pos.CENTER);
		setCenter(hbox);
		HBox hboxbtn = new HBox(getBtnCancel(),getBtnOk());
		hboxbtn.setAlignment(Pos.BASELINE_RIGHT);
		setBottom(hboxbtn);
		BorderPane.setAlignment(getBtnOk(),Pos.BASELINE_RIGHT);
	}

	
	public TitleAnchorPane getTitleAnchorPane() {
		if(titleAnchorPane==null) {
			 titleAnchorPane = new TitleAnchorPane();
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

	public Button getBtnOk() {
		if(btnOK==null) {
			btnOK= new Button("Update");
			
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

package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class ChoicesVBox extends VBox{
	private TextField txtChoices1;
	private TextField txtChoices2;
	private TextField txtChoices3;
	private TextField txtChoices4;
	
	public ChoicesVBox() {

		this.getChildren().addAll(getTxtChoices1(),getTxtChoices2(),getTxtChoices3(),getTxtChoices4());	
		
			
			
	}
	

	public TextField getTxtChoices1() {
		if(txtChoices1==null) {
			txtChoices1 = new TextField();
			txtChoices1.setPromptText("Enter choices 1");
		}
		return txtChoices1 ;
		
	}
	

	public TextField getTxtChoices2() {
		if(txtChoices2==null) {
			txtChoices2 = new TextField();
			txtChoices2.setPromptText("Enter choices 2");
		}
		return txtChoices2 ;
		
	}
	
	
	public TextField getTxtChoices3() {
		if(txtChoices3==null) {
			txtChoices3 = new TextField();
			txtChoices3.setPromptText("Enter choices 3");
		}
		return txtChoices3 ;
		
	}
	
	
	public TextField getTxtChoices4() {
		if(txtChoices4==null) {
			txtChoices4 = new TextField();
			txtChoices4.setPromptText("Enter choices 4");
		}
		return txtChoices4 ;
		
	}

	
}

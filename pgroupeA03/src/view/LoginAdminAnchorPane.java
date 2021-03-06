package view;


import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Popup;

public class LoginAdminAnchorPane extends AnchorPane {
	private String login = "admin", password = "helha";
	
	private Label lblLogin;
	private Label lblPassword;
	
	private TextField txtLogin;
	private Button btnValider;
	private Button btnRetour;
	private PasswordField pwdPassword;
	
	public LoginAdminAnchorPane () {
		this.setPadding(new Insets(5));
		this.getChildren().addAll(getLblLogin(),
								getTxtLogin(),
								getLblPassword(),
								getTxtPassword(),
								getBtnValider(),
								getBtnRetour());
	
	setLeftAnchor(getLblLogin(),10.);
	setTopAnchor(getLblLogin(),10.);
	
	setLeftAnchor(getTxtLogin(),80.);
	setTopAnchor(getTxtLogin(),10.);
	setRightAnchor(getTxtLogin(),10.);
	
	setLeftAnchor(getLblPassword(),10.);
	setTopAnchor(getLblPassword(),45.);
	
	setLeftAnchor(getTxtPassword(),80.);
	setTopAnchor(getTxtPassword(),45.);
	setRightAnchor(getTxtPassword(),10.);
	
	setTopAnchor(getBtnValider(),100.);
	setRightAnchor(getBtnValider(),10.);
	
	setTopAnchor(getBtnRetour(),100.);
	setRightAnchor(getBtnRetour(),150.);
	}

	public Button getBtnValider() {
		if(btnValider==null) {
			btnValider=new Button("Valider");
			Popup errorPopup = new Popup();
			btnValider.setOnAction(e->{
				errorPopup.hide();
				final Label lblError = new Label("Error to proceed please check your password or login");
				if((getTxtLogin().getText().equals(login))&&(getTxtPassword().getText().equals(password))) {
					((FinalViewStackPane) getParent()).getAdminBorderPane().setVisible(true);
					((FinalViewStackPane) getParent()).getLoginAdminAnchorPane().setVisible(false);
				}	
				else {	
					errorPopup.getContent().add(lblError);
					errorPopup.show(getScene().getWindow()); 		
				}
			});
		}
		return btnValider;
	}
	
	public Label getLblLogin() {
		if(lblLogin==null) {
			lblLogin=new Label("Login");
		}
		return lblLogin;
	}

	public Label getLblPassword() {
		if(lblPassword==null) {
			lblPassword=new Label("Password");
		}
		return lblPassword;
	}

	public TextField getTxtLogin() {
		if(txtLogin==null) {
			txtLogin=new TextField();
		}
		return txtLogin;
	}

	public PasswordField getTxtPassword() {
		if(pwdPassword==null) {
			pwdPassword=new PasswordField();
		}
		return pwdPassword;
	}
	
	public Button getBtnRetour() {
		if(btnRetour==null) {
			btnRetour=new Button("Retour");
			btnRetour.setOnAction(e->{
				((FinalViewStackPane) getParent()).getLoginAdminAnchorPane().setVisible(false);
				((FinalViewStackPane) getParent()).getMenuBorderPane().setVisible(true);
			});;
		}
		return btnRetour;
	}
}
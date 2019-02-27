package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class LoginAdminAnchorPane extends AnchorPane {
	
		
		private Label lblLogin;
		private Label lblPassword;
		
		private TextField txtLogin;
		private TextField txtPassword;
		
		private Button btnValider;
		private Button btnRetour;
		private PasswordField pwdPassword;
		
		public LoginAdminAnchorPane () {
			this.setPadding(new Insets(10));
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
				return btnValider;
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
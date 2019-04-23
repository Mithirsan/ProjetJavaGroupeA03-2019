package view;

import javafx.scene.Node;
import javafx.scene.layout.StackPane;

public class FinalViewStackPane extends StackPane{
	private MenuBorderPane menuBorderPane;
	private GamePlayBorderPane gamePlayBorderPane;
	private LoginAdminAnchorPane loginAdminAnchorPane;
	private OptionsBorderPane optionBorderPane;
	private AdminBorderPane adminBorderPane;
	private AddQuestionBorderPane addQuestionBorderPane;
	private UpdateQuestionBorderPane updateQuestionBorderPane;
	private WinScreenBorderPane WinScreen;
	private LooseScreenBorderPane looseScreenBorderPane;
	private LeavingHBox leavingHBox ;
	private PresenterChoicesBorderPane presenterBorderPane;
	


	public FinalViewStackPane() {
		getChildren().addAll(getMenuBorderPane(),getGamePlayBorderPane(),getLoginAdminAnchorPane()
				,getOptionBorderPane(),getAdminBorderPane(),getAddQuestionBorderPane(),getWinScreen(),getLooseScreenBorderPane(),getUpdateQuestionBorderPane(),getLeavingHBox(),getPresenterBorderPane());
		
	}

	
	public MenuBorderPane getMenuBorderPane() {
		if(menuBorderPane==null) {
			menuBorderPane= new MenuBorderPane();
		}
		return menuBorderPane;
	}
	
	public GamePlayBorderPane getGamePlayBorderPane() {
		if(gamePlayBorderPane==null) {
			gamePlayBorderPane = new GamePlayBorderPane();
			gamePlayBorderPane.setVisible(false);	
		}
		return gamePlayBorderPane;
	}

	public LoginAdminAnchorPane getLoginAdminAnchorPane() {
		if(loginAdminAnchorPane==null) {
			loginAdminAnchorPane= new LoginAdminAnchorPane();
			loginAdminAnchorPane.setVisible(false);
		}
		return loginAdminAnchorPane;
	}

	public OptionsBorderPane getOptionBorderPane() {
		if(optionBorderPane==null) {
			optionBorderPane = new OptionsBorderPane();
			optionBorderPane.setVisible(false);
		}
		return optionBorderPane;
	}
	
	public AdminBorderPane getAdminBorderPane() {
		if(adminBorderPane==null) {
			adminBorderPane = new AdminBorderPane();
			adminBorderPane.setVisible(false);
		}
		return adminBorderPane;
	}
	
public AddQuestionBorderPane getAddQuestionBorderPane() {
	if(addQuestionBorderPane==null) {
		addQuestionBorderPane = new AddQuestionBorderPane();
		addQuestionBorderPane.setVisible(false);
	}
		return addQuestionBorderPane;
	}
public WinScreenBorderPane getWinScreen() {
	if (WinScreen==null) {
		WinScreen = new WinScreenBorderPane();
		WinScreen.setVisible(false);
		WinScreen.setOnMouseClicked(e->{
			WinScreen.setVisible(false);
			getMenuBorderPane().setVisible(true);
		});
	}
	return WinScreen;
	}


public LooseScreenBorderPane getLooseScreenBorderPane() {
	if(looseScreenBorderPane==null) {
		looseScreenBorderPane = new LooseScreenBorderPane();
		looseScreenBorderPane.setVisible(false);
		looseScreenBorderPane.setOnMouseClicked(e->{
			looseScreenBorderPane.setVisible(false);
			getMenuBorderPane().setVisible(true);
		});
	}
	return looseScreenBorderPane;
}
public UpdateQuestionBorderPane getUpdateQuestionBorderPane() {
	if(updateQuestionBorderPane==null) {
		updateQuestionBorderPane = new UpdateQuestionBorderPane();
		updateQuestionBorderPane.setVisible(false);
	}
		return updateQuestionBorderPane;
	}
public LeavingHBox getLeavingHBox() {
	if(leavingHBox==null) {
		leavingHBox = new LeavingHBox();
		leavingHBox.setVisible(false);
		leavingHBox.setOnMouseClicked(e->{
			leavingHBox.setVisible(false);
			getMenuBorderPane().setVisible(true);
		});
	}
	return leavingHBox;
}


public PresenterChoicesBorderPane getPresenterBorderPane() {
	if(presenterBorderPane==null) {
		presenterBorderPane = new PresenterChoicesBorderPane();
		presenterBorderPane.setVisible(false);
	}
	return presenterBorderPane;
}


	
}

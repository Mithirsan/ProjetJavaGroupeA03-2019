package application;
	
import javafx.application.Application;
import javafx.stage.Stage;

import view.MenuBorderPane;
import view.OptionsBorderPane;

import view.GamePlayBorderPane;
import view.GamePlayLevelsVBox;
import view.GamePlayOptionAndJokersVBox;
import view.GamePlayStatementAndChoicesVBox;
import view.GamePlayTimerHBox;
import view.LoginAdminAnchor;
import view.LoginAdminGrid;
import view.FinalViewStackPane;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {

	private MenuBorderPane menuBorderPane;
	private OptionsBorderPane optionsBorderPane;
	public MenuBorderPane getMenuBorderPane() {
		if(menuBorderPane == null) {
			menuBorderPane = new MenuBorderPane();
		}
		return menuBorderPane;
	}
	private FinalViewStackPane finalViewStackPane;
	public FinalViewStackPane getFinalViewStackPane() {
		if(finalViewStackPane == null) {
			finalViewStackPane = new FinalViewStackPane();

		}
		return finalViewStackPane;
	}

	public OptionsBorderPane getOptionsBorderPane() {
		if(optionsBorderPane == null) {
			optionsBorderPane = new OptionsBorderPane();
		}
		return optionsBorderPane;
	}



	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			//LoginAdminAnchor laa= new LoginAdminAnchor();
			//Scene scene = new Scene(getMenuBorderPane(),400,400);
			//Scene scene1 = new Scene(getOptionsBorderPane(),400,400);
			//Scene scene2 = new Scene (laa,303,200);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			//primaryStage.setScene(scene);

			Scene scene = new Scene(getFinalViewStackPane() , 800, 550);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);

			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

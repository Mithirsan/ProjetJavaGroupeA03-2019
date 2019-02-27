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
import view.LoginAdminAnchorPane;
import view.FinalViewStackPane;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {

	private OptionsBorderPane optionsBorderPane;
	
	private FinalViewStackPane finalViewStackPane;
	public FinalViewStackPane getFinalViewStackPane() {
		if(finalViewStackPane == null) {
			finalViewStackPane = new FinalViewStackPane();

		}
		return finalViewStackPane;
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			LoginAdminAnchorPane laa= new LoginAdminAnchorPane();
			Scene scene = new Scene(getFinalViewStackPane(),400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);

			//Scene scene11 = new Scene(getFinalViewStackPane() , 800, 550);
			//scene11.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			//primaryStage.setScene(scene11);

			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

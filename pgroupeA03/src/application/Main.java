package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import view.GamePlayBorderPane;
import view.GamePlayLevelsVBox;
import view.GamePlayOptionAndJokersVBox;
import view.GamePlayStatementAndChoicesVBox;
import view.GamePlayTimerHBox;
import view.FinalViewStackPane;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	private FinalViewStackPane menuBorderPane;
	public FinalViewStackPane getMenuBorderPane() {
		if(menuBorderPane == null) {
			menuBorderPane = new FinalViewStackPane();
		}
		return menuBorderPane;
	}
	
	//private GamePlayBorderPane gameplay = new GamePlayBorderPane();
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(getMenuBorderPane(), 800, 550);
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

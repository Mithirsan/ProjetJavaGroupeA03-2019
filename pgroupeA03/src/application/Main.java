package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import view.MenuBorderPane;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	private MenuBorderPane menuBorderPane;
	public MenuBorderPane getMenuBorderPane() {
		if(menuBorderPane == null) {
			menuBorderPane = new MenuBorderPane();
		}
		return menuBorderPane;
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(getMenuBorderPane(),400,400);
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

package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import view.MenuBorderPane;
import view.OptionsBorderPane;
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
			Scene scene = new Scene(getMenuBorderPane(),400,400);
			Scene scene1 = new Scene(getOptionsBorderPane(),400,400);
			scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene1);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

package application;
	
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import model.Deck;
import view.FinalViewStackPane;
import javafx.scene.Scene;

public class Main extends Application {

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
			Scene scene = new Scene(getFinalViewStackPane(), 960, 540);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.setTitle(" Who wants to reduce his punishment ?");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		File file = new File("Test.json");
		try {
			Deck.getInstance().loadDeck(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		launch(args);
	}
}

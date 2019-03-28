package view;

import java.io.File;
import java.io.IOException;

import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import model.Deck;
import util.Serializable;

public class AdminBorderPane extends BorderPane {
	
	private MenuBar menuBar;
	private Menu menuQuit;
	private Menu menuFile;
	private MenuItem menuILoad;
	private MenuItem menuISave;
	private MenuItem menuISaveAs;
	private FileChooser fChooser = new FileChooser();
	private File file = new File("Test.json") ;
	
	private TableQuestionBorderPane tableQuestion;
	

	public AdminBorderPane() {
		
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("JSON files (*.json)", "*.json");
		fChooser.getExtensionFilters().add(extFilter);
		fChooser.setInitialDirectory(
	         new File(System.getProperty("user.dir"))
	    );
		setTop(getMenuBar());
		setCenter(getTableQuestion());
		
		
	}

	public TableQuestionBorderPane getTableQuestion() {
		if(tableQuestion==null) {	
			tableQuestion = new TableQuestionBorderPane();
		}
		return tableQuestion;
	}

	public MenuBar getMenuBar() {
		if(menuBar==null) {
			menuBar= new MenuBar();
			menuBar.getMenus().addAll(getMenuQuit(),getMenuFile());
		}
		return menuBar;
	}

	public Menu getMenuQuit() {
		if(menuQuit==null)
		{
			Label lblQuit = new Label("Quit");
			menuQuit = new Menu("",lblQuit);
			lblQuit.setOnMouseClicked(e->{
				((FinalViewStackPane) getParent()).getLoginAdminAnchorPane().setVisible(true);
				((FinalViewStackPane) getParent()).getAdminBorderPane().setVisible(false);
				
			});
			
		}
		return menuQuit;
	}

	public Menu getMenuFile() {
		if(menuFile==null) {
			menuFile = new Menu("File");
			menuFile.getItems().addAll(getMenuILoad(),getMenuISave(),getMenuISaveAs());
		}
		return menuFile;
	}

	public MenuItem getMenuILoad() {
		if(menuILoad==null) {
			menuILoad=new MenuItem("Load");
			menuILoad.setOnAction(e->{
				File fileOpen = fChooser.showOpenDialog(getScene().getWindow());
				  if(fileOpen != null) {
		            	file = fileOpen;
						try {
							Deck.getInstance().loadDeck(file);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						getTableQuestion().updateObservableList();
		            }
			});
		}
		return menuILoad;
	}

	public MenuItem getMenuISave() {
		if(menuISave==null) {
			menuISave= new MenuItem("Save");
			menuISave.setOnAction(e->{
				if (file != null) {
				Serializable.writeDeck(Deck.getInstance().toJSon(),file.getName());
				}
			});
		}
		return menuISave;
	}

	public MenuItem getMenuISaveAs() {
		if(menuISaveAs==null) {
			menuISaveAs= new MenuItem("Save as ...");
			menuISaveAs.setOnAction(e->{
				File fileOpen = fChooser.showSaveDialog(getScene().getWindow());
	            if(fileOpen != null) {
	            	File file = fileOpen;
					Serializable.writeDeck(Deck.getInstance().toJSon(),file.getAbsolutePath());	
	            }
			});
		}
		return menuISaveAs;
	}	
}

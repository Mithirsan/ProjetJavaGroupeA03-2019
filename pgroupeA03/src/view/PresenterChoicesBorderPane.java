package view;

import java.io.File;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import model.Presenter;



public class PresenterChoicesBorderPane extends BorderPane{	

	private ImageView presenterImageView;

	
	
	private ComboBox<Presenter> cbPresenter;
	private Button btnValidate;

	
	
	public PresenterChoicesBorderPane () {
		getCbPresenter().getSelectionModel().selectFirst();
		HBox hboxbtn = new HBox (getCbPresenter(),getBtnValidate());
		hboxbtn.setAlignment(Pos.CENTER);
		hboxbtn.setSpacing(150);

		setCenter(hboxbtn);

		
	}	
	
	public ComboBox<Presenter> getCbPresenter() {
		if(cbPresenter==null) {
			ObservableList<Presenter> presenter = FXCollections.observableArrayList(Presenter.values());
			cbPresenter = new ComboBox<>(presenter);
		
		}
		return cbPresenter;
	}
	public Button getBtnValidate() {
		if(btnValidate==null){
			btnValidate=new Button ("Validate");
			btnValidate.setOnAction(e->{
				((FinalViewStackPane) getParent()).getMenuBorderPane().getMenuVBox().setVisible(true);
				((FinalViewStackPane) getParent()).getPresenterBorderPane().setVisible(false);
				getpresenterImageView();
				((FinalViewStackPane) getParent()).getGamePlayBorderPane().getPoolStatus().setImagePresenter(presenterImageView);
				
			});
		}
		return 	btnValidate;
	}
	public ImageView getpresenterImageView() {
		if(presenterImageView==null) {
			Image imgPres = new Image(new File("ressources/pictures/"+getCbPresenter().getValue().getPresenter()+".jpg").toURI().toString());	
			presenterImageView= new ImageView(imgPres);
		}
		return presenterImageView;
	}
}

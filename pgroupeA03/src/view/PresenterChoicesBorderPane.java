package view;

import java.io.File;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Presenter;

public class PresenterChoicesBorderPane extends BorderPane{	

	private Image presenterImage;
	private ImageView imagePreview;
	
	private ComboBox<Presenter> cbPresenter;
	private Button btnValidate;

	public PresenterChoicesBorderPane () {
		getCbPresenter().getSelectionModel().selectFirst();
		VBox vboxSelect = new VBox(getCbPresenter(),getBtnValidate());
		vboxSelect.setSpacing(10.);
		HBox hboxbtn = new HBox (vboxSelect,getImagePreview());
	
		hboxbtn.setSpacing(10.);
		hboxbtn.setPadding(new Insets(250.));

		setCenter(hboxbtn);	
	}	
	
	public ComboBox<Presenter> getCbPresenter() {
		if(cbPresenter==null) {
			ObservableList<Presenter> presenter = FXCollections.observableArrayList(Presenter.values());
			cbPresenter = new ComboBox<>(presenter);
			cbPresenter.setOnAction(e->{
				getpresenterImage();
				getImagePreview().setImage(presenterImage);
			});
		
		}
		return cbPresenter;
	}
	
	public Button getBtnValidate() {
		if(btnValidate==null){
			btnValidate=new Button ("Validate");
			btnValidate.setOnAction(e->{
				((FinalViewStackPane) getParent()).getOptionsMenuBorderPane().setVisible(true);
				((FinalViewStackPane) getParent()).getPresenterBorderPane().setVisible(false);
				getpresenterImage();
				((FinalViewStackPane) getParent()).getGamePlayBorderPane().getPresenterAndPoolStatus().setImagePresenter(presenterImage);
			
				
			});
		}
		return 	btnValidate;
	}
	
	public Image getpresenterImage() {
			presenterImage = new Image(new File("resources/pictures/"+getCbPresenter().getValue().getPresenter()+".jpg").toURI().toString());	
			return presenterImage;
	}
	
	public ImageView getImagePreview() {
		if(imagePreview==null) {
			imagePreview= new ImageView(new Image ( new File("resources/pictures/JP-Foucault.jpg").toURI().toString() ));
		}
		return imagePreview;
	}
}

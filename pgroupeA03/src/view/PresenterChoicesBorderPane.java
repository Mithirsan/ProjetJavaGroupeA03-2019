package view;

import java.io.File;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class PresenterChoicesBorderPane extends BorderPane{
	
	private Button btnJPFoucault;
	private Button btnCamille;
	private Button btnLaFaucheuse;
	private Button btnLeJuge;

	private ImageView CamilleImageView;
	private ImageView LaFaucheuseImageView;
	private ImageView LeJugeImageView;
	private ImageView JPFoucaultImageView;
	
	private ImageView imageDefault;

	
	
	public PresenterChoicesBorderPane () {
		HBox hboxbtn = new HBox (getBtnJPFoucault(),getBtnCamille(),getBtnLaFaucheuse(),getBtnLeJuge());
		hboxbtn.setAlignment(Pos.BASELINE_CENTER);
		hboxbtn.setSpacing(150);
		HBox hboximage = new HBox(getJPFoucaultImageView(),getCamilleImageView(),getLaFaucheuseImageView(),getLeJugeImageView());
		hboximage.setSpacing(40);
		setCenter(hboximage);
		setBottom(hboxbtn);
		
	}

	

	public Button getBtnJPFoucault() {
		if(btnJPFoucault==null){
			btnJPFoucault=new Button ("Jean-Pierre Foucault");
			btnJPFoucault.setOnAction(e->{
				((FinalViewStackPane) getParent()).getMenuBorderPane().setVisible(true);
				((FinalViewStackPane) getParent()).getPresenterBorderPane().setVisible(false);
				((FinalViewStackPane) getParent()).getGamePlayBorderPane().getPoolStatus().putNewImage(JPFoucaultImageView);
				
			});
			
		}
		return btnJPFoucault;
	}

	public Button getBtnCamille() {
		if(btnCamille==null) {
			btnCamille=new Button ("Camille ");
			btnCamille.setOnAction(e->{
				((FinalViewStackPane) getParent()).getMenuBorderPane().setVisible(true);
				((FinalViewStackPane) getParent()).getPresenterBorderPane().setVisible(false);
				((FinalViewStackPane) getParent()).getGamePlayBorderPane().getPoolStatus().putNewImage(CamilleImageView);
				
			});
		}
		return btnCamille;
	}

	public Button getBtnLaFaucheuse() {
		if(btnLaFaucheuse==null) {
			btnLaFaucheuse=new Button ("La Faucheuse");
			btnLaFaucheuse.setOnAction(e->{
				((FinalViewStackPane) getParent()).getMenuBorderPane().setVisible(true);
				((FinalViewStackPane) getParent()).getPresenterBorderPane().setVisible(false);
				((FinalViewStackPane) getParent()).getGamePlayBorderPane().getPoolStatus().putNewImage(LaFaucheuseImageView);
				
			});
		}
		return btnLaFaucheuse;
	}

	public Button getBtnLeJuge() {
		if(btnLeJuge==null) {
			btnLeJuge=new Button ("The Juge");
			btnLeJuge.setOnAction(e->{
				((FinalViewStackPane) getParent()).getMenuBorderPane().setVisible(true);
				((FinalViewStackPane) getParent()).getPresenterBorderPane().setVisible(false);
				((FinalViewStackPane) getParent()).getGamePlayBorderPane().getPoolStatus().putNewImage(LeJugeImageView);
				
			});
		}
		return btnLeJuge;
	}

	
	public void setImageDefault(ImageView imageDefault) {
		this.imageDefault = imageDefault;
	}



	public ImageView getJPFoucaultImageView() {
		if(JPFoucaultImageView==null) {
			Image imagejp = new Image(new File("ressources/pictures/jean-pierre-foucault.jpg").toURI().toString());
		
			JPFoucaultImageView= new ImageView(imagejp);
			
			
		}
		return JPFoucaultImageView;
	}

	public ImageView getCamilleImageView() {
		if(CamilleImageView==null) {
			Image imageCamille = new Image(new File ("ressources/pictures/Camille.jpg").toURI().toString());
			CamilleImageView = new ImageView (imageCamille);
			
		}
		return CamilleImageView;
	}

	public ImageView getLaFaucheuseImageView() {
		if(LaFaucheuseImageView==null) {
			Image imageFaucheuse = new Image(new File ("ressources/pictures/LaFaucheuse.jpg").toURI().toString());
			
			LaFaucheuseImageView = new ImageView (imageFaucheuse);
		}
		return LaFaucheuseImageView;
	}

	public ImageView getLeJugeImageView() {
		if(LeJugeImageView==null) {
			 Image imageJuge = new Image (new File ("ressources/pictures/Juge.jpg").toURI().toString());
			
			LeJugeImageView = new ImageView (imageJuge);
		}
		return LeJugeImageView;
	}
	public ImageView getImagedefault() {
		if(imageDefault==null) {
			 Image imagedefault = new Image (new File("ressources/pictures/Background.jpg").toURI().toString());
			
			 imageDefault = new ImageView (imagedefault);
		}
		return imageDefault;
	}

	public ImageView getImageDefault() {
		return imageDefault;
	}


	

}

package gioco;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Giochino /*(Journey of the prairie king)*/ extends Application{
	
	private static final int DIM = 32;
	
	Pane pPrincipale;
	
	Pane pIniziale;
	Pane pOpzioni;
	
	Pane pInGame;
	Rectangle rCowboy;
	Rectangle rMob;
	int variabileX= 0, variabileY= 0;
	Circle[] proiettile = new Circle[5000];
	Bounds bCerchioProiettile;
	Bounds bMostro;
	int munizioni = 0;
	KeyFrame kBulletHell;
	
	
	
	@Override
	public void start(Stage primaryStage) {

		
		
		Image immagineCactus = new Image(getClass().getResourceAsStream("cactusVerde.png"));
		ImageView usoCactus = new ImageView(immagineCactus);
		
		
		pPrincipale = new Pane ();
		pPrincipale.setPrefSize(512, 512);
		
		pIniziale = new Pane();
		Label lTitolo = new Label("Trial of the cowboy");
		lTitolo.setPrefSize(220, 950);
		lTitolo.relocate(200, 160);
		
		Button bStart = new Button ("Attempt");
		bStart.setPrefSize(120, 35);
		bStart.relocate(190, 250);
		
		Button bOpzioni = new Button ("Opzioni");
		bOpzioni.relocate(220, 300);
		
		
		pIniziale.getChildren().add(lTitolo);
		pIniziale.getChildren().add(bStart);
		pIniziale.getChildren().add(bOpzioni);
		
		pOpzioni = new Pane();
		
		
		pInGame = new Pane();
		pInGame.setId("InGioco");
		pInGame.setVisible(false);
		rCowboy = new Rectangle (DIM, DIM);
		rCowboy.setFill(Color.RED);
		rCowboy.setX(250);
		rCowboy.setY(250);
		pInGame.getChildren().add(rCowboy);
		rMob = new Rectangle (DIM, DIM);
		rMob.setFill(Color.BROWN);
		rMob.setX(144);
		rMob.setY(0);
		pInGame.getChildren().add(rMob);
		
		/*for ( contaCactus= 0;contaCactus >= 6;contaCactus++) {
			int x = 0, y = 0;
			rCactus[contaCactus] = new Rectangle();
			rCactus[contaCactus].setX(x);
			rCactus[contaCactus].setY(y);
			usoCactus[contaCactus] = new ImageView(immagineCactus);
			usoCactus[contaCactus].setPreserveRatio(true);
			usoCactus[contaCactus].setFitWidth(DIM);
			usoCactus[contaCactus].setLayoutX(rCactus[contaCactus].getX());
			usoCactus[contaCactus].setLayoutY(rCactus[contaCactus].getY());
			pInGame.getChildren().add(rCactus[contaCactus]);
			pInGame.getChildren().add(usoCactus[contaCactus]);
			y = y + DIM;
		}*/
		
		Rectangle rCactus = new Rectangle();
		rCactus.setX(0);
		rCactus.setY(0);
		usoCactus = new ImageView(immagineCactus);
		usoCactus.setPreserveRatio(true);
		usoCactus.setFitWidth(DIM);
		usoCactus.setLayoutX(rCactus.getX());
		usoCactus.setLayoutY(rCactus.getY());
		pInGame.getChildren().add(rCactus);
		pInGame.getChildren().add(usoCactus);
		
		pPrincipale.getChildren().add(pIniziale);
		pPrincipale.getChildren().add(pInGame);
		pPrincipale.getChildren().add(pOpzioni);
		
		
		//tMovimento = new Timeline[3000];
		
		Scene scene = new Scene(pPrincipale);
		scene.getStylesheets().add("gioco/Giochino.css");
		
		scene.addEventHandler(KeyEvent.KEY_PRESSED,freccia -> sparare(freccia));
		
		primaryStage.setTitle("Cowboy vs something");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		scene.setOnKeyPressed( e -> movimento(e));
		
		bStart.setOnAction(e -> cambioInGioco());
		bOpzioni.setOnAction(e -> cambioInOpzioni());
		
		
		/*Timeline tSparoSparisce = new Timeline (new KeyFrame(Duration.millis(50), s -> sparisciAiBordi()));
		tSparoSparisce.setCycleCount(Timeline.INDEFINITE);
		tSparoSparisce.play();*/
	}



	private void cambioInOpzioni() {
		
	}



	private void cambioInGioco() {
		pInGame.setVisible(true);
		pIniziale.setVisible(false);
	}



	private void movimento(KeyEvent e) {
		if (e.getText().equals("w")){
			rCowboy.setY(rCowboy.getY()- 10);
		}
	
		if (e.getText().equals("s")){
			rCowboy.setY(rCowboy.getY() + 10);
		}
		
		if (e.getText().equals("a")){
			rCowboy.setX(rCowboy.getX() - 10);
		}

		if (e.getText().equals("d")){
			rCowboy.setX(rCowboy.getX() + 10);
		}
		
		
		
		}	

	private void sparare(KeyEvent freccia) {
		
		
		
		
		
		
		
		bMostro = rMob.getBoundsInParent();
		
		if (freccia.getCode().equals(KeyCode.UP)) {
			munizioni = munizioni + 1;
			
			proiettile[munizioni] = new Circle();
			proiettile[munizioni].setFill(Color.BURLYWOOD);
			proiettile[munizioni].setRadius(5);

			
			variabileX = 0;
			variabileY = -1;
			proiettile[munizioni].setCenterX(rCowboy.getX() + 10);
			proiettile[munizioni].setCenterY(rCowboy.getY() - 10);

			pInGame.getChildren().add(proiettile[munizioni]);
			kBulletHell = new KeyFrame(Duration.millis(50), f -> proiettileMove());
			
			
			
			Timeline tMovimento = new Timeline();
			tMovimento.getKeyFrames().add(kBulletHell);
			tMovimento.setCycleCount(Timeline.INDEFINITE);
			tMovimento.play();
			
			
			}
		
		
		
		
		
		}
			
			
		private void proiettileMove() {
			
			proiettile[munizioni].setCenterX(proiettile[munizioni].getCenterX() + variabileX);
			proiettile[munizioni].setCenterY(proiettile[munizioni].getCenterY() + variabileY);
			
			bCerchioProiettile = proiettile[munizioni].getBoundsInParent();
			
			if (bCerchioProiettile.intersects(bMostro)) {
				System.out.print("bl");
				pInGame.getChildren().remove(rMob);
				pInGame.getChildren().remove(proiettile[munizioni]);
				rMob.setX(-30);
			}
		}
	
	
	
	private void sparisciAiBordi() {
		
		if (proiettile[munizioni].getCenterY() < 0 && proiettile[munizioni].getCenterY() < 320) {
			proiettile[munizioni].setBlendMode(null);
		}
	}



	public static void main(String[] args) {
        launch(args);
    }

}

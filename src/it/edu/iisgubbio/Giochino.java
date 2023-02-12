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
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Giochino /*(Journey of the prairie king)*/ extends Application{
	
	//Costante
	private static final int DIM = 32;
	
	Pane pPrincipale;
	Pane pIniziale;
	Pane pOpzioni;
	Pane pInGame;
	
	Rectangle rCowboy;
	Rectangle[] rMob;
	Circle[] proiettile = new Circle[5000];
	
	Bounds bCerchioProiettile;
	Bounds bMostro;
	
	Timeline[] tMovimento;
	KeyFrame kBulletHell;
	
	int variabileX= 0, variabileY= 0;
	int munizioni = 0;
	int numeroMob= 0;
	@Override
	public void start(Stage primaryStage) {

		tMovimento = new Timeline[4000];
		
		Image immagineCactus = new Image(getClass().getResourceAsStream("pixil-frame-0.png"));
		ImageView usoCactus = new ImageView(immagineCactus);
		
		
		pPrincipale = new Pane ();
		pPrincipale.setPrefSize(512, 512);
		
		pIniziale = new Pane();
		Label lTitolo = new Label("Trial of the cowboy");
		lTitolo.setPrefSize(220, 50);
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
		rMob = new Rectangle [40];
		
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
		
		//Primo cactus
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
		//scene.getStylesheets().add("gioco/Giochino.css");
		
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


	//Cambio di schermate
	private void cambioInOpzioni() {
		pIniziale.setVisible(false);
		pOpzioni.setVisible(true);
	}



	private void cambioInGioco() {
		pInGame.setVisible(true);
		pIniziale.setVisible(false);
		
		Timeline avviaMob = new Timeline(new KeyFrame(Duration.seconds(5), e -> spawnaMob()));
		avviaMob.setCycleCount(Timeline.INDEFINITE);
		avviaMob.play();
	}
	
	//Fa entrare i mostri
	private void spawnaMob() {
		int caso = (int) (Math.random()*4)+1;
		System.out.print(caso);
		rMob[numeroMob]= new Rectangle(DIM, DIM);
		rMob[numeroMob].setFill(Color.BROWN);
		rMob[numeroMob].setX(-90);
		rMob[numeroMob].setY(0);
		pInGame.getChildren().add(rMob[numeroMob]);
		if (numeroMob >= 20) {
		if (caso == 1) {
			bMostro = rMob[numeroMob].getBoundsInParent();
			rMob[numeroMob].setX(256 - DIM / 2);
			rMob[numeroMob].setY(0);
			numeroMob++;
		}
		if (caso == 2) {
			bMostro = rMob[numeroMob].getBoundsInParent();
			rMob[numeroMob].setX(512 - DIM);
			rMob[numeroMob].setY(256 - DIM / 2);
			numeroMob++;
		}
		if (caso == 3) {
			bMostro = rMob[numeroMob].getBoundsInParent();
			rMob[numeroMob].setX(256 - DIM / 2);
			rMob[numeroMob].setY(512 - DIM);
			numeroMob++;
		}
		if (caso == 4) {
			bMostro = rMob[numeroMob].getBoundsInParent();
			rMob[numeroMob].setX(0);
			rMob[numeroMob].setY(256 - DIM / 2);
			numeroMob++;
		}
	}
}
	
	// Fa camminare il personaggio
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
	
	//Crea e fa muovere i proiettili
	private void sparare(KeyEvent freccia) {
		
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
			
			tMovimento[munizioni] = new Timeline();
			tMovimento[munizioni].getKeyFrames().add(kBulletHell);
			tMovimento[munizioni].setCycleCount(Timeline.INDEFINITE);
			tMovimento[munizioni].play();
			}
		}
			
			
		private void proiettileMove() {
			
			proiettile[munizioni].setCenterX(proiettile[munizioni].getCenterX() + variabileX);
			proiettile[munizioni].setCenterY(proiettile[munizioni].getCenterY() + variabileY);
			
			bCerchioProiettile = proiettile[munizioni].getBoundsInParent();
			if (bCerchioProiettile.intersects(bMostro)) {
				
				pInGame.getChildren().remove(rMob[numeroMob]);
				pInGame.getChildren().remove(proiettile[munizioni]);
				rMob[numeroMob].setX(-30);
			}
		}
		
	public static void main(String[] args) {
        launch(args);
    }

}

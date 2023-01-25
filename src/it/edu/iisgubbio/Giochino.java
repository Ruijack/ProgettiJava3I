package it.edu.iisgubbio;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
	
	Pane pPrincipale;
	
	Pane pIniziale;
	Label lTitolo;
	Button bStart;
	
	Pane pInGame;
	Rectangle rCowboy;
	int variabileX= 0, variabileY= 0;
	Circle[] proiettile = new Circle[5000];
	int munizioni = 0;
	
	
	@Override
	public void start(Stage primaryStage) {
		
		pPrincipale = new Pane ();
		pPrincipale.setPrefSize(320, 320);
		
		pIniziale = new Pane();
		lTitolo = new Label("Trial of a cowboy");
		bStart = new Button ("Fai un tentativo");
		pIniziale.getChildren().add(lTitolo);
		
		pInGame = new Pane();
		
		
		pPrincipale.getChildren().add(pIniziale);
		pPrincipale.getChildren().add(pInGame);
		
		rCowboy = new Rectangle (20, 20);
		rCowboy.setFill(Color.RED);
		rCowboy.setX(140);
		rCowboy.setY(140);
		pInGame.getChildren().add(rCowboy);
		
		Scene scene = new Scene(pPrincipale);
		scene.addEventHandler(KeyEvent.KEY_PRESSED,freccia -> sparare(freccia));
		
		primaryStage.setTitle("Cowboy vs something");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		scene.setOnKeyPressed( e -> movimento(e));
		
		/*Timeline tSparoSparisce = new Timeline (new KeyFrame(Duration.millis(50), s -> sparisciAiBordi()));
		tSparoSparisce.setCycleCount(Timeline.INDEFINITE);
		tSparoSparisce.play();*/
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
		
		if (freccia.getCode().equals(KeyCode.UP)) {
			munizioni = munizioni + 1;
			proiettile[munizioni] = new Circle();
			proiettile[munizioni].setFill(Color.BROWN);
			
			proiettile[munizioni].setRadius(5);
			proiettile[munizioni].setCenterX(44444);
			proiettile[munizioni].setCenterY(88888);
			
			
			System.out.println("biss");

			variabileX = 0;
			variabileY = -1;
			proiettile[munizioni].setCenterX(rCowboy.getX() + 10);
			proiettile[munizioni].setCenterY(rCowboy.getY() - 20);
			pInGame.getChildren().add(proiettile[munizioni]);
			
			Timeline tMovimento = new Timeline (new KeyFrame(Duration.millis(50), f -> proiettileMove()));
			tMovimento.setCycleCount(Timeline.INDEFINITE);
			tMovimento.play();
		}
		
		
		}

	
	
	private void proiettileMove() {
		
		proiettile[munizioni].setCenterX(proiettile[munizioni].getCenterX() + variabileX);
		proiettile[munizioni].setCenterY(proiettile[munizioni].getCenterY() + variabileY);
		
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

package it.edu.iisgubbio;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Giochino /*(Journey of the prairie king)*/ extends Application{
	
	Pane pPrincipale;
	Pane pIniziale;
	Pane pInGame;
	Rectangle rCowboy;
	int variabileX= 0, variabileY= 0;
	Circle[] proiettile;
	int x = 0;
	
	@Override
	public void start(Stage primaryStage) {
		pPrincipale = new Pane ();
		pPrincipale.setPrefSize(320, 320);
		pIniziale = new Pane();
		pInGame = new Pane();
		pPrincipale.getChildren().add(pIniziale);
		pPrincipale.getChildren().add(pInGame);
		
		rCowboy = new Rectangle (20, 20);
		rCowboy.setFill(Color.RED);
		rCowboy.setX(140);
		rCowboy.setY(140);
		pInGame.getChildren().add(rCowboy);
		
		Scene scene = new Scene(pPrincipale);
		scene.addEventHandler(KeyEvent.KEY_PRESSED,e -> sparare(e));
		
		primaryStage.setTitle("Cowboy vs something");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		scene.setOnKeyPressed( e -> movimento(e));
		
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
	

	private void sparare(KeyEvent e) {
		proiettile = new Circle[50];
		for (;x <= x+1;x = x + 1 ) {
		if (e.getCode().equals(KeyCode.UP)) {
			proiettile[x] = new Circle();
			proiettile[x].setFill(Color.BROWN);
			pInGame.getChildren().add(proiettile[x]);

			variabileX = 0;
			variabileY = -1;
			
			Timeline tMovimento = new Timeline (new KeyFrame(Duration.millis(50), f -> proiettileMove()));
			tMovimento.setCycleCount(Timeline.INDEFINITE);
			tMovimento.play();

		}
		}

	}
	
	private void proiettileMove() {
		proiettile[x].setCenterX(rCowboy.getX() + 10);
		proiettile[x].setCenterY(rCowboy.getY() - 20);
		proiettile[x].setCenterX(proiettile[x].getCenterX() + variabileX);
		proiettile[x].setCenterY(proiettile[x].getCenterY() + variabileY);
		
	}



	public static void main(String[] args) {
        launch(args);
    }

}

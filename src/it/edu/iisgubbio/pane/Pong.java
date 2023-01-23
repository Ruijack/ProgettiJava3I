package it.edu.iisgubbio.pane;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventType;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
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

public class Pong extends Application{
	
	Pane finestra;
	Timeline timer;
	Circle cerchio;
	int cerchioX = 1, cerchioY = 1;
	int x = 300, y = 250;
	Rectangle racchettaS;
	Rectangle racchettaD;
	Bounds sinistra;
	Bounds destra;
	Bounds palla;
	Label lPuntiS;
	Label lPuntiD;
	
	
	public void start(Stage primaryStage){
		
		Label lPunti = new Label ("Punteggio");
		lPuntiS = new Label ("0");
		lPuntiD = new Label ("0");
		
		finestra = new Pane();
		finestra.setPrefSize(600, 500);
		
		GridPane griglia = new GridPane ();
		griglia.add(finestra, 0, 2);
		griglia.add(lPunti, 2, 0, 2, 1);
		griglia.add(lPuntiS, 2, 1);
		griglia.add(lPuntiD, 3, 1);
		
		racchettaS = new Rectangle (10,70); 
		racchettaS.setX(20);
		racchettaS.setY(50);
		racchettaS.setFill(Color.RED);
		
		racchettaD = new Rectangle (10,70); 
		racchettaD.setX(580);
		racchettaD.setY(50);
		racchettaD.setFill(Color.RED);
		
		cerchio = new Circle(20);
		cerchio.setCenterX(x);
		cerchio.setCenterY(y);
		cerchio.setFill(Color.AQUAMARINE);
		
		
		
		finestra.getChildren().add(cerchio);
		finestra.getChildren().add(racchettaS);
		finestra.getChildren().add(racchettaD);
		
		timer = new Timeline (new KeyFrame(Duration.millis(5), e -> rimbalzo()));
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();
        
		Scene scene = new Scene(griglia);
		
		primaryStage.setTitle("Rimbalzi");
		primaryStage.setScene(scene);
		primaryStage.show();

		scene.setOnKeyPressed( e -> racchette(e));
	}
	
	private void racchette(KeyEvent e) {
		if (e.getText().equals("w")) {
			racchettaS.setY(racchettaS.getY()- 10);
			
		}
		if (e.getText().equals("s")) {
			racchettaS.setY(racchettaS.getY()+ 10);
			
		}
		if (e.getCode().equals(KeyCode.UP)) {
			racchettaD.setY(racchettaD.getY()- 10);
			
		}
		if (e.getCode().equals(KeyCode.DOWN)) {
			racchettaD.setY(racchettaD.getY()+ 10);
			
		}
		
	}

	private void rimbalzo() {
		
		int puntoS = Integer.parseInt(lPuntiS.getText());
		int puntoD = Integer.parseInt(lPuntiD.getText());
		
		x = cerchioX + x;
		y = cerchioY + y;
		cerchio.setCenterX(x);
		cerchio.setCenterY(y);
		/*if (x == 0.0 + 20) {
			cerchioX = 1;
		} */
		if (y == 0.0 + 20) {
			cerchioY = 1; 
		}
		/*if (x == 600 - 20) {
			cerchioX = -1;
		} */
		if (y == 400 - 20) {
			cerchioY = -1;
		
		}
		sinistra = racchettaS.getBoundsInParent();
		destra = racchettaD.getBoundsInParent();
		palla = cerchio.getBoundsInParent();
		
		if (sinistra.intersects(palla)){
			cerchioX = 1;
			
		}
		if (destra.intersects(palla)) {
			cerchioX = -1;
			
		}
		
		if (cerchioX == 0) {
			
			cerchio.setCenterX(300);
			cerchio.setCenterY(250);
			x = -1;
			y = -1;
			puntoS += 1;
			lPuntiS.setText("" + puntoS);
		}
		
		if (cerchioX == 600) {
			cerchio.setCenterX(300);
			cerchio.setCenterY(250);
			x = 1;
			y = 1;
			puntoD += 1;
			lPuntiS.setText("" + puntoD);
		}
	}
	
	public static void main(String[] args) {
        launch(args);
    }

}

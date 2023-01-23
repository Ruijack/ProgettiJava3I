package it.edu.iisgubbio.pane;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class cerchioAvanti extends Application{
	
	Circle cerchio;
	Pane finestra;
	Timeline timer;
	Timeline timerDietro;
	
	public void start(Stage primaryStage){
		
		timer = new Timeline (new KeyFrame(Duration.millis(10), e -> seMove()));
		timer.setCycleCount(Timeline.INDEFINITE);
		timer.play();
		
		timerDietro = new Timeline (new KeyFrame(Duration.millis(10), e -> seMoveRetro()));
		timerDietro.setCycleCount(Timeline.INDEFINITE);
		
		
		finestra = new Pane();
		finestra.setPrefSize(400, 400);
		
		cerchio = new Circle (30);
		cerchio.setCenterX(40);
		cerchio.setCenterY(40);
		cerchio.setFill(Color.AQUAMARINE);
		finestra.getChildren().add(cerchio);
		
		Scene scene = new Scene(finestra);
		
		primaryStage.setTitle("Caricaaaaaaaaaaaaaa!");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private void seMove() {
		double postoX = cerchio.getCenterX();
		if (postoX < 370) {
		postoX = postoX + 1;
		cerchio.setCenterX(postoX);
		}else {
			timerDietro.play();
			timer.stop();
		}
	}
	private void seMoveRetro() {
		double postoX = cerchio.getCenterX();
			postoX = postoX - 1;
			cerchio.setCenterX(postoX);
	}
	
	public static void main(String[] args) {
        launch(args);
    }

}

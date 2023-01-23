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

public class paneDiUrba extends Application {
	Circle cerchio = new Circle(30);
	Timeline tTempo = new Timeline();
	int modificatoreX = 1;
	int modificatoreY = 1;
	double x = 100.0;
	double y = 120.0;
	int c = 0;

	public void start(Stage primaryStage) {
		Pane quadro = new Pane();
		quadro.setPrefSize(401,300);

		cerchio.setCenterY(y);
		cerchio.setCenterX(x);
		cerchio.setFill( Color.NAVY );
		quadro.getChildren().add(cerchio);

		Scene scene = new Scene(quadro);
		primaryStage.setTitle("Pane!!");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		KeyFrame timeline = new KeyFrame(
				Duration.seconds(0.003),
				x -> aggiornaTimer());
		tTempo = new Timeline(timeline);
		tTempo.setCycleCount(Timeline.INDEFINITE);
		tTempo.play();
	}


		private void aggiornaTimer() {
			x+=modificatoreX;
			y+=modificatoreY;
			cerchio.setCenterY(y);
			cerchio.setCenterX(x);
			
			if(x==401.0 - 20) {
				modificatoreX = -1;
			}
			if(x==0.0 + 20) {
				modificatoreX = 1;	
			}
			
			if(y==300.0 - 20) {
				modificatoreY = -1;
			}
			if(y==0.0 + 20) {
				modificatoreY = 1;	
			}
		}

			

			public static void main(String[] args) {
				launch(args);
			}
		}
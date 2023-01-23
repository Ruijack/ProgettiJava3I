package it.edu.iisgubbio.canves;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PallinaSiMuove extends Application{
	
	Canvas quadro;
	GraphicsContext gc;
	Timeline timeline;
	  int c = 50;
	
	  public void start(Stage primaryStage) {
		  
		  quadro = new Canvas (400, 400);
		  gc = quadro.getGraphicsContext2D();
		  gc.setFill(Color.RED);
		  gc.fillOval(c, 50, 20, 20);
		  
		  GridPane griglia = new GridPane();
		  griglia.add(quadro, 0, 0);
		  
		  KeyFrame frame = new KeyFrame (Duration.seconds(0.01), x -> aggiorna());
		  timeline = new Timeline (frame);
		  timeline.setCycleCount(260);
		  timeline.play();
		  
		  Scene scene = new Scene(griglia);
		  primaryStage.setTitle("Palla si muove, bene");
		  primaryStage.setScene(scene);
		  primaryStage.show();
	  }
	  
	  private void aggiorna() {
		  
		  gc.clearRect(c, 50, 20, 20);
		  c = c + 1;
		  gc.setFill(Color.RED);
		  gc.fillOval(c, 50, 20, 20);
			  
	  }
	  
	  public static void main(String[] args) {
		    launch(args);
		  }

}

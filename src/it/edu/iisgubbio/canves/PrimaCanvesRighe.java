package it.edu.iisgubbio.canves;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PrimaCanvesRighe extends Application{
	
	Canvas quadro;
	GraphicsContext gc;
	
	  public void start(Stage primaryStage) {
		  
		  quadro = new Canvas (200, 200);
		  gc = quadro.getGraphicsContext2D();
		  
		  gc.setStroke(Color.RED);
		  gc.strokeLine(0, 0, 199, 0);
		  
		  GridPane root = new GridPane();
		  root.add(quadro, 0, 0);
		  
		  for (int c = 0;c < 199;c = c + 25) {
			  gc.strokeLine(0, c, 199, c);
			  
		  }
		  
		    Scene scene = new Scene(root);
		    primaryStage.setTitle("Righeeeeeee! Sulla canvas");
		    primaryStage.setScene(scene);
		    primaryStage.show();
	  }
	  
	  public static void main(String[] args) {
		    launch(args);
		  }
}

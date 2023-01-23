package it.edu.iisgubbio.canves;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GiocoSquadre extends Application{
	
	Canvas quadro;
	GraphicsContext gc;

	public void start(Stage primaryStage){
		
		  quadro = new Canvas (700, 700);
		  gc = quadro.getGraphicsContext2D();
		
		  GridPane griglia = new GridPane();
		  griglia.add(quadro, 0, 0);
		  
		  Scene scene = new Scene(griglia);
		  primaryStage.setTitle("Clicca come vuoi");
		  primaryStage.setScene(scene);
		  primaryStage.show();
		  
		  for (int c = 0;c < 700;c = c + 20) {
			  gc.strokeArc(0, 0, 0, 0, 0, 0, null);
		  }
	}
	
	public static void main(String[] args) {
	    launch(args);
	  }

}

package it.edu.iisgubbio.pane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class formeInMovimento extends Application{
	
	public void start(Stage primaryStage){
		Pane finestra = new Pane();
		finestra.setPrefSize(400, 400);
		
		Rectangle rettangolo = new Rectangle (40, 100);
		rettangolo.setX(50);
		rettangolo.setY(30);
		rettangolo.setFill(Color.MAGENTA);
		finestra.getChildren().add(rettangolo);
		
		Polygon triangolo = new Polygon (40, 100);
		rettangolo.setX(50);
		rettangolo.setY(30);
		rettangolo.setFill(Color.MAGENTA);
		finestra.getChildren().add(triangolo);
		
		finestra.addEventHandler(MouseEvent.DRAG_DETECTED, posto -> movimento(posto));		
		Scene scene = new Scene(finestra);
		
		primaryStage.setTitle("Clicca come vuoi");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private void movimento(MouseEvent posto) {
		 
	}
	
	public static void main(String[] args) {
        launch(args);
    }

}

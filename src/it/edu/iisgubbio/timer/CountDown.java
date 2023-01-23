package it.edu.iisgubbio.timer;

import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class CountDown extends Application{
	
	Label lEtichetta = new Label("10");;
	Timeline timer = new Timeline (new KeyFrame (Duration.seconds (1), e ->diminuisci()));
    
	public void start(Stage primaryStage) {
		
		GridPane griglia = new GridPane ();
		griglia.add(lEtichetta, 0, 0);
		
		Scene Scene = new Scene(griglia);
		
		Scene.getStylesheets().add("it/edu/iisgubbio/timer/UnaLabel.css");
		
        primaryStage.setTitle("Countdown");
        primaryStage.setScene(Scene);
        primaryStage.show();
        
        timer.setCycleCount(10);
        timer.play();
	}

	private void diminuisci() {
		int numero;
		numero = Integer.parseInt(lEtichetta.getText());
		numero = numero - 1;
		lEtichetta.setText(numero + "");
	}
	
    public static void main(String[] args) {
        launch(args);
    }

}

package it.edu.iisgubbio.timer;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class barraConSimboli extends Application{
	
	TextField fSimbolo;
	TextField fContatore;
	TextField fMillisecondi;
	Label lBarra;
	int fine;
	Timeline timer;
	int c = 0;
	String simbolo, barra = "";
	
	public void start(Stage primaryStage){
		
		Label lSimbolo = new Label ("Simbolo: ");
		Label lContatore = new Label ("Contatore: ");
		Label lMillisecondi = new Label ("Millisecondi: ");
		lBarra = new Label("");
		Button bInizia = new Button ("Via");
		fSimbolo = new TextField();
		fContatore = new TextField();
		fMillisecondi = new TextField();
		
		GridPane griglia = new GridPane();
		griglia.add(lSimbolo, 0, 0);
		griglia.add(lContatore, 0, 1);
		griglia.add(lMillisecondi, 0, 2);
		griglia.add(lBarra, 0, 3, 3, 1);
		griglia.add(fSimbolo, 1, 0);
		griglia.add(fContatore, 1, 1);
		griglia.add(fMillisecondi, 1, 2);
		griglia.add(bInizia, 2, 0, 1, 3);
		
		Scene scene = new Scene(griglia);
		
		scene.getStylesheets().add("it/edu/iisgubbio/timer/UnaLabel.css");
		bInizia.getStyleClass().add("button");
		
		primaryStage.setTitle("Clicca come vuoi");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		
		bInizia.setOnAction(e -> inizializzzione());
	}
	
	private void inizializzzione() {
		int tempo ;
		int fine = Integer.parseInt(fContatore.getText());
    	simbolo = fSimbolo.getText();
		tempo = Integer.parseInt(fMillisecondi.getText());
		timer = new Timeline (new KeyFrame(Duration.millis(tempo), e -> crea()));
        timer.setCycleCount(fine);
        timer.play();
	}

    private void crea() {
    	if (c>=fine) {
    		barra = barra + simbolo;
    		lBarra.setText(barra);
    		c = c + 1;
    	}
	}

	public static void main(String[] args) {
        launch(args);
    }
}

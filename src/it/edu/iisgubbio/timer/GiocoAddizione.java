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

public class GiocoAddizione extends Application{
	
	Label lPunti;
	Label lRisultato;
	Label lNumeroOne;
	Label lNumeroDos;
	TextField fRisultato;
	Timeline timer;
	int punti = 50;
	Button bNuova;
	public void start(Stage primaryStage){
		
		int x = (int)(Math.random()*100)+10;
		int x2 = (int)(Math.random()*100)+10;
		
		bNuova = new Button ("Genera nuovi numeri");
		lNumeroOne = new Label ("" + x);
		lNumeroDos = new Label ("" + x2);
		fRisultato = new TextField ();
		lRisultato = new Label ("Punti:");
		timer = new Timeline (new KeyFrame(Duration.seconds(1), e -> punteggio()));
		
		Label lpiù = new Label ("+");
		Label lUguale = new Label ("=");
		GridPane griglia = new GridPane();
		griglia.add(lNumeroOne, 0, 0);
		griglia.add(lpiù, 1, 0);
		griglia.add(lNumeroDos, 2, 0);
		griglia.add(lUguale, 3, 0);
		griglia.add(fRisultato, 4, 0);
		griglia.add(lRisultato, 0, 1, 50, 1);
		griglia.add(bNuova, 0, 2, 4, 1);
        fRisultato.setOnAction(e -> controlla());
        bNuova.setOnAction(e -> genera());
		Scene scene = new Scene(griglia);
		
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();
		
		scene.getStylesheets().add("it/edu/iisgubbio/timer/UnaLabel.css");
		
		primaryStage.setTitle("Clicca come vuoi");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	private void controlla() {
		int risposta, numeroPrimo, numeroSecondo;
		numeroSecondo = Integer.parseInt(lNumeroDos.getText());
		numeroPrimo = Integer.parseInt(lNumeroOne.getText());
		risposta = Integer.parseInt(fRisultato.getText());
		if (numeroSecondo + numeroPrimo == risposta) {
			lRisultato.setText("Punti: " + punti);
			timer.reset();
		}else{
			lRisultato.setText("Mi dispiace hai sbagliato, riprova");
	}
		
	}
	private void punteggio() {
		punti = punti -1;
	}
	
	private void genera() {
		int x = (int)(Math.random()*100)+10;
		int x2 = (int)(Math.random()*100)+10;
		lNumeroOne.setText("" + x);
		lNumeroDos.setText("" + x2);
        timer.play();
		lRisultato.setText("Punti:");
	}
	

	
	
    public static void main(String[] args) {
        launch(args);
    }
}

package it.edu.iisgubbio.coseConNumeri;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Divisori extends Application{
	
	Label lDivisori;
	TextField fDividendo;
	
	public void start(Stage primaryStage){
		
		lDivisori = new Label();
		fDividendo = new TextField();
		Label lNumero = new Label ("Numero");
		Button bDivisori = new Button ("Divisori");
		
		GridPane griglia = new GridPane();
		griglia.add(lNumero, 0, 0);
		griglia.add(fDividendo, 1, 0);
		griglia.add(bDivisori, 0, 1, 2, 1);
		griglia.add(lDivisori, 0, 2, 2, 1);
		  
		Scene scene = new Scene(griglia);
		
		scene.getStylesheets().add("it/edu/iisgubbio/coseConNumeri/coseConNumeri.css");
		
		primaryStage.setTitle("Clicca come vuoi");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		bDivisori.setOnAction(e -> trovali());
	}
	
	private void trovali() {
		int divisore;
		String divisori = "";
		divisore = Integer.parseInt(fDividendo.getText());
		for (int c = 1;c <= divisore / 2;c = c + 1) {
			if (divisore % c == 0) {
				divisori = divisori + " " + c;
			}
		} 
		lDivisori.setText(divisori + " " + divisore);
	}

	public static void main(String[] args) {
	    launch(args);
	  }

}

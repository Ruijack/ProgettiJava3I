package it.edu.iisgubbio.geometria;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Rettangolo extends Application {
	
	Label lBase = new Label ("Base");
	Label lAltezza = new Label ("Altezza");
	Label lPerimetro = new Label ();
	Label lArea = new Label ();
	TextField nBase = new TextField ();
	TextField nAltezza = new TextField ();
	Button bArea = new Button ("Area");
	Button bPerimetro = new Button ("Perimetro");
	
	
	public void start(Stage primaryStage) {
		
		
		GridPane griglia = new GridPane();
		griglia.add(lBase, 0, 0);
		griglia.add(lAltezza, 0, 1);
		griglia.add(lPerimetro, 1, 2);
		griglia.add(lArea, 1, 2);
		griglia.add(nBase, 1, 0);
		griglia.add(nAltezza, 1, 1);
		griglia.add(bArea, 2, 0);
		griglia.add(bPerimetro, 2, 1);
		
        Scene Scene = new Scene(griglia, 500, 250);
        
        primaryStage.setTitle("Rettangolo");
        primaryStage.setScene(Scene);
        primaryStage.show();
        
   	   bArea.setOnAction(e -> moltiplicazione());
  	   bPerimetro.setOnAction(e -> somme());
		
	}
	
	private void moltiplicazione() {
 	   String risposta;
 	   int numero1, numero2, risultato;
 	   
 	   numero1 = Integer.parseInt(nBase.getText());
 	   numero2 = Integer.parseInt(nAltezza.getText());
 	   risultato = numero1 * numero2;
 	   risposta = "" +  risultato;
	   lArea.setText(risposta);
	}
	
	private void somme() {
	 	   String risposta;
	 	   int numero1, numero2, risultato;
	 	   
	 	   numero1 = Integer.parseInt(nBase.getText());
	 	   numero2 = Integer.parseInt(nAltezza.getText());
	 	   risultato = numero1 * 2 + numero2 * 2;
	 	   risposta = "" +  risultato;
		   lPerimetro.setText(risposta);
	}
	
	
	
	
    public static void main(String[] args) {
        launch(args);
    }

}

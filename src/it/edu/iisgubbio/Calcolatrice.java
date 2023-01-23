package it.edu.iisgubbio;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Calcolatrice extends Application{
	
	Button bSomma = new Button("+");
	Button bSottrazione = new Button("-");
	Button bMoltiplicazione = new Button("*");
	Button bDivisione = new Button("/");
	Label lNumero1 = new Label("Numero1");
	Label lNumero2 = new Label("Numero2");
	Label lRisultato = new Label("Risultato");
	TextField cNumero1 = new TextField();
	TextField cNumero2 = new TextField();
	Label lRisultatoOp = new Label();
	
    
    public void start(Stage primaryStage) {
    	
    	cNumero1.setPromptText("Primo operando");
    	cNumero2.setPromptText("Secondo operando");
        
        GridPane griglia = new GridPane();
        griglia.add(lNumero1, 0, 0);
        griglia.add(lNumero2, 0, 1);
        griglia.add(cNumero1, 1, 0);
        griglia.add(cNumero2, 1, 1);
        griglia.add(bSomma, 2, 0);
        griglia.add(bSottrazione, 2, 1);
        griglia.add(bMoltiplicazione, 2, 2);
        griglia.add(bDivisione, 2, 3);
        griglia.add(lRisultato, 0, 3);
        griglia.add(lRisultatoOp, 1, 3);
        
        
        Scene Scene = new Scene(griglia, 500, 250);
        
        primaryStage.setTitle("Calcolatrice");
        primaryStage.setScene(Scene);
        primaryStage.show();
        
  	   bSomma.setOnAction(e -> somma());
  	   bSottrazione.setOnAction(e -> sottrazione());
  	   bMoltiplicazione.setOnAction(e -> moltiplicazione());
  	   bDivisione.setOnAction(e -> divisione());
  	   
    }

    private void somma() {
  	   String primoNumero, secondoNumero, risposta;
  	   int numero1, numero2, risultato;
  	   
  	   primoNumero = cNumero1.getText();
  	   secondoNumero = cNumero2.getText();
  	   numero1 = Integer.parseInt(primoNumero);
  	   numero2 = Integer.parseInt(secondoNumero);
  	   risultato = numero1 + numero2;
  	   risposta = "" + risultato;
 	   lRisultatoOp.setText(risposta);
    }
    
    private void sottrazione() {
   	   String primoNumero, secondoNumero, risposta;
   	   int numero1, numero2, risultato;
   	   
   	   primoNumero = cNumero1.getText();
   	   secondoNumero = cNumero2.getText();
   	   numero1 = Integer.parseInt(primoNumero);
   	   numero2 = Integer.parseInt(secondoNumero);
   	   risultato = numero1 - numero2;
   	   risposta = "" +  risultato;
  	   lRisultatoOp.setText(risposta);
     }
    
    private void moltiplicazione() {
    	   String primoNumero, secondoNumero, risposta;
    	   int numero1, numero2, risultato;
    	   
    	   primoNumero = cNumero1.getText();
    	   secondoNumero = cNumero2.getText();
    	   numero1 = Integer.parseInt(primoNumero);
    	   numero2 = Integer.parseInt(secondoNumero);
    	   risultato = numero1 * numero2;
    	   risposta = "" +  risultato;
   	   lRisultatoOp.setText(risposta);
      }
    
    private void divisione() {
    	   String primoNumero, secondoNumero, risposta;
    	   int numero1, numero2, risultato;
    	   
    	   primoNumero = cNumero1.getText();
    	   secondoNumero = cNumero2.getText();
    	   numero1 = Integer.parseInt(primoNumero);
    	   numero2 = Integer.parseInt(secondoNumero);
    	   risultato = numero1 / numero2;
    	   risposta = "" +  risultato;
   	   lRisultatoOp.setText(risposta);
      }

    public static void main(String[] args) {
        launch(args);
    }
    
}
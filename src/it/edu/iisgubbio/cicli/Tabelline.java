package it.edu.iisgubbio.cicli;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Tabelline extends Application{
	
	Label lInput = new Label("Input uno:");
	Label lRisposta = new Label("Se serve, qui comparirà la risposta");
	Button bPremimi = new Button ("Premimi");
	TextField fInput = new TextField ();
	
	public void start(Stage primaryStage) {
		
		GridPane griglia = new GridPane();
		griglia.add(lInput, 0, 0);
		griglia.add(lRisposta, 0, 1, 2, 1);
		griglia.add(bPremimi, 3, 0, 1, 2);
		griglia.add(fInput, 1, 0);
		
		Scene Scene = new Scene(griglia);
		
		Scene.getStylesheets().add("it/edu/iisgubbio/cicli/Tabelline.css");
		
        primaryStage.setTitle("Da completare");
        primaryStage.setScene(Scene);
        primaryStage.show();
        
        bPremimi.setOnAction(e -> risposta());
	}
	
	private void risposta() {
		String output= "";
		int numero;
		numero = Integer.parseInt(fInput.getText());
		int cNumero = numero;
		for (int n = 1; n <= 10;n = n + 1) {
			output =output + ", " + numero;
			numero = numero + cNumero;
			
		}
		lRisposta.setText(output);
	}
	
    public static void main(String[] args) {
        launch(args);
    }

}

package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class RicercheVettore extends Application{
	TextField input;
	Label output;
	TextField fValore;
	

	@Override
	public void start(Stage primaryStage){
		
		input = new TextField();
		fValore = new TextField();
		
		Button bMassimo = new Button("Max");
		Button bMinimo = new Button("Min");
		Button bEsiste = new Button("Esiste");
		Button bPosizione = new Button("Posizione");
		Label lValore = new Label("Valore");
		
		output = new Label();
		

		
		GridPane griglia = new GridPane();
		griglia.add(input, 0, 0, 4, 1);
		griglia.add(bMassimo, 0, 2);
		griglia.add(bMinimo, 1, 2);
		griglia.add(bEsiste, 2, 2);
		griglia.add(bPosizione, 3, 2);
		griglia.add(output, 0, 3, 4, 1);
		griglia.add(lValore, 0, 1);
		griglia.add(fValore, 1, 1, 2, 1);
		
		griglia.setId("griglia");
		
		Scene scene = new Scene(griglia);
		
		scene.getStylesheets().add("it/edu/iisgubbio/css//foglioStile.css");
		
		
		primaryStage.setTitle("Ricerche in vettore");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		bMassimo.setOnAction(e -> trovaMax());
		bMinimo.setOnAction(e -> trovaMin());
		bEsiste.setOnAction(e -> trovaEsiste());
		bPosizione.setOnAction(e -> trovaPos());
	}
	
	int[] daTestoAVettore(String t) {
		String elencoValori = t ;
		String sInput[] = elencoValori.split(" ");
		int iValore[]= new int[sInput.length];
		
		for (int c = 0;c <= sInput.length - 1;c = c + 1) {
			iValore[c]= Integer.parseInt(sInput[c]);
		}
		return iValore;
	}

	private void trovaMax() {
		String elencoValori = input.getText(); ;
		int iValore[] = daTestoAVettore(elencoValori);
		int maggiore = iValore[0];
		
		for (int c = 0;c <= iValore.length - 1;c = c + 1) {
			if (maggiore < iValore[c]) {
				maggiore = iValore[c];
			}
		}
		
		output.setText(maggiore + "" );
	}

	private void trovaMin() {
		String elencoValori = input.getText(); ;
		int iValore[] = daTestoAVettore(elencoValori);
		int minore = 10000000;
		for (int c = 0;c <= iValore.length - 1;c = c + 1) {
			if (minore > iValore[c]) {
				minore = iValore[c];
			}
		}
		
		output.setText(minore + "" );
		
	}

	private void trovaEsiste() {
		String elencoValori = input.getText(); ;
		int iValore[] = daTestoAVettore(elencoValori);
		
		int controllo = Integer.parseInt(fValore.getText());
		boolean esiste = false;
		for (int c = 0;c <= iValore.length - 1;c = c + 1) {
			if (iValore[c] == controllo) {
				esiste = true;
			}
		}
		if (esiste) {
			output.setText("Il valore esiste");
		} else {
			output.setText("Il non valore esiste");
		}
	}

	private void trovaPos() {
		String elencoValori = input.getText(); ;
		int iValore[] = daTestoAVettore(elencoValori);
		
		boolean esiste = false;
		int posto= 0;
		int controllo = Integer.parseInt(fValore.getText());
		for (int c = 0;c <= iValore.length - 1;c = c + 1) {
			if (iValore[c] == controllo) {
				posto = c;
				esiste = true;
			} 

		}
		if (esiste) {
			output.setText("Il valore si trova nella posizione " + (posto + "") );
		} else {
			output.setText("Il valore non se trova");
		}
		
	}
	
	public static void main(String[] args) {
        launch(args);
    }

}

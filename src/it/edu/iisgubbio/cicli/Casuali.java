package it.edu.iisgubbio.cicli;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Casuali extends Application{
	
	Label lPari = new Label ("Pari");
	Label lDispari = new Label ("Dispari");
	Label lSommaPari = new Label ("Somma dei numeri pari");
	Label lSommaDipari = new Label ("Somma dei numeri dispari");
	Label lNumeriPari = new Label ();
	Label lNumeriDispari = new Label ();
	Label lRisultatoPari = new Label ();
	Label lRisultatoDispari = new Label ();
	Label lMaggiorePari;
	Label lMinorePari;
	Label lMaggioreDispari;
	Label lMinoreDispari;
	Label lNumeroMinorePari;
	Label lNumeroMaggiorePari;
	Label lNumeroMinoreDispari;
	Label lNumeroMaggioreDispari;
	Button bGenera = new Button ("Genera");
	
	public void start(Stage primaryStage) {
		lMaggiorePari = new Label ("Maggiore");
		lMinorePari = new Label ("Minore");
		lMaggioreDispari = new Label ("Maggiore");
		lMinoreDispari = new Label ("Minore");
		
		GridPane griglia = new GridPane();
		griglia.add(lPari, 0, 0);
		griglia.add(lDispari, 1, 0);
		griglia.add(lSommaPari, 0, 2);
		griglia.add(lSommaDipari, 1, 2);
		griglia.add(lNumeriPari, 0, 1);
		griglia.add(lNumeriDispari, 1, 1);
		griglia.add(lRisultatoPari, 0, 3);
		griglia.add(lRisultatoDispari, 1, 3);
		griglia.add(bGenera, 0, 8, 2, 1);
		griglia.add(lMinorePari, 0, 4);
		griglia.add(lNumeroMinorePari, 0, 5);
		griglia.add(lMaggiorePari, 0, 6);
		griglia.add(lNumeroMaggiorePari, 0, 7);
		griglia.add(lMinoreDispari, 1, 4);
		
		griglia.add(lMaggioreDispari, 1, 6);
		
		Scene Scene = new Scene(griglia);
		
		Scene.getStylesheets().add("it/edu/iisgubbio/cicli/Tabelline.css");
		griglia.getStyleClass().add("grid-pane");
		
        primaryStage.setTitle("Creazione di numeri casuali");
        primaryStage.setScene(Scene);
        primaryStage.show();
		
        bGenera.setOnAction(e -> generazione());
	}
	
	private void generazione() {
		String contaPari = "",contaDispari = "";
		int sommaPari = 0, sommaDispari = 0;
		for (int c = 0;c != 10;c = c + 1) {
			int caso = (int)(Math.random()*100)+1;
			if (caso % 2 == 0) {
				int minore = 0, maggiore = 0;
				sommaPari = sommaPari + caso;
				contaPari = contaPari + " " + caso;
				if (caso > maggiore) {
					maggiore = caso;
				}
				if (caso < minore) {
					minore = caso;
				}
			} else {
				int dMaggiore = 0, dMinore = 0;
				sommaDispari = sommaDispari + caso;
				contaDispari = contaDispari + " " + caso;
				
				if (caso > dMaggiore) {
					dMaggiore = caso;
				}
				if (caso < dMinore) {
					dMinore = caso;
				}
			}
		}
		lNumeriPari.setText(contaPari);
		lRisultatoPari.setText("" + sommaPari);
		
		
		lNumeriDispari.setText(contaDispari);
		lRisultatoDispari.setText("" + sommaDispari);
	}
	
    public static void main(String[] args) {
        launch(args);
    }

}

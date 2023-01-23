package it.edu.iisgubbio.cicli;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MoltipicaSomme extends Application {
	
	Label lPrimo = new Label ("Primo numero");
	Label lSecondo = new Label ("Secondo numero");
	TextField fPrimo = new TextField ();
	TextField fSecondo = new TextField ();
	Button bCalcola = new Button ("Calcola");
	Label lRisultato = new Label ();
	
	public void start(Stage primaryStage) {
		
		GridPane griglia = new GridPane ();
		griglia.add(lPrimo, 0, 0);
		griglia.add(lSecondo, 2, 0);
		griglia.add(fPrimo, 1, 0);
		griglia.add(fSecondo, 4, 0);
		griglia.add(bCalcola, 1, 1, 2, 1);
		griglia.add(lRisultato, 0, 2, 4, 1);
		
		Scene Scene = new Scene(griglia);
		
		Scene.getStylesheets().add("it/edu/iisgubbio/cicli/Tabelline.css");
		
		griglia.getStyleClass().add("grid-pane");
		bCalcola.getStyleClass().add("button");
		bCalcola.setMaxWidth(4000);
		
        primaryStage.setTitle("Moltiplicazione sapendo solo l'addizione");
        primaryStage.setScene(Scene);
        primaryStage.show();
        
        bCalcola.setOnAction(e -> sommazione());
	}
	
	private void sommazione() {
		int numeroPrimo, numeroSecondo, risultato = 0;
		numeroPrimo = Integer.parseInt(fPrimo.getText());
		numeroSecondo = Integer.parseInt(fSecondo.getText());
		for (int c = 0;c < numeroSecondo;c = c + 1) {
			risultato = risultato + numeroPrimo;
		}
		lRisultato.setText("Il risultato è " + (risultato));
	}
	
    public static void main(String[] args) {
        launch(args);
    }
}


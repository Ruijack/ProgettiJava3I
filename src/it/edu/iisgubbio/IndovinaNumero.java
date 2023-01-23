package it.edu.iisgubbio;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class IndovinaNumero extends Application{
	
	Label lNumero = new Label ("Numero:");
	Label lSuggerimento = new Label ();
	TextField fIndovina = new TextField();
	Button bProva = new Button ("Prova");
	Button bRicomincia = new Button ("Ricomincia");
	
	int jackpot = (int)(Math.random()*100)+1;
	int tentativi = 0;
	
	GridPane griglia = new GridPane();
	Scene Scene = new Scene(griglia);

	public void start(Stage primaryStage) {
		
		griglia.add(lNumero, 0, 0);
		griglia.add(lSuggerimento, 1, 1, 3, 1);
		griglia.add(fIndovina, 1, 0);
		griglia.add(bProva, 2, 0);
		griglia.add(bRicomincia,  0, 1);
		griglia.setPadding(new Insets(5, 5, 5, 5));
		griglia.setHgap(15); 
		griglia.setVgap(10);
		bProva.setMaxWidth(30000);
		
        primaryStage.setTitle("Indovina il numero");
        primaryStage.setScene(Scene);
        primaryStage.show();
		
		bProva.setOnAction(e -> proviamo());
		Scene.getStylesheets().add("it/edu/iisgubbio/IndovinaNumerocss.css");
	}
	
	private void proviamo() {
		
		int numeroIndovina;
		numeroIndovina = Integer.parseInt(fIndovina.getText());
		if (numeroIndovina == jackpot) {
			lSuggerimento.setId("indovinato");
			lSuggerimento.setText("Complimenti hai indovinato! "
					+ " Ci sei riuscito in " + (tentativi) + " tentativi");
		}else {
			if (tentativi >= 5) {
				lSuggerimento.setText("Hai superato i tuoi 10 tentativi. Premi il pulsante ricomincia");
				
			}
			if (numeroIndovina > jackpot) {
				lSuggerimento.setId("errato");
				lSuggerimento.setText("Il tuo numero è maggiore");
				tentativi = tentativi + 1;
			} else {
				lSuggerimento.setId("errato");
				lSuggerimento.setText("Il tuo numero è minore");
				tentativi = tentativi + 1;
			}
		}
	}
	
    public static void main(String[] args) {
        launch(args);
    }

}

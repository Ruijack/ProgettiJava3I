package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;

public class vaschePiscina extends Application{
	
	int vasche[];
	Label lNumero = new Label ("Numero vasche");
	TextField fNumero;
	
	Label lTempo = new Label("Tempo");
	TextField fTempo;
	
	Label lTempoCoach = new Label ("Tempo coach");
	TextField fTempoCoach;
	
	Label Risultato;
	Button bConfronta;
	TextField fVasca;
	Label vasca;
	int slotVasca;
	int tempoCoach;
	
	public void start(Stage primaryStage){
		
		fTempo = new TextField ();
		fTempoCoach = new TextField ();
		fVasca = new TextField ();
		bConfronta = new Button ("Confronta");
		fNumero = new TextField ();
		Risultato = new Label();
		vasca = new Label();
		
		
		GridPane griglia = new GridPane();
		griglia.add(lNumero, 0, 0);
		griglia.add(fNumero,  1, 0);
		griglia.add(lTempo, 0, 1);
		griglia.add(fTempo, 0, 2);
		griglia.add(lTempoCoach, 1, 1);
		griglia.add(fTempoCoach, 1, 2);
		griglia.add(bConfronta, 3, 2);
		griglia.add(Risultato, 0, 3, 3, 1);
		
		//griglia.add(fVasca, 0, 3);
		//griglia.add(vasca, 0, 4, 1, 3);
		
		//fVasca.addEventHandler(KeyEvent., null);
		
		Scene scene = new Scene(griglia);
		
		primaryStage.setTitle("Vasche");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		fTempo.setOnAction(e -> inserisciTempo());
		fNumero.setOnAction(e -> alloca());
		bConfronta.setOnAction(e -> confronti());
		
		
	}
	
	private void alloca () {
		int tutteVasche = Integer.parseInt(fNumero.getText());
		vasche = new int[tutteVasche];
		tempoCoach = Integer.parseInt(fTempoCoach.getText());
		slotVasca = 0;
	}
	
	private void inserisciTempo() {
		int tempo = Integer.parseInt(fTempo.getText());
		if (slotVasca <= vasche.length) {
			vasche[slotVasca] = tempo;
			slotVasca = slotVasca + 1;
		}
		
		
	}

	private void confronti() {
		int tempoCoach = Integer.parseInt(fTempoCoach.getText());
		int tempiLenti = 0 ;
		for (int c = 0; c < vasche.length ;c++) {
			if (tempoCoach < vasche[c]) {
			tempiLenti += 1;
		}
		Risultato.setText("Persone lente " + tempiLenti);
		

		}
		
	}

	public static void main(String[] args) {
        launch(args);
    }

}

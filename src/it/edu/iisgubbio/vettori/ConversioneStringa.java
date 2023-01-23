package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ConversioneStringa extends Application{
	
	TextField fTempi;
	TextField fLimite;
	TextField fSopra;
	Label lRisultato;
	@Override
	public void start(Stage primaryStage) {
		Label lTempi = new Label("Tempi");
		Label lLimite = new Label ("Limite");
		Label lTempiSu = new Label ("Tempi sopra");
		lRisultato = new Label ();
		
		fTempi = new TextField ();
		fLimite = new TextField ();
		fSopra = new TextField ();
		
		Button bCalcola = new Button ("Calcola");
		
		GridPane griglia = new GridPane ();
		griglia.add(lTempi, 0, 0);
		griglia.add(lLimite, 0, 1);
		griglia.add(lTempiSu, 0, 2);
		griglia.add(fTempi, 1, 0, 2, 1);
		griglia.add(fLimite, 1, 1);
		griglia.add(lRisultato, 1, 2, 2, 1);
		griglia.add(bCalcola, 2, 1);
		griglia.setVgap(20);
		griglia.setHgap(40);
		
		Scene scene = new Scene(griglia);
		
		primaryStage.setTitle("Vasche");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		bCalcola.setOnAction(e -> calcolazione());
	}
	
	private void calcolazione() {
		String elencoTempi = fTempi.getText(); ;
		int tempoLimite = Integer.parseInt(fLimite.getText());
		String tempistiche[] = elencoTempi.split(" ");
		int tempi[]= new int[tempistiche.length], tempiSu = 0;
		
		for (int c = 0;c <= tempistiche.length - 1;c = c + 1) {
			tempi[c]= Integer.parseInt(tempistiche[c]);
		}
		
		for (int c = 0; c < tempi.length ;c++) {
			if (tempoLimite <= tempi[c]) {
				tempiSu += 1;
			}
		}
		lRisultato.setText(tempiSu + "");
	}

	public static void main(String[] args) {
        launch(args);
    }

}

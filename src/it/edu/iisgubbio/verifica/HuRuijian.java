package it.edu.iisgubbio.verifica;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class HuRuijian extends Application{
	
	private static final Boolean True = null;
	private static final Boolean False = null;
	TextField fNumeroN;
	TextField fNumeroM;
	Label lRisultato;

	@Override
	public void start(Stage primaryStage){
		Label lNumeroN = new Label("Numero N");
		Label lNumeroM = new Label("Numero M");
		lRisultato = new Label();
		
		fNumeroN = new TextField();
		fNumeroM = new TextField();
		
		Button bSomma = new Button("Somma");
		Button bPrimi = new Button("Primi");
		Button bSemplice = new Button("Disposizione semplice");
		
		
		
		
		GridPane griglia = new GridPane();
		griglia.add(lNumeroN, 0, 0);
		griglia.add(lNumeroM, 2, 0);
		griglia.add(fNumeroN, 0, 1, 2, 1);
		griglia.add(fNumeroM, 2, 1);
		griglia.add(bSomma, 0, 2);
		griglia.add(bPrimi, 1, 2);
		griglia.add(bSemplice, 2, 2, 2, 1);
		griglia.add(lRisultato, 0, 3, 3, 1);
		
		griglia.setId("griglia");
		
		Scene scene = new Scene(griglia);
		
		scene.getStylesheets().add("it/edu/iisgubbio/verifica//HuRuijian.css");
		
		primaryStage.setTitle("Verifica con numeri N e M");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		bSomma.setOnAction(e -> somma());
		bPrimi.setOnAction(e -> primi());
		bSemplice.setOnAction(e -> semplice());
	}
	


	private void somma() {
		int somma = Integer.parseInt(fNumeroN.getText());
		int fine = Integer.parseInt(fNumeroM.getText());
		for (int c = somma + 1;c <= fine;c = c + 1) {
			somma = somma + c;
		}
		lRisultato.setText(somma + "");
	}
		
	private void primi() {
		
		int primo;
		int risultato = 0;
		int primoNumero = Integer.parseInt(fNumeroN.getText());
		int fineNumero = Integer.parseInt(fNumeroM.getText());
		for (int c = primoNumero;c <= fineNumero;c = c +1) {
			primo= 0;
			for (int inizio = 2;inizio< c;inizio = inizio + 1 ) {
				if (c % inizio == 0) {
				primo = 1;
				}
			}
			if (primo == 0) {
				risultato += 1;
			}
			
		}
		lRisultato.setText(risultato + "");
		
	}
	
	private void semplice() {
		int N = Integer.parseInt(fNumeroN.getText()), nSemplice = 1;
		int M = Integer.parseInt(fNumeroM.getText()), metàSemplice = 1;
		int metà = N - M ,d;
		for (int c = 2; c <= N;c = c +1) {
			nSemplice = nSemplice * c;
		}
		for (int c = 2; c <= metà;c = c +1) {
			metàSemplice = metàSemplice * c;
		}
		d = nSemplice/metàSemplice;
		lRisultato.setText(d + "");
		
		
	}
	

	public static void main(String[] args) {
        launch(args);
    }

}

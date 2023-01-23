package it.edu.iisgubbio.geometria;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Sfera extends Application{
	
	Label lRaggio = new Label("Raggio");
	Label lOperazione = new Label ();
	TextField fRaggio = new TextField();
	TextField fRisultato = new TextField();
	Button bVol = new Button ("Vol");
	Button bSup = new Button ("Sup");
	Button bDia = new Button ("Dia");
	
	public void start(Stage primaryStage) {
		
		GridPane griglia = new GridPane();
		griglia.add(lRaggio, 0, 0);
		griglia.add(lOperazione, 0, 2);
		griglia.add(fRaggio, 1, 0, 3, 1);
		griglia.add(fRisultato, 1, 2, 3, 1);
		griglia.add(bVol, 1, 1);
		griglia.add(bSup, 2, 1);
		griglia.add(bDia, 3, 1);
		
		griglia.setHgap(5);
		
        Scene Scene = new Scene(griglia, 500, 250);
		
        primaryStage.setTitle("Triangolo Rettangolo");
        primaryStage.setScene(Scene);
        primaryStage.show();
        
        bVol.setOnAction(e -> tVolume());
        bSup.setOnAction(e -> tSuperficie());
        bDia.setOnAction(e -> tDiametro());
        
        fRaggio.setPromptText("Scrivi qui il raggio");
	}
	
	private void tVolume() {
		String risultato;
		double raggio, volume;
		
		raggio = Double.parseDouble(fRaggio.getText());
		volume = 4 * 3.14 * raggio * raggio * raggio / 3;
		risultato = "" + volume;
		lOperazione.setText("Volume");
		fRisultato.setText(risultato);
	}
	
	private void tSuperficie() {
		String risultato;
		double raggio, superficie;
		
		raggio = Double.parseDouble(fRaggio.getText());
		superficie = 4 * 3.14 * raggio * raggio;
		risultato = "" + superficie;
		lOperazione.setText("superficie");
		fRisultato.setText(risultato);
	}
	
	private void tDiametro() {
		String risultato;
		double raggio, diametro;
		
		raggio = Double.parseDouble(fRaggio.getText());
		diametro = 2 * 3.14 * raggio;
		risultato = "" + diametro;
		lOperazione.setText("Diametro");
		fRisultato.setText(risultato);
	}
	
	
	
	
	public static void main(String[] args) {
        launch(args);
    }
}

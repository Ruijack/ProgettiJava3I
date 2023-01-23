package it.edu.iisgubbio.cicli;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CentoCasuali extends Application{
	
	Label lOutput ;
	Button bGenera = new Button ("Genera");
	TextField fInput ;
	
	public void start(Stage primaryStage) {
		
		GridPane griglia = new GridPane();
		griglia.add(fInput, 0, 0, 3, 1);
		griglia.add(bGenera, 1, 1, 2, 1);
		griglia.add(lOutput, 1, 2, 2, 1);
		
		Scene Scene = new Scene(griglia);
		
		Scene.getStylesheets().add("it/edu/iisgubbio/cicli/Tabelline.css");
		griglia.getStyleClass().add("grid-pane");
		
        primaryStage.setTitle("Creazione di cento numeri casuali");
        primaryStage.setScene(Scene);
        primaryStage.show();
		
        bGenera.setOnAction(e -> generazione());
	}
	
	private void generazione() {
		String contaPari = "",contaDispari = "";
		int sommaPari = 0, sommaDispari = 0;
		for (int c = 0;c != 100;c = c + 1) {
			int caso = (int)(Math.random()*100)+1;
			

			}
		}
	
    public static void main(String[] args) {
        launch(args);
    }

}

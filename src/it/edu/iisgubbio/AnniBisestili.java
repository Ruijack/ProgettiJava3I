package it.edu.iisgubbio;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AnniBisestili extends Application {
	
	Label lAnno = new Label ("Anno");
	Label lRisultato = new Label ();
	TextField fAnno = new TextField ();
	Button bBisestile = new Button ("è bisestile?");
	
	public void start(Stage primaryStage) {
		
		GridPane griglia = new GridPane();
		griglia.add(lAnno, 0, 0);
		griglia.add(fAnno, 1, 0);
		griglia.add(bBisestile, 1, 1);
		griglia.add(lRisultato, 0, 2, 3, 1);
		
		fAnno.setPromptText("Inserisci l'anno");
		
        Scene Scene = new Scene(griglia);
        
		Scene.getStylesheets().add("it/edu/iisgubbio/IndovinaNumerocss.css");
        
        primaryStage.setTitle("Rettangolo");
        primaryStage.setScene(Scene);
        primaryStage.show();
		
        bBisestile.setOnAction(e -> calcolo());
	}
	
	private void calcolo() {
		double anno;
		anno = Double.parseDouble(fAnno.getText());
		if (anno % 4 == 0 && anno % 100 != 0 || anno % 400 == 0) {
			lRisultato.setText("L'anno inserito è bisestile");
		} else {
			lRisultato.setText("L'anno inserito non è bisestile");
		}
		/*if (anno % 4 == 0 ) {
			if (anno % 100 == 0) {
				if (anno % 400 == 0) {
					lRisultato.setText("L'anno inserito è bisestile");
				} else {
					lRisultato.setText("L'anno inserito non è bisestile");
				}
			} else {
				lRisultato.setText("L'anno inserito è bisestile");
			}
		} else {
			lRisultato.setText("L'anno inserito non è bisestile");
		}*/
	}
	
    public static void main(String[] args) {
        launch(args);
    }
}

package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Caselle extends Application{
	
	TextField[] fCaselle = new TextField[10];
	


	@Override
	public void start(Stage primaryStage)  {
		
		Button bBottone = new Button ("Scorri");
		
		GridPane griglia = new GridPane(); 
		griglia.add(bBottone, 0, fCaselle.length);
		griglia.setHgap(10);
		griglia.setVgap(10);
		
			for (int i = 0 ; i<fCaselle.length; i ++) {
		fCaselle[i] = new TextField();
		griglia.add(fCaselle[i], 0, i);
	}
		
		
		
		
		Scene scene = new Scene(griglia);
		
		primaryStage.setTitle("Caselle TextField");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		bBottone.setOnAction(e -> scorrimento());
	}
	
	private void scorrimento() {
		for (int c = 0;c < fCaselle.length - 1;c = c + 1) {
			fCaselle[c ].setText(fCaselle[c + 1].getText());
			
		}
		fCaselle[fCaselle.length - 1].setText("");
		
	}

	public static void main(String[] args) {
        launch(args);
    }

}



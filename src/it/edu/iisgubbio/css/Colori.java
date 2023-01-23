package it.edu.iisgubbio.css;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Colori extends Application{
	
	Button bPavimento = new Button ("avimento");
	Button bPareti = new Button ("pareti");
	Button bCosto = new Button ("costo");
	Label lLarghezza = new Label ("larghezza");
	Label lProfondità = new Label ("profondità");
	Label lAltezza = new Label ("altezza");
	TextField fPavimento= new TextField ();
	TextField fPareti= new TextField ();
	TextField fCosto = new TextField ();
	
	public void start(Stage primaryStage) {
		
		GridPane griglia = new GridPane ();
		griglia.add(bPavimento, 0, 0);
		griglia.add(bPareti, 1, 0);
		griglia.add(bCosto, 2, 0);
		griglia.add(lLarghezza, 0, 1);
		griglia.add(lProfondità, 1, 1);
		griglia.add(lAltezza, 2, 1);
		griglia.add(fPavimento, 0, 2);
		griglia.add(fPareti, 1, 2);
		griglia.add(fCosto, 2, 2);
		
		Scene Scene = new Scene(griglia, 500, 250);
		
		Scene.getStylesheets().add("it.edu.iisgubbio.css/Coloricss.css");
		
        primaryStage.setTitle("allineamento");
        primaryStage.setScene(Scene);
        primaryStage.show();
		
	}
	
    public static void main(String[] args) {
        launch(args);
    }

}

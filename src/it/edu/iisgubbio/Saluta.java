package it.edu.iisgubbio;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Saluta extends Application {
    
    Label messaggio = new Label("Chi sei?"); 
    TextField nome = new TextField();
    
    public void start(Stage primaryStage) {

        Label scriviNome = new Label("Studente:");
        Button eseguiSaluto = new Button("Esegui saluto");
 
        nome.setPromptText("Scrivi il tuo nome");
        eseguiSaluto.setOnAction(e -> saluta() );
        
        GridPane griglia = new GridPane();
        griglia.add(scriviNome, 0, 0);
        griglia.add(nome, 1, 0);
        griglia.add(eseguiSaluto, 1, 1);
        griglia.add(messaggio, 1, 2);
        
        Scene scene = new Scene(griglia, 500, 250);
        
        primaryStage.setTitle("Saluta");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public void saluta() {
        String utente;
        utente = nome.getText();
        messaggio.setText("Ciao sono " + utente); 
    }
    
}
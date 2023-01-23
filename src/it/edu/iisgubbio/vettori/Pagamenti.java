package it.edu.iisgubbio.vettori;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Pagamenti extends Application{

	@Override
	public void start(Stage primaryStage) {
		Label lNumPagamenti = new Label ("Numero pagamenti: ");
		Label lPagamento = new Label ("Pagamento");
		Label lSomma = new Label ();
		TextField fNumPagamenti = new TextField ();
		TextField fPagamento = new TextField ();
		Button bVia = new Button ("Via");
		Button bAggiungi = new Button ("Aggiungi");
		Button bSomma = new Button ("Somma");
		
		GridPane griglia = new GridPane ();
		griglia.add(lNumPagamenti, 0, 0);
		griglia.add(fNumPagamenti, 1, 0);
		griglia.add(bVia, 2, 0);
		griglia.add(lPagamento, 0, 1);
		griglia.add(fPagamento, 1, 1);
		griglia.add(bAggiungi, 2, 1);
		griglia.add(bSomma, 0, 2);
		griglia.add(lSomma, 1, 2, 2, 1);
		
		Scene scene = new Scene(griglia);
		
		primaryStage.setTitle("Pagamenti carta");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
        launch(args);
    }

}

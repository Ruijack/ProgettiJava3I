package it.edu.iisgubbio.fxml;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class EsempioFxml extends Application{
	
	@FXML Label output ;
	@FXML TextField input;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Scene scena = new Scene( FXMLLoader.load(EsempioFXML.class.getResource("EsempioFXML.fxml")) );
        primaryStage.setTitle("Rettangolo");
        primaryStage.setScene(scena);
        primaryStage.show();
	}
	
	@FXML private void copia() {
		output.setText(input.getText());
	}
	
	public static void main(String args[]){
		launch(args);
	}
	

}

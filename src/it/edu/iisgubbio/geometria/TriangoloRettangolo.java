package it.edu.iisgubbio.geometria;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TriangoloRettangolo extends Application{
	
	Label lCMinore = new Label("Cateto Minore");
	Label lCMaggiore = new Label("Cateto Maggiore");
	Label lIpotenusa = new Label("Ipotenusa");
	TextField  fMinore = new TextField();
	TextField fMaggiore = new TextField();
	TextField fIpotenusa = new TextField();
	Button bMin = new Button("Min");
	Button bMag = new Button("Mag");
	Button bIpo = new Button("Ipo");
	
	public void start(Stage primaryStage) {
		
		GridPane griglia = new GridPane();
		griglia.add(lCMinore, 0, 0);
		griglia.add(lCMaggiore, 0, 1);
		griglia.add(lIpotenusa, 0, 2);
		griglia.add(fMinore, 1, 0);
		griglia.add(fMaggiore, 1, 1);
		griglia.add(fIpotenusa, 1, 2);
		griglia.add(bMin, 2, 0);
		griglia.add(bMag, 2, 1);
		griglia.add(bIpo, 2, 2);
		
        Scene Scene = new Scene(griglia, 500, 250);
		
        primaryStage.setTitle("Triangolo Rettangolo");
        primaryStage.setScene(Scene);
        primaryStage.show();
        
        bMin.setOnAction(e -> tMinore());
        bMag.setOnAction(e -> tMaggiore());
        bIpo.setOnAction(e -> tIpotenusa());
        
        fMinore.setPromptText("Scrivi il cateto");
        fMaggiore.setPromptText("Scrivi il cateto");
        fIpotenusa.setPromptText("Scrivi l'ipotenusa");

		
		
		
	}
	
	private void tMinore() {
		String unoNumero,dueNumero, risposta;
		double catetoMinore, catetoMaggiore, ipotenusa;
		
		unoNumero = fIpotenusa.getText();
		dueNumero = fMaggiore.getText();
	  	ipotenusa = Double.parseDouble(unoNumero);
	  	catetoMaggiore = Double.parseDouble(dueNumero);
	  	catetoMinore = Math.sqrt(ipotenusa * ipotenusa - catetoMaggiore * catetoMaggiore);
	  	risposta = "" + catetoMinore;
	  	fMinore.setText(risposta);
	}
	
	private void tMaggiore() {
		String unoNumero,dueNumero, risposta;
		double catetoMinore, catetoMaggiore, ipotenusa;
		
		unoNumero = fIpotenusa.getText();
		dueNumero = fMinore.getText();
	  	ipotenusa = Double.parseDouble(unoNumero);
	  	catetoMinore = Double.parseDouble(dueNumero);
	  	catetoMaggiore = Math.sqrt(ipotenusa * ipotenusa - catetoMinore * catetoMinore);
	  	risposta = "" + catetoMaggiore;
	  	fMaggiore.setText(risposta);
		
	}
	
	private void tIpotenusa() {
		String unoNumero,dueNumero, risposta;
		double catetoMinore, catetoMaggiore, ipotenusa;
		
		unoNumero = fMinore.getText();
		dueNumero = fMaggiore.getText();
	  	catetoMinore = Double.parseDouble(unoNumero);
	  	catetoMaggiore = Double.parseDouble(dueNumero);
	  	ipotenusa = Math.sqrt(catetoMinore * catetoMinore + catetoMaggiore * catetoMaggiore);
	  	risposta = "" + ipotenusa;
	  	fIpotenusa.setText(risposta);
		
	}
	
	public static void main(String[] args) {
        launch(args);
    }

}

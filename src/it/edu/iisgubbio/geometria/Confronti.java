package it.edu.iisgubbio.geometria;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Confronti extends Application{
	
	Label lTriangolo = new Label("Triangolo");
	Label lRettangolo = new Label("Rettangolo");
	Label lBase = new Label("Base");
	Label lAltezza = new Label("Altezza");
	Label lConfronti = new Label();
	TextField fBaseTriangolo = new TextField ();
	TextField fAltezzaTriangolo = new TextField ();
	TextField fBaseRettangolo = new TextField ();
	TextField fAltezzaRettangolo = new TextField ();
	Button bConfronti = new Button ("Confronta");
	
	public void start(Stage primaryStage) {
		
		GridPane griglia = new GridPane ();
		griglia.add(lTriangolo, 1, 0);
		griglia.add(lRettangolo, 2, 0);
		griglia.add(lBase, 0, 1);
		griglia.add(lAltezza, 0, 2);
		griglia.add(lConfronti, 1, 4, 2, 1);
		griglia.add(fBaseTriangolo, 1, 1);
		griglia.add(fAltezzaTriangolo, 1, 2);
		griglia.add(fBaseRettangolo, 2, 1);
		griglia.add(fAltezzaRettangolo, 2, 2);
		griglia.add(bConfronti, 1, 3, 2, 1);
		griglia.setPadding(new Insets(5, 5, 5, 5));
		griglia.setHgap(15); 
		griglia.setVgap(10);
		bConfronti.setMaxWidth(30000);
		
		Scene Scene = new Scene(griglia, 500, 250);
		
        primaryStage.setTitle("Confronti");
        primaryStage.setScene(Scene);
        primaryStage.show();
        
        bConfronti.setOnAction(e -> Confrontazione());
	}
	
	private void Confrontazione() {
		String differenza;
		double baseTri, altezzaTri, baseRett, altezzaRett, areaTri, areaRett;
		
	 	   baseTri = Integer.parseInt(fBaseTriangolo.getText());
	 	   altezzaTri = Integer.parseInt(fAltezzaTriangolo.getText());
	 	   baseRett = Integer.parseInt(fBaseRettangolo.getText());
	 	   altezzaRett = Integer.parseInt(fAltezzaRettangolo.getText());
	 	   areaTri = baseTri * altezzaTri / 2;
	 	   areaRett = baseRett * altezzaRett;
	 	   if (areaTri>areaRett) {
	 		   differenza = "" + ( areaTri - areaRett );
	 		   lConfronti.setText("L'area del triangolo è maggiore di quella del rettangolo di "+ (differenza));
	 	   } else {
	 		   differenza = "" + (areaRett - areaTri);
	 		   lConfronti.setText("L'area del rettangolo è maggiore di quella del triangolo di "+ (differenza));
	 	   }
	}
	
    public static void main(String[] args) {
        launch(args);
    }
}

package it.edu.iisgubbio.negozi;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.CheckBox;

public class Panini extends Application{
	
	Label lNumeroPanini = new Label ("Numero panini");
	Label lCostoPanini = new Label ("Costo panini");
	Label lSconto = new Label ("Sconto:");
	Button bTotale = new Button ("Totale");
	Label lRisultato = new Label ();
	TextField fNumeroPanini = new TextField ();
	TextField fCostoPanini = new TextField ();
	RadioButton rNullo = new RadioButton ("Nessuno sconto");
	RadioButton rSconto = new RadioButton ("Applica 10%");
	RadioButton rMegaSconto = new RadioButton ("Applica sconto di 25%");
	
	public void start(Stage primaryStage) {
		
		ToggleGroup Sconti = new ToggleGroup();
		rNullo.setToggleGroup(Sconti);
		rSconto.setToggleGroup(Sconti);
		rMegaSconto.setToggleGroup(Sconti);
		rNullo.setSelected(true);
		
		fNumeroPanini.setPromptText("Quanti panini vuoi?");
		fCostoPanini.setPromptText("Quanto costano i panini?");
		
		GridPane griglia = new GridPane();
		griglia.add(lNumeroPanini, 0, 0);
		griglia.add(lCostoPanini, 0, 1);
		griglia.add(lSconto, 0, 2);
		griglia.add(bTotale, 0, 5);
		griglia.add(lRisultato, 1, 5);
		griglia.add(fNumeroPanini, 1, 0);
		griglia.add(fCostoPanini, 1, 1);
		griglia.add(rNullo, 1, 2);
		griglia.add(rSconto, 1, 3);
		griglia.add(rMegaSconto, 1, 4);
		griglia.setPadding(new Insets(5, 5, 5, 5));
		griglia.setHgap(15); 
		griglia.setVgap(20);
		
		
		Scene Scene = new Scene(griglia, 500, 250);
		
        primaryStage.setTitle("Negozio panini");
        primaryStage.setScene(Scene);
        primaryStage.show();
        
        bTotale.setOnAction(e -> Totale());
	}
	
	private void Totale()	{
		String totale;
		int nPanini;
		double nCosto, importo;
		
 	   nPanini = Integer.parseInt(fNumeroPanini.getText());
	   nCosto = Double.parseDouble(fCostoPanini.getText());
	   if (rSconto.isSelected()) {
		   importo = (nPanini * nCosto)-(nPanini * nCosto)/100*10;
		   totale = "" + importo;
		   lRisultato.setText(totale);
	   } else {
		   if (rMegaSconto.isSelected()) {
			   importo = (nPanini * nCosto)-(nPanini * nCosto)/100*25;
			   totale = "" + importo;
			   lRisultato.setText(totale);
		   } else {
			   importo = nPanini * nCosto;
			   totale = "" + importo;
			   lRisultato.setText(totale);
		   }
	   }
	}
	
    public static void main(String[] args) {
        launch(args);
    }

}

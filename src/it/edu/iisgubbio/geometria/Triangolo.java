package it.edu.iisgubbio.geometria;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Triangolo extends Application{
	
	Label lPrimoLato = new Label("Lato1: ");
	Label lSecondoLato = new Label("Lato2: ");
	Label lTerzoLato = new Label("Lato3: ");
	TextField fLato1 = new TextField ();
	TextField fLato2 = new TextField ();
	TextField fLato3 = new TextField ();
	Button bTipoTriangolo = new Button ("Tipo di triangolo");
	Label lRisultato = new Label ();
	
	public void start(Stage primaryStage) {
		
		GridPane griglia = new GridPane();
		griglia.add(lPrimoLato, 0, 0);
		griglia.add(lSecondoLato, 0, 1);
		griglia.add(lTerzoLato, 0, 2);
		griglia.add(fLato1, 1, 0);
		griglia.add(fLato2, 1, 1);
		griglia.add(fLato3, 1, 2);
		griglia.add(bTipoTriangolo, 1, 3, 2, 1);
		griglia.add(lRisultato, 0, 4, 2, 1);
		
		Scene Scene = new Scene(griglia);
		
        primaryStage.setTitle("Che tipo di triangolo è?");
        primaryStage.setScene(Scene);
        primaryStage.show();
        
        bTipoTriangolo.setOnAction(e -> controlla());
		Scene.getStylesheets().add("it/edu/iisgubbio/geometria/triangoloCss.css");
	}
	
	private void controlla() {
		int lato1, lato2, lato3, somma, ipotenusaSeconda;
		lato1 = Integer.parseInt(fLato1.getText());
		lato2 = Integer.parseInt(fLato2.getText());
		lato3 = Integer.parseInt(fLato3.getText());	
			
		if (lato1 == lato2 && lato1==lato3) {
			lRisultato.setText("I lati costituiscono un triangolo equilatero");
		} else {
			if (lato1 > lato2 && lato1 > lato3) {
				somma = lato2 + lato3;
				if (somma > lato1) {
					if (lato2 == lato3) {
						lRisultato.setText("I lati costituiscono un triangolo isoscele");
					} else {
						lRisultato.setText("I lati costituiscono un triangolo scaleno");
					}
				} else {
					lRisultato.setText("I numeri che hai inserito non fanno un triangolo");
				}
			} else {
				if (lato2 > lato1 && lato2 > lato3) {
					somma = lato1 + lato3;
					if (somma > lato2) {
						if (lato1 == lato3) {
							lRisultato.setText("I lati costituiscono un triangolo isoscele");
						} else {
							lRisultato.setText("I lati costituiscono un triangolo scaleno");
						}
					} else {
						lRisultato.setText("I numeri che hai inserito non fanno un triangolo");
					}
				} else {
					if (lato3 > lato1 && lato3 > lato2) {
						somma = lato1 + lato2;
						if (somma > lato3) {
							if (lato1 == lato2) {
								lRisultato.setText("I lati costituiscono un triangolo isoscele");
							} else {
								lRisultato.setText("I lati costituiscono un triangolo scaleno");
							}
						} else {
							lRisultato.setText("I numeri che hai inserito non fanno un triangolo");
						}
					}
				}
			}
		}
		
		if (lato1 != lato2 && lato1 != lato3 && lato2 != lato3) {
			
		if (lato1 > lato2 && lato1 > lato3) {
			somma = lato2 * lato2 + lato3 * lato3;
			ipotenusaSeconda = lato1 * lato1;
			if (somma == ipotenusaSeconda) {
				lRisultato.setText("I lati costituiscono un triangolo rettangolo scaleno");
			} else {
				lRisultato.setText("I lati costituiscono un triangolo scaleno");
			}
		} else {
			if (lato2 > lato1 && lato2 > lato3) {
				somma = lato1 * lato1 + lato3 * lato3;
				ipotenusaSeconda = lato2 * lato2;
				if (somma == ipotenusaSeconda) {
					lRisultato.setText("I lati costituiscono un triangolo rettangolo scaleno");
				} else {
					lRisultato.setText("I lati costituiscono un triangolo scaleno");
				}
			} else {
					somma = lato1 * lato1 + lato2 * lato2;
					ipotenusaSeconda = lato3 * lato3;
					if (somma == ipotenusaSeconda) {
						lRisultato.setText("I lati costituiscono un triangolo rettangolo scaleno");
					} else {
						lRisultato.setText("I lati costituiscono un triangolo scaleno");
					}
				}
			}
		}
		
	}
	
    public static void main(String[] args) {
        launch(args);
    }

}

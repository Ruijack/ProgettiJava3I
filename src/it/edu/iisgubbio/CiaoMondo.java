package it.edu.iisgubbio;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * La mia prima classe
 */
public class CiaoMondo extends Application {

  Button pSaluto = new Button(); 
  Button pPluto = new Button();
  Button p3i = new Button();
  Button pInfo = new Button();
  Label l3I4 = new Label();
  Label lciao = new Label();
  Label lSaluta = new Label();
  

  public void start(Stage finestra) {
    pSaluto.setText("Saluta!");
    pPluto.setText("Pluto");
    p3i.setText("3i");
    pInfo.setText("Info");
    l3I4.setText("3I4");
    lciao.setText("ciao");
    pSaluto.setOnAction(e -> esegui());
    

    GridPane principale = new GridPane();
    principale.add(pSaluto, 0, 0);
    principale.add(pPluto, 1, 1);
    principale.add(p3i, 2, 0);
    principale.add(pInfo, 2, 1);
    principale.add(l3I4, 1, 0);
    principale.add(lciao, 0, 1);

    Scene scena = new Scene(principale);

    finestra.setTitle("Hello World!");
    finestra.setScene(scena);
    finestra.show();
  }

  private void esegui(){
    pSaluto.setText("Ciao Mondo!");
  }

  public static void main(String[] args) {
    launch(args);
  }
}
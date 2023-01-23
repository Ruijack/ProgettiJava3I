package it.edu.iisgubbio.canves;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.effect.Blend;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.effect.Light;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Tela extends Application {
	
    // creiamo un pannello specificando larghezza e altezza
    Canvas quadro = new Canvas(300, 260);
    // otteniamo l'oggetto che ci permette di disegnare
    GraphicsContext gc = quadro.getGraphicsContext2D();

  @Override
  public void start(Stage primaryStage) {
	  
	Button bBlur = new Button("Blur");
	Button bBlend = new Button("Blend");
	Button bGlow = new Button("Glow");
		
    gc.setFill(Color.YELLOW);
    gc.setLineWidth(1);
    gc.fillOval(50, 50, 200, 200);
    gc.setFill(Color.BLACK);
    gc.fillOval(100, 100, 20, 20);
    gc.fillOval(180, 100, 20, 20);
    gc.setStroke(Color.RED);
    gc.setLineWidth(8);
    gc.strokeLine(100, 200, 150, 180);
    gc.strokeLine(150, 180, 200, 200);

    GridPane root = new GridPane();
    // inseriamo il nostro canvas nella finestra
    root.add(quadro, 0, 0);
    root.add(bBlur, 0, 1);
    root.add(bBlend, 1, 1);

    Scene scene = new Scene(root);
    primaryStage.setTitle("Hello Canvas!");
    primaryStage.setScene(scene);
    primaryStage.show();
    
    bBlur.setOnAction( e -> clickEffetto() );
    bBlend.setOnAction( e -> clickBlenda() );
    bBlend.setOnAction( e -> clickGlow() );
  }
  

public void clickEffetto(){
    gc.applyEffect(new GaussianBlur(20));
}

public void clickBlenda(){
    gc.applyEffect(new Blend());
}

public void clickGlow(){
    gc.applyEffect(new Glow());
}

  public static void main(String[] args) {
    launch(args);
  }
}
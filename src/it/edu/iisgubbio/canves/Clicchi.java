package it.edu.iisgubbio.canves;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Clicchi extends Application{
	
	Canvas quadro;
	GraphicsContext gc;
	
	  public void start(Stage primaryStage) {
		  
		  quadro = new Canvas (799, 799);
		  gc = quadro.getGraphicsContext2D();
		  quadro.addEventHandler(MouseEvent.MOUSE_DRAGGED, click ->sinistro(click));
		  quadro.addEventHandler(MouseEvent.MOUSE_DRAGGED, click ->destro(click));
		  quadro.addEventHandler(MouseEvent.MOUSE_DRAGGED, click ->shift(click));
		  quadro.addEventHandler(MouseEvent.MOUSE_DRAGGED, click ->command(click));
		  quadro.addEventHandler(MouseEvent.MOUSE_DRAGGED, click ->cancella(click));
		  
		  GridPane griglia = new GridPane();
		  griglia.add(quadro, 0, 0);
		  
		  Scene scene = new Scene(griglia);
		  primaryStage.setTitle("Clicca come vuoi");
		  primaryStage.setScene(scene);
		  primaryStage.show();
		  
	  }
	  
	private void sinistro(MouseEvent click) {
		  if (click.getButton()== MouseButton.PRIMARY) {
			  gc.setFill(Color.RED);
			  gc.fillOval(click.getX()-5, click.getY()-5, 10, 10);
		  }
	}

	private void destro(MouseEvent click) {
		  if (click.getButton()== MouseButton.SECONDARY) {
			  gc.setFill(Color.YELLOW);
			  gc.fillOval(click.getX()-5, click.getY()-5, 10, 10);
		  }
	}
	
	  private void shift(MouseEvent click) {
		  if (click.isAltDown()) {
			  gc.setFill(Color.BLUE);
			  gc.fillOval(click.getX()-5, click.getY()-5, 10, 10);
		  }
	}
	  
	  private void command(MouseEvent click) {
		  if (click.isShiftDown()) {
			  gc.setFill(Color.GREEN);
			  gc.fillOval(click.getX()-5, click.getY()-5, 10, 10);
		  }
	}
	  
	  private void cancella(MouseEvent click) {
		  if (click.isAltDown()) {
			  gc.clearRect(click, click, 0, 0);
		  }
	}
	  
	public static void main(String[] args) {
		    launch(args);
		  }

}

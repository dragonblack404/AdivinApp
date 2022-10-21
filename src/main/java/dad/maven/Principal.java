package dad.maven;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Principal extends Application{

	private Label mensaje;
	private Button comprobarButton;
	private TextField palabraText;
	int aleatorio = (int) (Math.random() * 100) + 1, intentos = 0;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		palabraText = new TextField();
		palabraText.setPromptText("Esperando número");
		palabraText.setMaxWidth(150);
		
		comprobarButton = new Button("Comprobar");
		comprobarButton.setDefaultButton(true);
		comprobarButton.setOnAction(e -> onVerificarButtonAction(e));
		
		mensaje = new Label("Introduce un número entre 1 y 100");
		mensaje.setWrapText(true);
		
		VBox root = new VBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(mensaje, palabraText, comprobarButton);
		
		Scene scene = new Scene(root, 320, 200);
		
		primaryStage.setTitle("AdivinApp");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	private void onVerificarButtonAction(ActionEvent e) {
		
		String numeroLetra = palabraText.getText();
		
		try {
			int numero = Integer.parseInt(numeroLetra);
			if(numero==aleatorio) {
				intentos++;
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("AdivinApp");
				alert.setHeaderText("¡Has ganado!");
				alert.setContentText("Sólo has necesitado "+intentos+" intentos\nVuelve a jugar y hazlo mejor.");

				alert.showAndWait();
				
			}else if(numero<aleatorio) {
				intentos++;
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("AdivinApp");
				alert.setHeaderText("¡Has fallado!");
				alert.setContentText("El número a adivinar es mayor que "+numero);
				
				alert.showAndWait();
			}else if (numero>aleatorio){
				intentos++;
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("AdivinApp");
				alert.setHeaderText("¡Has fallado!");
				alert.setContentText("El número a adivinar es menor que "+numero);
				
				alert.showAndWait();
			}else{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("AdivinApp");
				alert.setHeaderText("Algo ha fallado");
				alert.setContentText("El número introducido no es válido, verifica los rangos.");

				alert.showAndWait();
			}
				
		} catch (NumberFormatException error){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("AdivinApp");
			alert.setHeaderText("Error");
			alert.setContentText("No has introducido un número.");

			alert.showAndWait();
		}
	
	}
	
//	public static void main(String[] args) {
//		launch(args);
//
//	}
}
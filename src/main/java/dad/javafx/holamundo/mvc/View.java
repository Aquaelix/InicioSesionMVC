package dad.javafx.holamundo.mvc;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class View extends VBox {

	private TextField userText;
	private PasswordField passwordText;
	private Button accederButton;
	private Button cancelarButton;
	
	public View() {
		super();
		
		userText = new TextField();
		userText.setPromptText("Usuario: ");
		userText.setMaxWidth(100);
		
		passwordText = new PasswordField();
		passwordText.setPromptText("Contraseña: ");
		passwordText.setMaxWidth(100);
		
		accederButton = new Button("Acceder");
		accederButton.setDefaultButton(true);
		
		cancelarButton = new Button("Cancelar");
		cancelarButton.setDefaultButton(false);
		
		GridPane root = new GridPane();
		root.setAlignment(Pos.CENTER);
		root.setPadding(new Insets(5));
		root.setHgap(5);
		root.setVgap(5);
		//root.setGridLinesVisible(true);		//Permite ponerle linea a modo de tabla
		root.addRow(0, new Label("Usuario"), userText);
		root.addRow(1, new Label("Contraseña"), passwordText);
		root.addRow(2, accederButton, cancelarButton);
		
		
		this.setSpacing(5);
		this.setAlignment(Pos.CENTER);
		this.getChildren().add(root);
		
	}

	public TextField getUserText() {
		return userText;
	}

	public PasswordField getPasswordText() {
		return passwordText;
	}

	public Button getAccederButton() {
		return accederButton;
	}
	
	public Button getCancelarButton() {
		return cancelarButton;
	}
	
}

package dad.javafx.holamundo.mvc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.codec.digest.DigestUtils;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Controller {

	private Model model = new Model();
	private View root = new View();
	
	public Controller() {
		
		root.getAccederButton().setOnAction(e -> onAccederAction(e));
		
		root.getCancelarButton().setOnAction(e -> onCancelarAction(e));
		
	}

	private void onAccederAction(ActionEvent e) {
		String passMd5, userMd5, cadena;
		String usuario = root.getUserText().getText();
		String password = root.getPasswordText().getText();
		
		boolean encontrado=false;
		
		password = DigestUtils.md5Hex(password).toUpperCase();
		
		try {
			BufferedReader lectura = new BufferedReader(new FileReader("users.csv"));
			while((cadena = lectura.readLine())!=null) {
		
				String[] parts = cadena.split(",");
				userMd5 = parts[0];
				passMd5 = parts[1];
				
				if(userMd5.equals(usuario) && passMd5.equals(password)) {
					encontrado=true;
				}
	        }
			
			if(encontrado) {
				Alert acceso = new Alert(AlertType.INFORMATION);
				acceso.setHeaderText("Acceso permitido");
				acceso.setContentText("Las credenciales de acceso son válidas.");
				
				acceso.showAndWait();
				
			}else {
				
				Alert error = new Alert(AlertType.ERROR);
				error.setHeaderText("Acceso denegado");
				error.setContentText("El usuario y/o la contraseña no son válidos.");
				
				error.showAndWait();
				
			}
			
			
			lectura.close();
				
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	}

	private void onCancelarAction(ActionEvent e) {
		System.exit(0);
	}
	
	public View getRoot() {
		return root;
	}
	
}

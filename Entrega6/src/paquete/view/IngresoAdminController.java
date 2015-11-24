package paquete.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import paquete.MainApp;
import paquete.Serializador;
import paquete.model.Alumno;

public class IngresoAdminController {

    // Reference to the main application.
    private MainApp mainApp;

    public IngresoAdminController() {
    }

    @FXML
    private void initialize() {
    }
    @FXML
    public TextField TextoRut;
    @FXML
    public PasswordField TextoContraseña;
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    @FXML
    private void handleIngresarAction(ActionEvent event) {
    	try {
    		if (MainApp.texto.verificarExistencia(TextoRut.getText() + ".bina")){
    			MainApp.accesoAdmin(TextoRut.getText());
        		if (MainApp.verificador.contraseñaCorrectaAdmin(MainApp.admin, TextoContraseña.getText())){
        			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MenuAdmin.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root1));  
                    stage.setTitle("Menú Administrador");
                    stage.show();
                    ((Node)(event.getSource())).getScene().getWindow().hide();
        		}
        		else {
        			Alert alert = new Alert(AlertType.WARNING);
        			alert.setTitle("Alerta");
        			alert.setHeaderText(null);
        			alert.setContentText("Clave incorrecta");
        			alert.showAndWait();
        			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("IngresoAdmin.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root1));  
                    stage.setTitle("Ingreso Administrador");
                    stage.show();
                    ((Node)(event.getSource())).getScene().getWindow().hide();
        		}
    		}
    		else {
    			Alert alert = new Alert(AlertType.WARNING);
    			alert.setTitle("Alerta");
    			alert.setHeaderText(null);
    			alert.setContentText("Usuario y/o clave incorrecta");
    			alert.showAndWait();
    			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("IngresoAdmin.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));  
                stage.setTitle("Ingreso Administrador");
                stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
    		}
    			
        } 
    	catch(Exception e) {
        e.printStackTrace();
    	}
    }
}
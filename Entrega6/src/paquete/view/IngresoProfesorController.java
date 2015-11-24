package paquete.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import paquete.MainApp;
import paquete.Serializador;
import paquete.model.Alumno;

public class IngresoProfesorController {

    // Reference to the main application.
    private MainApp mainApp;

    public IngresoProfesorController() {
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
    		if(MainApp.texto.verificarExistencia(TextoRut.getText()+".bin")){
    			MainApp.accesoAlumno(TextoRut.getText());
        		if (MainApp.verificador.contraseñaCorrectaAlumno(MainApp.alumno, TextoContraseña.getText())){
        			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MenuProfesor.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root1));  
                    stage.setTitle("Menú Profesor");
                    stage.show();
                    ((Node)(event.getSource())).getScene().getWindow().hide();
        		}
        		else {
        			Alert alert = new Alert(AlertType.WARNING);
        			alert.setTitle("Alerta");
        			alert.setHeaderText(null);
        			alert.setContentText("Clave incorrecta");
        			alert.showAndWait();
        			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("IngresoProfesor.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root1));  
                    stage.setTitle("Ingreso Profesor");
                    stage.show();
                    ((Node)(event.getSource())).getScene().getWindow().hide();
        		}
    		}
    		else {
    			Alert alert = new Alert(AlertType.WARNING);
    			alert.setTitle("Alerta");
    			alert.setHeaderText(null);
    			alert.setContentText("Usurio y/o clave incorrecta");
    			alert.showAndWait();
    			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("IngresoProfesor.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));  
                stage.setTitle("Ingreso Profesor");
                stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
    		}
    			
        } 
    	catch(Exception e) {
        e.printStackTrace();
    	}
    }
}
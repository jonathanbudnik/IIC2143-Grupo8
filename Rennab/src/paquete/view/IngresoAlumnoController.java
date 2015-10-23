package paquete.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import paquete.MainApp;
import paquete.Serializador;
import paquete.model.Alumno;

public class IngresoAlumnoController {

    // Reference to the main application.
    private MainApp mainApp;

    public IngresoAlumnoController() {
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
        			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MenuAlumno.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root1));  
                    stage.setTitle("Menú Alumno");
                    stage.show();
                    ((Node)(event.getSource())).getScene().getWindow().hide();
        		}
        		else {
        			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("IngresoAlumno.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root1));  
                    stage.setTitle("Ingreso Alumno");
                    stage.show();
                    ((Node)(event.getSource())).getScene().getWindow().hide();
        		}
    		}
    		else {
    			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("IngresoAlumno.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));  
                stage.setTitle("Ingreso Alumno");
                stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
    		}
    			
        } 
    	catch(Exception e) {
        e.printStackTrace();
    	}
    }
}
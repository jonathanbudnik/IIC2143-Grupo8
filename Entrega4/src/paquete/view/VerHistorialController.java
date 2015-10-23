package paquete.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import paquete.MainApp;

public class VerHistorialController {

    // Reference to the main application.
    private MainApp mainApp;

    public VerHistorialController() {
    }

    @FXML
    private void initialize() {
    	actualizarPantalla();
    }
    @FXML
    public Label label;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    @FXML
    public void actualizarPantalla(){
        label.setText(MainApp.alumno.obtenerHistorialAcademico());
    }
    @FXML
    private void handleVolverAction(ActionEvent event){
    	try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MenuAlumno.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));  
            stage.setTitle("MenuAlumno");
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        } 
    	catch(Exception e) {
        e.printStackTrace();
    	}
    }
}
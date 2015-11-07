package paquete.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import paquete.MainApp;

public class VerProgramaController {

    // Reference to the main application.
    private MainApp mainApp;

    public VerProgramaController() {
    }

    @FXML
    private void initialize(){
    	label.setText(MainApp.alumno.obtenerPrograma(MainApp.sigla_temp));
    }
    
    @FXML
    public Label label;

    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}
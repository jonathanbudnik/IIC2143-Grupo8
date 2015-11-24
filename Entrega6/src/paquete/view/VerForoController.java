package paquete.view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import paquete.MainApp;

public class VerForoController {

    // Reference to the main application.
    private MainApp mainApp;

    public VerForoController() {
    }

    @FXML
    private void initialize() {
    	label1.setText(MainApp.alumno.obtenerForo(MainApp.sigla_temp));
    }
    @FXML
    public Button button1;
    @FXML
    public Label label1;
    @FXML
    public TextField texto1;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
    @FXML
    private void handleEscribirAction(ActionEvent event) {
    	try {
    		MainApp.alumno.escribirForo(texto1.getText().toString(), MainApp.sigla_temp);
    		label1.setText(MainApp.alumno.obtenerForo(MainApp.sigla_temp));
    		texto1.setText(null);
        }
    	catch(Exception e) {
        e.printStackTrace();
    	}
    }
}
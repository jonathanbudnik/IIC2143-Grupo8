package paquete.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import paquete.MainApp;

public class ElegirMallaController {

    // Reference to the main application.
    private MainApp mainApp;

    public ElegirMallaController() {
    }

    @FXML
    private void initialize() {
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    @FXML
    private void handleSeleccionarAction(ActionEvent event) {
    	try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CrearSemestre.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));  
            stage.setTitle("Crear Semestre");
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        } 
    	catch(Exception e) {
        e.printStackTrace();
    	}
    }
}
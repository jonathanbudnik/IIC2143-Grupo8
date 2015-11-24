package paquete.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import paquete.MainApp;
import paquete.model.Malla;

public class ElegirMallaController {

    // Reference to the main application.
    private MainApp mainApp;

    public ElegirMallaController() {
    }

    @FXML
    private void initialize() {
    }
    @FXML
    public TextField texto;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    @FXML
    private void handleSeleccionarAction(ActionEvent event) {
    	try {
    		Malla m = new Malla(texto.getText());
    		MainApp.alumno.elegirMalla(m);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MenuAlumno.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));  
            stage.setTitle("Menú Alumno");
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        } 
    	catch(Exception e) {
        e.printStackTrace();
    	}
    }
}
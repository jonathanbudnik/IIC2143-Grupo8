package paquete.view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import paquete.MainApp;

public class BorrarRamoController {

    // Reference to the main application.
    private MainApp mainApp;

    public BorrarRamoController() {
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
    private void handleBorrarAction(ActionEvent event) {
    	try {
    		MainApp.admin.eliminarCurso(texto.getText());
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MenuAdmin.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));  
            stage.setTitle("Menú Administrador");
            stage.show();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        } 
    	catch(Exception e) {
        e.printStackTrace();
    	}
    }
}
package paquete.view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import paquete.MainApp;

public class BotarRamoController {

    // Reference to the main application.
    private MainApp mainApp;

    public BotarRamoController() {
    }

    @FXML
    private void initialize() {
    	label.setText(MainApp.alumno.obtenerCargaAcademica().obtenerSemestre(MainApp.alumno.obtenerCargaAcademica().obtenerSemestres().size()-1).toString());
    }
    @FXML
    public TextField texto;
    @FXML
    public Label label;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    @FXML
    private void handleBorrarAction(ActionEvent event) {
    	try {
    		MainApp.alumno.obtenerCargaAcademica().obtenerSemestre(MainApp.alumno.obtenerCargaAcademica().obtenerSemestres().size()-1).botarRamo(texto.getText().toString().toUpperCase());;
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